package com.example.weibiansanjueserver.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.weibiansanjueserver.dao.UserDao;
import com.example.weibiansanjueserver.entity.Books;
import com.example.weibiansanjueserver.entity.Chapter;
import com.example.weibiansanjueserver.entity.User;
import com.example.weibiansanjueserver.service.BookService;
import com.example.weibiansanjueserver.service.ChapterService;
import com.example.weibiansanjueserver.service.UserService;
import com.example.weibiansanjueserver.utils.JSONResult;
import com.example.weibiansanjueserver.vo.UserVO;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author zhangxu
 * @title
 * @date 2020/2/18 15:41
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @Autowired
    private Sid sid;

    @Autowired
    private ChapterService chapterService;


    //获取用户信息
    @GetMapping("/getuserinfo")
    public JSONResult getUserInfo(String userId){
        User user = userService.queryUser(userId);
        int i=1;
        return JSONResult.ok(user);

    }

    //获取关注列表
    @GetMapping("/getfollows")
    public JSONResult getFollows(String userId){
        List<UserVO> userFollows = userService.userFollows(userId);
        return JSONResult.ok(userFollows);
    }

    //获取粉丝列表
    @GetMapping("/getfans")
    public JSONResult getFans(String userId){
        List<UserVO> userVOList = userService.userFans(userId);
        return JSONResult.ok(userVOList);
    }

    //关注
    @GetMapping("/followme")
    public JSONResult followMe(String userId,String fansId){
        userService.saveUserFollow(userId,fansId);
        return JSONResult.ok("关注成功");
    }

    //取消关注
    @GetMapping("/unfollow")
    public JSONResult unFollow(String userId,String fansId){
        userService.reduceFollow(userId,fansId);
        return JSONResult.ok("取消成功");
    }

    //获取个人发布的图书
    @GetMapping("/mybook")
    public JSONResult myBooks(String userId,
                              @RequestParam(value = "page",defaultValue = "1") Integer page,
                              @RequestParam(value = "size",defaultValue = "9")Integer size){
        IPage<Books> myBooks = bookService.getMyBooks(userId, page, size);
        return JSONResult.ok(myBooks);
    }

    //发布图书
    @PostMapping("/uploadbook")
    public JSONResult releaseBook(String userId,String bookName,String bookDesc,
                                  String chapterContent,String chapterTitle,
                                  @RequestParam("file") MultipartFile multipartFile) throws IOException {
        //文件命名空间
        String fileSpace="E:\\weibiansanjue";
        //保存到数据库的相对路径
        String uploadPathDB="/"+userId+"/"+bookName;

        FileOutputStream fileOutputStream=null;
        InputStream inputStream=null;

        try {
            if (multipartFile!=null){


                String fileName=multipartFile.getOriginalFilename();
                if (StringUtils.isNotBlank(fileName)){
                    String finalPath=fileSpace+uploadPathDB+"/"+fileName;
                    uploadPathDB+=("/"+fileName);

                    File outfile=new File(finalPath);
                    if (outfile.getParentFile()!=null||!outfile.getParentFile().isDirectory()){
                        //创建父文件夹
                        outfile.getParentFile().mkdirs();
                    }
                    fileOutputStream=new FileOutputStream(outfile);
                    inputStream= multipartFile.getInputStream();
                    IOUtils.copy(inputStream,fileOutputStream);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (fileOutputStream!=null){
                fileOutputStream.flush();
                fileOutputStream.close();
            }
        }
        Books books=new Books();
        String bookId=sid.nextShort();
        books.setBookId(bookId);
        books.setUserId(userId);
        books.setBookName(bookName);
        books.setBookDesc(bookDesc);
        books.setBookIcon(uploadPathDB);
        bookService.saveBook(books);

        Chapter chapter=new Chapter();
        chapter.setBookId(bookId);
        chapter.setUserId(userId);
        chapter.setChapterTitle(chapterTitle);
        chapter.setChapterContent(chapterContent);
        chapterService.saveChapter(chapter);

        return JSONResult.ok(uploadPathDB);
    }

}

package com.example.weibiansanjueserver.controller;

import com.example.weibiansanjueserver.entity.Books;
import com.example.weibiansanjueserver.entity.Chapter;
import com.example.weibiansanjueserver.service.BookService;
import com.example.weibiansanjueserver.service.ChapterService;
import com.example.weibiansanjueserver.utils.JSONResult;
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
 * @date 2020/2/23 21:18
 */

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private ChapterService chapterService;

    @Autowired
    private Sid sid;

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

    //根据id查询书籍
    @GetMapping("/getbookid")
    public JSONResult getBookId(String bookId){
        Books book = bookService.getBookById(bookId);
        return JSONResult.ok(book);
    }

    //书城正在热更
    @GetMapping("/hotupdate")
    public JSONResult hotUpdate(){
        List<Books> booksList = bookService.onUpdate();
        return JSONResult.ok(booksList);
    }

    //书城已完结
    @GetMapping("/finish")
    public JSONResult finish(){
        List<Books> booksList = bookService.finish();
        return JSONResult.ok(booksList);
    }

    //收藏图书
    @GetMapping("/collectbook")
    public JSONResult collectBook(String userId,String bookId){
        bookService.collectBook(userId,bookId);
        return JSONResult.ok();
    }

    //取消收藏
    @GetMapping("/uncollect")
    public JSONResult unCollect(String userId,String bookId){
        bookService.unCollect(userId,bookId);
        return JSONResult.ok();
    }

    //获取自己的收藏图书
    @GetMapping("/mycollect")
    public JSONResult myCollect(String userId){
        List<Books> books = bookService.myCollect(userId);
        return JSONResult.ok(books);
    }
}

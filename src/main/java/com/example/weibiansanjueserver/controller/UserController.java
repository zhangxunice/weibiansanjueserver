package com.example.weibiansanjueserver.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.weibiansanjueserver.entity.Books;
import com.example.weibiansanjueserver.entity.User;
import com.example.weibiansanjueserver.service.BookService;
import com.example.weibiansanjueserver.service.UserService;
import com.example.weibiansanjueserver.utils.JSONResult;
import com.example.weibiansanjueserver.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    //查看他人的作品
    @GetMapping("/otherbooks")
    public JSONResult getOtherBooks(String userId,
                                    @RequestParam(value = "page",defaultValue = "1") Integer page,
                                    @RequestParam(value = "size",defaultValue = "6")Integer size){
        IPage<Books> otherBooks = bookService.getOtherBooks(userId, page, size);
        return JSONResult.ok(otherBooks);
    }


}

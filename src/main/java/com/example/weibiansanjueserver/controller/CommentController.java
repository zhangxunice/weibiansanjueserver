package com.example.weibiansanjueserver.controller;

import com.example.weibiansanjueserver.entity.Comments;
import com.example.weibiansanjueserver.service.CommentService;
import com.example.weibiansanjueserver.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zhangxu
 * @title
 * @date 2020/5/9 11:46
 */

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/getcomments")
    public JSONResult getComments(String bookId){
        List<Comments> comments = commentService.getByBookId(bookId);
        return JSONResult.ok(comments);
    }

    @PostMapping ("/addcomments")
    public JSONResult addComments(@RequestBody Comments comments){
        commentService.addComment(comments);
        return JSONResult.ok("ok");
    }
}

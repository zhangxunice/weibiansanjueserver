package com.example.weibiansanjueserver.service;

import com.example.weibiansanjueserver.entity.Comments;

import java.util.List;

/**
 * @author zhangxu
 * @title
 * @date 2020/5/9 11:42
 */
public interface CommentService {

    //根据书籍id查看评论
    List<Comments> getByBookId(String bookId);

    //发布评论
    void addComment(Comments comments);
}

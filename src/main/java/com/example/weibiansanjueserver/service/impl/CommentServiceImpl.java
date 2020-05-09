package com.example.weibiansanjueserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.weibiansanjueserver.dao.CommentDao;
import com.example.weibiansanjueserver.entity.Comments;
import com.example.weibiansanjueserver.service.CommentService;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhangxu
 * @title
 * @date 2020/5/9 11:42
 */

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private Sid sid;

    @Override
    public List<Comments> getByBookId(String bookId) {
        QueryWrapper<Comments> queryWrapper=new QueryWrapper<>();
        queryWrapper.like("wchapter_id",bookId).orderByDesc("create_time");
        List<Comments> comments = commentDao.selectList(queryWrapper);
        return comments;
    }

    @Override
    public void addComment(Comments comments) {
        String id=sid.nextShort();
        comments.setId(id);
        commentDao.insert(comments);

    }
}

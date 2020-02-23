package com.example.weibiansanjueserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.weibiansanjueserver.dao.BooksDao;
import com.example.weibiansanjueserver.entity.Books;
import com.example.weibiansanjueserver.service.BookService;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhangxu
 * @title
 * @date 2020/2/22 12:17
 */

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BooksDao booksDao;

    @Autowired
    private Sid sid;

    @Override
    public IPage<Books> getMyBooks(String userId, Integer page,Integer size) {
        QueryWrapper<Books> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("user_id",userId);
        Page<Books> studentPage = new Page<Books>(page,size);
        IPage<Books> booksIPage = booksDao.selectPage(studentPage, queryWrapper);
        return booksIPage;
    }

    @Override
    public void saveBook(Books books) {
//        String bookId=sid.nextShort();
//        books.setBookId(bookId);
        booksDao.insert(books);
    }
}

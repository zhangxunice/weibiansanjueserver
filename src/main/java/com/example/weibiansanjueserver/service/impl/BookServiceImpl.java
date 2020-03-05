package com.example.weibiansanjueserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.weibiansanjueserver.dao.BooksDao;
import com.example.weibiansanjueserver.entity.Books;
import com.example.weibiansanjueserver.enums.BookStatusEnum;
import com.example.weibiansanjueserver.service.BookService;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        queryWrapper.eq("user_id",userId).orderByDesc("create_time");
        Page<Books> booksPage = new Page<Books>(page,size);
        IPage<Books> booksIPage = booksDao.selectPage(booksPage, queryWrapper);
        return booksIPage;
    }

    @Override
    public void saveBook(Books books) {

        booksDao.insert(books);
    }

    @Override
    public IPage<Books> getOtherBooks(String userId, Integer page, Integer size) {
        QueryWrapper<Books> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("user_id",userId).ne("book_status", BookStatusEnum.CHECK.getCode());
        Page<Books> studentPage = new Page<Books>(page,size);
        IPage<Books> booksIPage = booksDao.selectPage(studentPage, queryWrapper);
        return booksIPage;
    }

    @Override
    public List<Books> onUpdate() {
        QueryWrapper<Books> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("book_status",BookStatusEnum.NEW.getCode())
                .orderByDesc("book_follows").last("limit 6");
        List<Books> booksList = booksDao.selectList(queryWrapper);
        return booksList;
    }

    @Override
    public List<Books> finish() {
        QueryWrapper<Books> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("book_status",BookStatusEnum.FINISH.getCode())
                .orderByDesc("book_follows").last("limit 3");
        List<Books> booksList = booksDao.selectList(queryWrapper);
        return booksList;
    }

    @Override
    public IPage<Books> booksList(Integer page, Integer size) {
        QueryWrapper<Books> queryWrapper=new QueryWrapper<>();
        queryWrapper.orderByDesc("update_time").ne("book_status",BookStatusEnum.CHECK.getCode())
                .ne("book_status",BookStatusEnum.UN_CHECK.getCode());
        Page<Books> booksPage = new Page<Books>(page,size);
        IPage<Books> booksIPage = booksDao.selectPage(booksPage,queryWrapper);
        return booksIPage;
    }

    @Override
    public IPage<Books> checkBooksList(Integer page, Integer size) {
        QueryWrapper<Books> queryWrapper=new QueryWrapper<>();
        queryWrapper.orderByDesc("create_time").eq("book_status",BookStatusEnum.CHECK.getCode());
        Page<Books> booksPage = new Page<Books>(page,size);
        IPage<Books> booksIPage = booksDao.selectPage(booksPage,queryWrapper);
        return booksIPage;
    }

    @Override
    @Transactional
    public void successCheck(String bookId) {
        QueryWrapper<Books> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("book_id",bookId);
        Books books = booksDao.selectOne(queryWrapper);
        books.setBookStatus(BookStatusEnum.NEW.getCode());
        booksDao.update(books,queryWrapper);

    }

    @Override
    @Transactional
    public void unCheck(String bookId) {
        QueryWrapper<Books> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("book_id",bookId);
        Books books = booksDao.selectOne(queryWrapper);
        books.setBookStatus(BookStatusEnum.UN_CHECK.getCode());
        booksDao.update(books,queryWrapper);

    }

    @Override
    @Transactional
    public void finish(String bookId) {
        QueryWrapper<Books> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("book_id",bookId);
        Books books = booksDao.selectOne(queryWrapper);
        books.setBookStatus(BookStatusEnum.FINISH.getCode());
        booksDao.update(books,queryWrapper);

    }
}

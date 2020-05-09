package com.example.weibiansanjueserver.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.weibiansanjueserver.dao.BooksDao;
import com.example.weibiansanjueserver.entity.Books;

import java.awt.print.Book;
import java.util.List;

/**
 * @author zhangxu
 * @title
 * @date 2020/2/22 12:17
 */
public interface BookService {

    //查询用户自己的书
    IPage<Books> getMyBooks(String userId, Integer page,Integer size);

    //根据id查询书籍
    Books getBookById(String id);

    //发布图书
    void saveBook(Books books);

    //获取他人图书列表
    IPage<Books> getOtherBooks(String userId, Integer page,Integer size);

    //书城首页正在热更
    List<Books> onUpdate();

    //书城首页已完结
    List<Books> finish();

    //收藏图书
    void collectBook(String userId,String bookId);

    //取消收藏
    void unCollect(String userId,String bookId);

    //获取自己收藏的图书
    List<Books> myCollect(String userId);

    //查询所有通过审核书
    IPage<Books> booksList(Integer page,Integer size);

    //查询为通过审核的数
    IPage<Books> checkBooksList(Integer page,Integer size);

    //通过审核
    void successCheck(String bookId);

    //驳回
    void unCheck(String bookId);

    //完结
    void finish(String bookId);


}

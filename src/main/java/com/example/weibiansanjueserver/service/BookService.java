package com.example.weibiansanjueserver.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.weibiansanjueserver.dao.BooksDao;
import com.example.weibiansanjueserver.entity.Books;

/**
 * @author zhangxu
 * @title
 * @date 2020/2/22 12:17
 */
public interface BookService {

    //查询用户自己的书
    IPage<Books> getMyBooks(String userId, Integer page,Integer size);

    //发布图书
    void saveBook(Books books);

}

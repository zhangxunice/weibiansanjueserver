package com.example.weibiansanjueserver.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.weibiansanjueserver.dao.BooksDao;
import com.example.weibiansanjueserver.entity.Books;

import java.util.List;

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

    //获取他人图书列表
    IPage<Books> getOtherBooks(String userId, Integer page,Integer size);

    //书城首页正在热更
    List<Books> onUpdate();

    //书城首页已完结
    List<Books> finish();

}
package com.example.weibiansanjueserver.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.weibiansanjueserver.entity.Books;

import java.util.List;

/**
 * @author zhangxu
 * @title
 * @date 2020/5/9 8:37
 */
public interface SearchService {

    //获取热搜词
    List<String> getHotWords();

    //保存热搜词
    void saveContent(String content);

    //搜索到的图书
    IPage<Books> getSearchBooks(String content, Integer page, Integer size);
}

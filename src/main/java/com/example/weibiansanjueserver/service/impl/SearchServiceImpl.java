package com.example.weibiansanjueserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.weibiansanjueserver.dao.BooksDao;
import com.example.weibiansanjueserver.dao.SearchDao;
import com.example.weibiansanjueserver.entity.Books;
import com.example.weibiansanjueserver.entity.Search;
import com.example.weibiansanjueserver.enums.BookStatusEnum;
import com.example.weibiansanjueserver.service.SearchService;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhangxu
 * @title
 * @date 2020/5/9 8:38
 */

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private SearchDao searchDao;

    @Autowired
    private Sid sid;

    @Autowired
    private BooksDao booksDao;

    @Override
    public List<String> getHotWords() {
        List<String> hotWords = searchDao.getHotWords();
        return hotWords;
    }

    @Override
    public void saveContent(String content) {
        String id=sid.nextShort();
        Search search=new Search();
        search.setId(id);
        search.setContent(content);
        searchDao.insert(search);
    }

    @Override
    public IPage<Books> getSearchBooks(String content, Integer page, Integer size) {
        QueryWrapper<Books> queryWrapper=new QueryWrapper<>();
        queryWrapper.like("book_name",content).ne("book_status", BookStatusEnum.CHECK.getCode());
        Page<Books> studentPage = new Page<Books>(page,size);
        IPage<Books> booksIPage = booksDao.selectPage(studentPage, queryWrapper);
        return booksIPage;
    }
}

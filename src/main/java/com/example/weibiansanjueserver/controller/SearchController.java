package com.example.weibiansanjueserver.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.weibiansanjueserver.entity.Books;
import com.example.weibiansanjueserver.service.SearchService;
import com.example.weibiansanjueserver.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zhangxu
 * @title
 * @date 2020/5/9 8:34
 */

@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private SearchService searchService;


    //获取热搜词
    @GetMapping("/hotwords")
    public JSONResult getHotWords(){
        List<String> hotWords = searchService.getHotWords();
        return JSONResult.ok(hotWords);
    }

    //存储热搜词
    @GetMapping("/savecontent")
    public JSONResult saveContent(String content){
        searchService.saveContent(content);
        return JSONResult.ok("ok");
    }

    //获取搜索的图书
    @GetMapping ("/searchbook")
    public JSONResult searchBook(String content,
                              @RequestParam(value = "page",defaultValue = "1") Integer page,
                              @RequestParam(value = "size",defaultValue = "6")Integer size){
        IPage<Books> myBooks = searchService.getSearchBooks(content,page,size);
        return JSONResult.ok(myBooks);
    }
}

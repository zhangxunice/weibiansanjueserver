package com.example.weibiansanjueserver.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.weibiansanjueserver.entity.Search;

import java.util.List;

/**
 * @author zhangxu
 * @title
 * @date 2020/5/9 8:40
 */
public interface SearchDao extends BaseMapper<Search> {

    //查询热搜词
    List<String> getHotWords();




}

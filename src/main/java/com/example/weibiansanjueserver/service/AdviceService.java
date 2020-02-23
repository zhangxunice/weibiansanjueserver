package com.example.weibiansanjueserver.service;

import com.example.weibiansanjueserver.entity.Advice;

import java.util.List;

/**
 * @author zhangxu
 * @title
 * @date 2020/2/21 13:34
 */
public interface AdviceService  {

    //保存建议
    void saveAdvice(Advice advice);

    //查看建议
    List<Advice> findAdvice();
}

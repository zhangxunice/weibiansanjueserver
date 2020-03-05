package com.example.weibiansanjueserver.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.weibiansanjueserver.entity.Advice;
import com.example.weibiansanjueserver.vo.AdviceVO;

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
    IPage<AdviceVO> findAdvice(Integer page, Integer size);
}

package com.example.weibiansanjueserver.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.weibiansanjueserver.entity.Advice;
import com.example.weibiansanjueserver.vo.AdviceVO;

/**
 * @author zhangxu
 * @title
 * @date 2020/2/21 13:38
 */
public interface AdviceDao extends BaseMapper<Advice> {

    IPage<AdviceVO> findAll(Page page);
}

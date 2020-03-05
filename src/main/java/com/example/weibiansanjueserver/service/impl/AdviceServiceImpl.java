package com.example.weibiansanjueserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.weibiansanjueserver.dao.AdviceDao;
import com.example.weibiansanjueserver.entity.Advice;
import com.example.weibiansanjueserver.service.AdviceService;
import com.example.weibiansanjueserver.vo.AdviceVO;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhangxu
 * @title
 * @date 2020/2/21 13:36
 */

@Service
public class AdviceServiceImpl implements AdviceService {

    @Autowired
    private AdviceDao adviceDao;

    @Autowired
    private Sid sid;

    @Override
    public void saveAdvice(Advice advice) {
        String id=sid.nextShort();
        advice.setId(id);
        adviceDao.insert(advice);
    }

    @Override
    public IPage<AdviceVO> findAdvice(Integer page,Integer size) {
        Page<Advice> advicePage=new Page<>(page,size);
//        QueryWrapper<Advice> queryWrapper=new QueryWrapper<>();
//        queryWrapper.orderByDesc("create_time");
        IPage<AdviceVO> adviceList = adviceDao.findAll(advicePage);

        return adviceList;
    }
}

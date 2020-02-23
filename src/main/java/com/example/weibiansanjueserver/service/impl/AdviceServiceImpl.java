package com.example.weibiansanjueserver.service.impl;

import com.example.weibiansanjueserver.dao.AdviceDao;
import com.example.weibiansanjueserver.entity.Advice;
import com.example.weibiansanjueserver.service.AdviceService;
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
    public List<Advice> findAdvice() {
        List<Advice> adviceList = adviceDao.selectList(null);
        return adviceList;
    }
}

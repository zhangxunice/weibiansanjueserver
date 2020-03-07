package com.example.weibiansanjueserver.service.impl;

import com.example.weibiansanjueserver.dao.SwiperDao;
import com.example.weibiansanjueserver.entity.Swiper;
import com.example.weibiansanjueserver.service.SwiperService;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zhangxu
 * @title
 * @date 2020/3/7 11:09
 */

@Service
public class SwiperServiceImpl implements SwiperService {

    @Autowired
    private SwiperDao swiperDao;

    @Autowired
    private Sid sid;

    @Override
    public List<Swiper> findAll() {
        List<Swiper> swipers = swiperDao.selectList(null);
        return swipers;
    }

    @Override
    @Transactional
    public void addSwiper(Swiper swiper) {
        String id=sid.nextShort();
        swiper.setId(id);
        swiperDao.insert(swiper);

    }

    @Override
    public void delSwiper(String id) {
        swiperDao.deleteById(id);
    }
}

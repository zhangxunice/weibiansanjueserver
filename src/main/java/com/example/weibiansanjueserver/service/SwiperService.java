package com.example.weibiansanjueserver.service;

import com.example.weibiansanjueserver.entity.Swiper;

import java.util.List;

/**
 * @author zhangxu
 * @title
 * @date 2020/3/7 11:02
 */
public interface SwiperService {

    //查看所有轮播图
    List<Swiper> findAll();

    //添加轮播图
    void addSwiper(Swiper swiper);

    //删除轮播图
    void delSwiper(String id);
}

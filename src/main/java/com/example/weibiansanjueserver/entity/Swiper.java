package com.example.weibiansanjueserver.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author zhangxu
 * @title
 * @date 2020/3/7 10:59
 */

@Data
public class Swiper {

    private String id;

    private String imgUrl;

    private Date createTime;

    private Date updateTime;
}

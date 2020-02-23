package com.example.weibiansanjueserver.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author zhangxu
 * @title
 * @date 2020/2/21 13:32
 */

@Data
public class Advice {

    private String id;

    private String userId;

    private String content;

    private String userPhone;

    private Date createTime;
}

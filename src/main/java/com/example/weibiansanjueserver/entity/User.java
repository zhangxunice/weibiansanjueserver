package com.example.weibiansanjueserver.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author zhangxu
 * @title
 * @date 2020/2/17 11:53
 */
@Data
public class User {

    private String userId;

    private String nickName;

    private String faceImage;

    private Integer bookCounts;

    private Integer fansCounts;

    private Integer followCounts;

    private Date createTime;
}

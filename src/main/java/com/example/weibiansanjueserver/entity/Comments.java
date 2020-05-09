package com.example.weibiansanjueserver.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author zhangxu
 * @title
 * @date 2020/5/9 11:38
 */

@Data
public class Comments {

    private String id;

    private String fatherId;

    private String userId;

    private String toUserId;

    private String wchapterId;

    private String content;

    private Date createTime;

    private String faceImg;

    private String userName;
}

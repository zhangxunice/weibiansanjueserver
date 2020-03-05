package com.example.weibiansanjueserver.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author zhangxu
 * @title
 * @date 2020/3/4 19:45
 */
@Data
public class AdviceVO {

    private String id;

    private String userId;

    private String nickName;

    private String content;

    private String userPhone;

    private Date createTime;
}

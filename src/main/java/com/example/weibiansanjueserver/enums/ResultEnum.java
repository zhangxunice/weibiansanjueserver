package com.example.weibiansanjueserver.enums;

import lombok.Getter;

/**
 * @author zhangxu
 * @title
 * @date 2020/3/5 13:53
 */

@Getter
public enum  ResultEnum {

    SUCCESS_CHECK(200,"审核通过,操作成功"),
    un_CHECK(201,"驳回操作成功");

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}

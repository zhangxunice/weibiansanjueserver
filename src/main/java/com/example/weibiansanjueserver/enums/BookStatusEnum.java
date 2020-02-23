package com.example.weibiansanjueserver.enums;

import lombok.Getter;

/**
 * @author zhangxu
 * @title
 * @date 2020/2/22 12:13
 */

@Getter
public enum BookStatusEnum {
    CHECK(0,"审核中"),
    NEW(1,"连载中"),
    FINISH(2,"已完结");

    private Integer code;

    private String msg;

    BookStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }}

package com.example.weibiansanjueserver.enums;

import lombok.Getter;

/**
 * @author zhangxu
 * @title
 * @date 2020/3/6 19:43
 */

@Getter
public enum AdminStatusEnum implements CodeEnum {

    NORMAL(0,"正常"),
    DISABLE(1,"禁用");

    private Integer code;

    private String msg;

    AdminStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }}

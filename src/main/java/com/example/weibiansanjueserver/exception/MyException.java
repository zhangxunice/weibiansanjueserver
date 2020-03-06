package com.example.weibiansanjueserver.exception;

import com.example.weibiansanjueserver.enums.ResultEnum;

/**
 * @author zhangxu
 * @title
 * @date 2020/3/6 10:30
 */
public class MyException extends RuntimeException {

    private Integer code;

    public MyException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }
}

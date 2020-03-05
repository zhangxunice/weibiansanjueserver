package com.example.weibiansanjueserver.utils;

import com.example.weibiansanjueserver.enums.CodeEnum;

/**
 * @author zhangxu
 * @title
 * @date 2020/3/4 19:30
 */
public class EnumUtil {
    public static <T extends CodeEnum>T getByCode(Integer code, Class<T> enumsClass){

        for (T each:enumsClass.getEnumConstants()){
            if (code.equals(each.getCode())){
                return each;
            }
        }
        return null;
    }
}

package com.example.weibiansanjueserver.entity;

import com.example.weibiansanjueserver.enums.AdminStatusEnum;
import com.example.weibiansanjueserver.enums.BookStatusEnum;
import com.example.weibiansanjueserver.utils.EnumUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;

/**
 * @author zhangxu
 * @title
 * @date 2020/3/5 20:05
 */

@Data
public class Admin {

    private String id;

    private String name;

    private String password;

    private Integer status= AdminStatusEnum.NORMAL.getCode();

    private Date createTime;

    private String updateTime;

    @JsonIgnore
    public AdminStatusEnum adminStatusEnum(){
        return EnumUtil.getByCode(status,AdminStatusEnum.class );}
}

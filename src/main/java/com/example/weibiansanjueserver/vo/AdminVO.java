package com.example.weibiansanjueserver.vo;

import com.example.weibiansanjueserver.entity.Role;
import com.example.weibiansanjueserver.enums.AdminStatusEnum;
import com.example.weibiansanjueserver.utils.EnumUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;
import java.util.Set;

/**
 * @author zhangxu
 * @title
 * @date 2020/3/6 14:19
 */

@Data
public class AdminVO {

    private String id;

    private String name;

    private String password;

    private Integer status=AdminStatusEnum.NORMAL.getCode();

    private Date createTime;

    private String updateTime;

    private Set<Role> roles;

    @JsonIgnore
    public AdminStatusEnum adminStatusEnum(){
        return EnumUtil.getByCode(status,AdminStatusEnum.class );}
}

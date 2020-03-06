package com.example.weibiansanjueserver.entity;

import lombok.Data;

/**
 * @author zhangxu
 * @title
 * @date 2020/3/5 20:05
 */

@Data
public class Role {

    private String id;

    private String roleName;

    private String permissions;
}

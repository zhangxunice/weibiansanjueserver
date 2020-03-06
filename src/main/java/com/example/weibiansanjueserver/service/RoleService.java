package com.example.weibiansanjueserver.service;

import com.example.weibiansanjueserver.entity.Role;

import java.util.List;

/**
 * @author zhangxu
 * @title
 * @date 2020/3/6 14:23
 */
public interface RoleService {

    //根据角色id查权限
    Role queryById(String roleId);

    //查询所有角色
    List<Role> findAll();

}

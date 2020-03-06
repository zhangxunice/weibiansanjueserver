package com.example.weibiansanjueserver.service;

import com.example.weibiansanjueserver.entity.AdminRole;
import com.example.weibiansanjueserver.entity.Role;
import com.example.weibiansanjueserver.form.AdminForm;

import java.util.List;

/**
 * @author zhangxu
 * @title
 * @date 2020/3/6 14:24
 */
public interface AdminRoleService {

    //根据用户id查询角色
    List<AdminRole> findAll(String adminId);

    //修改用户角色
    void updateAdmin(AdminForm adminForm);
}

package com.example.weibiansanjueserver.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.weibiansanjueserver.entity.Admin;
import com.example.weibiansanjueserver.form.AdminForm;
import com.example.weibiansanjueserver.vo.AdminVO;

/**
 * @author zhangxu
 * @title
 * @date 2020/3/6 12:35
 */
public interface AdminService {

    //登录验证
    AdminVO queryAdmin(String userName);

    //所有管理员
    IPage<Admin> findAll(Integer page,Integer size);

    //添管理员
    void addAdmin(AdminForm adminForm);

    //根据id查找用户
    AdminVO queryAdminById(String adminId);

    //根据用户名查找
    Admin queryByName(String name);

    //禁用管理员
    void disableAdmin(String adminId);

    //恢复管理员
    void recoveryAdmin(String adminId);


}

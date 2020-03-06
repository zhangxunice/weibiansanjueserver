package com.example.weibiansanjueserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.weibiansanjueserver.dao.AdminRoleDao;
import com.example.weibiansanjueserver.entity.AdminRole;
import com.example.weibiansanjueserver.form.AdminForm;
import com.example.weibiansanjueserver.service.AdminRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zhangxu
 * @title
 * @date 2020/3/6 14:25
 */

@Service
public class AdminRoleServiceImpl  implements AdminRoleService {

    @Autowired
    private AdminRoleDao adminRoleDao;

    @Override
    public List<AdminRole> findAll(String adminId) {
        QueryWrapper<AdminRole> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("admin_id",adminId);
        List<AdminRole> adminRoles = adminRoleDao.selectList(queryWrapper);
        return adminRoles;
    }

    @Override
    @Transactional
    public void updateAdmin(AdminForm adminForm) {
        QueryWrapper<AdminRole> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("admin_id",adminForm.getAdminId());
        AdminRole adminRole = adminRoleDao.selectOne(queryWrapper);


        StringBuffer buf=new StringBuffer();
        for (int i=0;i<adminForm.getRoles().length;i++){
            buf.append(adminForm.getRoles()[i]);
            if (i!=adminForm.getRoles().length-1){
                buf.append(":");
            }
        }
        String roleId=buf.toString();
        adminRole.setRoleId(roleId);
        adminRoleDao.updateById(adminRole);
    }
}

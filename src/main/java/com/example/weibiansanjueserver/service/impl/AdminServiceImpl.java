package com.example.weibiansanjueserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.weibiansanjueserver.dao.AdminDao;
import com.example.weibiansanjueserver.dao.AdminRoleDao;
import com.example.weibiansanjueserver.entity.Admin;
import com.example.weibiansanjueserver.entity.AdminRole;
import com.example.weibiansanjueserver.entity.Role;
import com.example.weibiansanjueserver.enums.AdminStatusEnum;
import com.example.weibiansanjueserver.form.AdminForm;
import com.example.weibiansanjueserver.service.AdminRoleService;
import com.example.weibiansanjueserver.service.AdminService;
import com.example.weibiansanjueserver.service.RoleService;
import com.example.weibiansanjueserver.vo.AdminVO;
import com.example.weibiansanjueserver.vo.AdviceVO;
import org.n3r.idworker.Sid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zhangxu
 * @title
 * @date 2020/3/6 12:36
 */

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Autowired
    private AdminRoleDao adminRoleDao;

    @Autowired
    private Sid sid;

    @Autowired
    private RoleService roleService;

    @Autowired
    private AdminRoleService adminRoleService;

    @Override
    @Transactional
    public AdminVO queryAdmin(String userName) {
        QueryWrapper<Admin> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("name",userName).eq("status", AdminStatusEnum.NORMAL.getCode());
        Admin admin = adminDao.selectOne(queryWrapper);

        AdminVO adminVO=new AdminVO();
        BeanUtils.copyProperties(admin,adminVO);
        AdminRole adminRole1 = adminRoleDao.selectById(admin.getId());
        String roleId = adminRole1.getRoleId();
        String[] strArr = roleId.split(":");
        Set<Role> roleSet=new HashSet<>();
        for (String i:strArr){
            Role role = roleService.queryById(i);
            roleSet.add(role);
        }

        adminVO.setRoles(roleSet);
        return adminVO;
    }

    @Override
    public IPage<Admin> findAll(Integer page,Integer size) {
        Page<Admin> adminPage=new Page<>(page,size);
        IPage<Admin> adminIPage=adminDao.selectPage(adminPage,null);
        return adminIPage;
    }

    @Override
    @Transactional
    public void addAdmin(AdminForm adminForm) {
        Admin admin=new Admin();
        BeanUtils.copyProperties(adminForm,admin);
        String adminId=sid.nextShort();
        admin.setId(adminId);
        adminDao.insert(admin);

        StringBuffer buf=new StringBuffer();
        for (int i=0;i<adminForm.getRoles().length;i++){
            buf.append(adminForm.getRoles()[i]);
            if (i!=adminForm.getRoles().length-1){
                buf.append(":");
            }
        }
        String roleId=buf.toString();

        AdminRole adminRole=new AdminRole();
        String adminRoleId=sid.nextShort();
        adminRole.setId(adminRoleId);
        adminRole.setAdminId(adminId);
        adminRole.setRoleId(roleId);
        adminRoleDao.insert(adminRole);

    }

    @Override
    public AdminVO queryAdminById(String adminId) {
        QueryWrapper<Admin> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("id",adminId);
        Admin admin = adminDao.selectOne(queryWrapper);

        AdminVO adminVO=new AdminVO();
        BeanUtils.copyProperties(admin,adminVO);


        AdminRole adminRole1 = adminRoleDao.selectById(admin.getId());
        String roleId = adminRole1.getRoleId();
        String[] strArr = roleId.split(":");
        Set<Role> roleSet=new HashSet<>();
        for (String i:strArr){
            Role role = roleService.queryById(i);
            roleSet.add(role);
        }

        adminVO.setRoles(roleSet);
        return adminVO;
    }

    @Override
    public Admin queryByName(String name) {
        QueryWrapper<Admin> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("name",name);
        Admin admin = adminDao.selectOne(queryWrapper);
        return admin;
    }


}

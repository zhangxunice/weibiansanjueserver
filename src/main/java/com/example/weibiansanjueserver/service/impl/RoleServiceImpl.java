package com.example.weibiansanjueserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.weibiansanjueserver.dao.RoleDao;
import com.example.weibiansanjueserver.entity.Role;
import com.example.weibiansanjueserver.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhangxu
 * @title
 * @date 2020/3/6 14:31
 */

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public Role queryById(String roleId) {
        QueryWrapper<Role> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("id",roleId);
        Role role = roleDao.selectOne(queryWrapper);
        return role;
    }

    @Override
    public List<Role> findAll() {
        List<Role> roleList = roleDao.selectList(null);
        return roleList;
    }
}

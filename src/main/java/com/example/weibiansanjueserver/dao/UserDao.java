package com.example.weibiansanjueserver.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.weibiansanjueserver.entity.User;

import java.util.List;

/**
 * @author zhangxu
 * @title
 * @date 2020/2/17 11:55
 */
public interface UserDao extends BaseMapper<User> {

    //查询粉丝
    List<User> getFans(String userId);

    //增加粉丝数
    void addFanCount(String userId);

    //减少粉丝数
    void reduceFanCount(String userId);

    //增加关注
    void addFollersCount(String userId);

    //取消关注
    void reduceFollersCount(String userId);
}

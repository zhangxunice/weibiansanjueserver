package com.example.weibiansanjueserver.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.weibiansanjueserver.entity.User;
import com.example.weibiansanjueserver.vo.UserVO;

import java.util.List;

/**
 * @author zhangxu
 * @title
 * @date 2020/2/17 9:48
 */
public interface UserService {

    //查询用户是否存在
    boolean userIsExist(String openId);

    //添加用户
    void saveUser(User user);

    //修改用户信息
    void updataUser(User user);

    //根据id查询用户信息
    User queryUser(String userId);

    //关注用户列表
    List<UserVO> userFollows(String userId);

    //粉丝列表
    List<UserVO> userFans(String userId);

    //增加关注
    void saveUserFollow(String userId,String fansId);

    //减少关注
    void reduceFollow(String userId,String fansId);

    IPage<User> findAll(Integer page,Integer size);


}

package com.example.weibiansanjueserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.weibiansanjueserver.dao.UserDao;
import com.example.weibiansanjueserver.dao.UserFansDao;
import com.example.weibiansanjueserver.entity.User;
import com.example.weibiansanjueserver.entity.UserFans;
import com.example.weibiansanjueserver.service.UserService;
import com.example.weibiansanjueserver.vo.UserVO;
import org.n3r.idworker.Sid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangxu
 * @title
 * @date 2020/2/17 11:58
 */
@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserDao userDao;

    @Autowired
    private UserFansDao userFansDao;

    @Autowired
    private Sid sid;
    
    @Override
    public boolean userIsExist(String openId) {
        QueryWrapper<User> queryWrapper=new QueryWrapper();
        queryWrapper.eq("user_id",openId);
        User user = userDao.selectOne(queryWrapper);
        return user==null?true:false;
    }

    @Override
    public void saveUser(User user) {
        userDao.insert(user);
    }

    @Override
    public void updataUser(User user) {
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("user_id",user.getUserId());
        userDao.update(user,queryWrapper);
    }

    @Override
    public User queryUser(String userId) {
        QueryWrapper<User> queryWrapper=new QueryWrapper();
        queryWrapper.eq("user_id",userId);
        User user = userDao.selectOne(queryWrapper);
        return user;
    }

    @Override
    public List<UserVO> userFollows(String userId) {
        QueryWrapper<UserFans> queryWrapper=new QueryWrapper();
        queryWrapper.eq("fans_id",userId);
        List<UserFans> userFansList = userFansDao.selectList(queryWrapper);
        List<User> userList=userDao.selectList(null);
        List<UserVO> users=new ArrayList<>();
        for (UserFans userFans:userFansList){
            for (User user:userList){
                if (user.getUserId().equals(userFans.getUserId())){
                    UserVO userVO=new UserVO();
                    BeanUtils.copyProperties(user,userVO);
                    userVO.setIsFollow(true);
                    users.add(userVO);
                }
            }
        }

        return users;
    }

    @Override
    public List<UserVO> userFans(String userId) {
        QueryWrapper<UserFans> queryWrapper=new QueryWrapper();
        queryWrapper.eq("fans_id",userId);
        List<UserFans> userFansList = userFansDao.selectList(queryWrapper);
        List<User> fans = userDao.getFans(userId);

        List<UserVO> userVOList=new ArrayList<>();
        //数据拼装
        for (User user:fans){
            UserVO userVO=new UserVO();
            BeanUtils.copyProperties(user,userVO);
            for (UserFans userFans:userFansList){
                if (user.getUserId().equals(userFans.getUserId())){
                    userVO.setIsFollow(true);
                }
            }
            userVOList.add(userVO);
        }
        return userVOList;
    }

    //关注
    @Transactional
    @Override
    public void saveUserFollow(String userId, String fansId) {
        String id= sid.nextShort();
        UserFans userFans=new UserFans();
        userFans.setId(id);
        userFans.setUserId(userId);
        userFans.setFansId(fansId);
        userFansDao.insert(userFans);
        userDao.addFollersCount(fansId);
        userDao.addFanCount(userId);
    }

    //取消关注
    @Transactional
    @Override
    public void reduceFollow(String userId, String fansId) {
        QueryWrapper<UserFans> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("user_id",userId).eq("fans_id",fansId);
        userFansDao.delete(queryWrapper);
        userDao.reduceFollersCount(fansId);
        userDao.reduceFanCount(userId);
    }
}

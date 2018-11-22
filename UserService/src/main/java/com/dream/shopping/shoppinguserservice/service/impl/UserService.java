package com.dream.shopping.shoppinguserservice.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.dream.shopping.facade.po.User;
import com.dream.shopping.shoppinguserservice.mapper.UserMapper;
import com.dream.shopping.shoppinguserservice.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 描述:user的service实现层
 * Created with IntelliJ IDEA.
 * User: sky
 * Date: 2018/11/20
 * Time: 12:21
 */
@Component
@Service(version = "1.0.0")
public class UserService implements IUserService {

    private final UserMapper userMapper;

    @Autowired
    public UserService (UserMapper userMapper){
        this.userMapper = userMapper;
    }

    @Override
    public Integer insertUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public Integer deleteUserById(Integer uId) {
        return userMapper.deleteUserById(uId);
    }

    @Override
    public Integer deleteByBatch(List<User> user) {
        return userMapper.deleteByBatch(user);
    }

    @Override
    public Integer deleteAll() {
        return userMapper.deleteAll();
    }

    @Override
    public User selectById(Integer uId) {
        return userMapper.selectById(uId);
    }

    @Override
    public List<User> selectByUser(User user) {
        return userMapper.selectByUser(user);
    }

    @Override
    public Integer updateUser(User user) {
        return userMapper.updateUser(user);
    }
}
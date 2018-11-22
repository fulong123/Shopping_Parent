package com.dream.shopping.managerweb.userService.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dream.shopping.facade.po.User;
import com.dream.shopping.shoppinguserservice.service.IUserService;
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
public class UserConsumerService implements IUserService {

    @Reference(version = "1.0.0",url = "dubbo://10.7.190.179:20880")
    private IUserService userService;

    @Override
    public Integer insertUser(User user) {
        return null;
    }

    @Override
    public Integer deleteUserById(Integer uId) {
        return null;
    }

    @Override
    public Integer deleteByBatch(List<User> user) {
        return null;
    }

    @Override
    public Integer deleteAll() {
        return null;
    }

    @Override
    public User selectById(Integer uId) {
        return userService.selectById(uId);
    }

    @Override
    public List<User> selectByUser(User user) {
        return null;
    }

    @Override
    public Integer updateUser(User user) {
        return null;
    }
}
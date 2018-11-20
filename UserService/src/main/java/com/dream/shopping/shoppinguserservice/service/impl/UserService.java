package com.dream.shopping.shoppinguserservice.service.impl;

import com.dream.shopping.facade.po.User;
import com.dream.shopping.shoppinguserservice.mapper.UserMapper;
import com.dream.shopping.shoppinguserservice.service.IUserService;
import com.dream.shopping.shoppinguserservice.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: sky
 * Date: 2018/11/20
 * Time: 12:21
 */
@Service
public class UserService implements IUserService {

    private final UserMapper userMapper;

    @Autowired
    public UserService (UserMapper userMapper){
        this.userMapper = userMapper;
    }

    @Override
    public Integer insertUser(UserVo userVo) {
        return userMapper.insertUser(userVo);
    }

    @Override
    public Integer deleteUserById(Integer uId) {
        return userMapper.deleteUserById(uId);
    }

    @Override
    public Integer deleteByBatch(List<UserVo> userVos) {
        return userMapper.deleteByBatch(userVos);
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
    public List<User> selectByUserVo(UserVo userVo) {
        return userMapper.selectByUserVo(userVo);
    }

    @Override
    public Integer updateUser(Integer uId) {
        return userMapper.updateUser(uId);
    }
}
package com.dream.shopping.shoppinguserservice.facade;

import com.alibaba.dubbo.config.annotation.Service;
import com.dream.shopping.facade.IUserFacade;
import com.dream.shopping.facade.po.User;
import com.dream.shopping.shoppinguserservice.service.IUserService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: sky
 * Date: 2018/11/22
 * Time: 19:34
 */
@Component
@Service(version = "1.0.0")
public class UserFacadeImpl implements IUserFacade {

    @Resource
    private IUserService iUserService;

    @Override
    public Integer insertUser(User user) {
        return iUserService.insertUser(user);
    }

    @Override
    public Integer deleteUserById(Integer uId) {
        return iUserService.deleteUserById(uId);
    }

    @Override
    public Integer deleteByBatch(List<User> user) {
        return iUserService.deleteByBatch(user);
    }

    @Override
    public Integer deleteAll() {
        return iUserService.deleteAll();
    }

    @Override
    public User selectById(Integer uId) {
        return iUserService.selectById(uId);
    }

    @Override
    public List<User> selectByUser(User user) {
        return iUserService.selectByUser(user);
    }

    @Override
    public Integer updateUser(User user) {
        return iUserService.updateUser(user);
    }
}
package com.dream.shopping.channelservice.utils;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dream.shopping.facade.IServiceFacade.IUserFacade;
import com.dream.shopping.facade.po.User;

import java.util.List;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: sky
 * Date: 2018/12/4
 * Time: 12:17
 */
public final class CheckLoginUtil {

    @Reference(version = "1.0.0", timeout = 10000)
    private static IUserFacade iUserFacade;

    private CheckLoginUtil (){
        throw new RuntimeException();
    }

    public static User checkLogin(String userLoginName, String password) {
        User user = new User();
        user.setUserLoginName(userLoginName);
        user.setPassword(password);
        List<User> userList = iUserFacade.selectByUser(user);
        if (userList != null && userList.get(0) != null) {
            return userList.get(0);
        }
        return null;
    }
}
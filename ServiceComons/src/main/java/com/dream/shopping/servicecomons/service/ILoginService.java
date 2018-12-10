package com.dream.shopping.servicecomons.service;

import com.dream.shopping.facade.po.User;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: sky
 * Date: 2018/12/4
 * Time: 12:03
 */
public interface ILoginService {

    /**
     * 描述 登陆验证
     * @author sky
     * @date 2018/12/4 12:09
     * @param []
     * @return com.dream.shopping.facade.po.User
     */
    User checkLogin();

}
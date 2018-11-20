package com.dream.shopping.shoppinguserservice.vo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: sky
 * Date: 2018/11/20
 * Time: 12:03
 */
@Component
public class UserVo {

    private final CustomerUser customerUser;

    @Autowired
    public UserVo (CustomerUser customerUser){
        this.customerUser = customerUser;
    }


}
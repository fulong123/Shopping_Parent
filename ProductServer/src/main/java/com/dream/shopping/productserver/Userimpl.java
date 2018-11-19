package com.dream.shopping.productserver;

import com.dream.shopping.pojo.po.User;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: sky
 * Date: 2018/11/19
 * Time: 15:58
 */
public class Userimpl extends User {

    public static void main(String[] args){

        User user = new User(1,"2");
        System.out.println(user.getuId());
    }
}
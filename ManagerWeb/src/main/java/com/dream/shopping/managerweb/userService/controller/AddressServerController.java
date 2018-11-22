package com.dream.shopping.managerweb.userService.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dream.shopping.shoppinguserservice.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: sky
 * Date: 2018/11/21
 * Time: 20:37
 */
@Controller
@RequestMapping("/address")
public class AddressServerController {

    @Reference(version = "1.0.0",timeout = 100000)
    private IUserService userService;

    @RequestMapping("/login")
    public String login(){
        System.out.println(userService.selectById(36));
        return "/user/register";
    }
}
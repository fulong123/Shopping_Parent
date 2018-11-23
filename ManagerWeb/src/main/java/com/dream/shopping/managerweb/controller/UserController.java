package com.dream.shopping.managerweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dream.shopping.facade.IServiceFacade.IUserFacade;
import com.dream.shopping.facade.po.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: sky
 * Date: 2018/11/23
 * Time: 11:26
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Reference(version = "1.0.0",timeout = 100000)
    private IUserFacade userFacade;

    @RequestMapping("/index")
    public String index(){
        return "login";
    }

    @RequestMapping("/register")
    public @ResponseBody User register(){
        return userFacade.selectById(36);
    }

    @RequestMapping("/login")
    public String login(User user, Model model){
        model.addAttribute("users",userFacade.selectByUser(user));
        return "/user/main";
    }

    @RequestMapping("/selectById/{id}")
    public String selectById(@PathVariable ("id") Integer uId, Model model){
        model.addAttribute("user",userFacade.selectById(uId));
        return "/user/update";
    }
}
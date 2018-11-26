package com.dream.shopping.managerweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dream.shopping.facade.IServiceFacade.IUserFacade;
import com.dream.shopping.facade.po.User;
import com.dream.shopping.managerweb.utils.WindowUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

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

    @RequestMapping("/addUser")
    public String register(){
        return "user/register";
    }

    @RequestMapping("/add")
    public void add(User user, HttpServletResponse resp){
        if (userFacade.insertUser(user) > 0){
            WindowUtil.window(resp,"添加成功","/user/main");
        }else {
            WindowUtil.window(resp,"添加失败","/user/main");
        }
    }

    @RequestMapping("/main")
    public String login(Model model){
        model.addAttribute("users",userFacade.selectByUser(null));
        return "user/main";
    }

    @RequestMapping("/deleteUser")
    public void deleteUser(Integer uId, HttpServletResponse resp){
        if (userFacade.deleteUserById(uId) > 0){
            WindowUtil.window(resp,"删除成功","/user/main");
        }else {
            WindowUtil.window(resp,"删除失败","/user/main");
        }
    }

    @RequestMapping("/initUser")
    public String initUser(Integer uId, Model model){
        model.addAttribute("user",userFacade.selectById(uId));
        return "/user/update";
    }

    @RequestMapping("/updateUser")
    public void updateUser(User user, HttpServletResponse resp){
        if (userFacade.updateUser(user) > 0){
            WindowUtil.window(resp,"更新成功","/user/main");
        }else {
            WindowUtil.window(resp,"更新失败","/user/main");
        }
    }
}
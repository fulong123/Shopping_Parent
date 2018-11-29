package com.dream.shopping.managerweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dream.shopping.facade.IServiceFacade.IAdministerFacade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: sky
 * Date: 2018/11/29
 * Time: 12:14
 */
@Controller
public class LoginController {

    @Reference(version = "1.0.0",timeout = 100000)
    private IAdministerFacade iAdministerFacade;

    @RequestMapping("/login")
    public String login(Model model){
        model.addAttribute("admin",iAdministerFacade.selectByAdmin(null).get(0));
        return "administrator/main";
    }
}
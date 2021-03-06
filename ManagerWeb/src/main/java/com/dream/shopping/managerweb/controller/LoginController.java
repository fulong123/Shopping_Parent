package com.dream.shopping.managerweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.dream.shopping.facade.IServiceFacade.IAdministerFacade;
import com.dream.shopping.facade.IServiceFacade.IGoods_TypeFacade;
import com.dream.shopping.facade.po.GoodsType;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

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

    @Reference(timeout = 100000)
    private IGoods_TypeFacade iGoods_typeFacade;

    @RequestMapping("/login")
    public String login(Model model){
        model.addAttribute("admin",iAdministerFacade.selectByAdmin(null).get(0));
        return "administrator/main";
    }
}
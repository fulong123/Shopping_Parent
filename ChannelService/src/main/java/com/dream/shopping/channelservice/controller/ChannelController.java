package com.dream.shopping.channelservice.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dream.shopping.facade.IServiceFacade.IGoods_TypeFacade;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: sky
 * Date: 2018/12/1
 * Time: 10:13
 */
@Controller
@RequestMapping("/channel")
public class ChannelController {

    @Reference(timeout = 10000)
    private IGoods_TypeFacade iGoods_typeFacade;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @RequestMapping("/index")
    public String index(Model model){
        try{
            model.addAttribute("goodsTypesPId", redisTemplate.boundValueOps("goodsTypesPId").get());
            return "index";
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("导航失败!");
        }
    }

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "user/login";
    }

    @RequestMapping("/login")
    public @ResponseBody Map<String, Object> login(
            String userLoginName, String password, HttpServletRequest req){

        Map<String, Object> msg = new HashMap<>();
        HttpSession session = req.getSession();
        //code = StringUtils.trim(code);
        userLoginName = StringUtils.trim(userLoginName);
        password = StringUtils.trim(password);
        //Object scode = session.getAttribute("code");
        String sessionCode = null;
        /*if (scode != null)
            sessionCode = scode.toString();
        if (!StringUtils.equalsIgnoreCase(code, sessionCode)) {
            msg.put("error", "验证码错误");
            return msg;
        }*/

        if (null != user) {
            session.setAttribute("loginUser", user);
        } else {
            msg.put("error", "用户名或密码错误");
        }
        return msg;
    }

    @RequestMapping("/register")
    public @ResponseBody
    Map<String,Object> login(
            @RequestParam(value = "userLoginName") String userLoginName,
            @RequestParam(value = "password") String password,
            @RequestParam(value = "userRealName", required = false) String userRealName
    ){


        return null;
    }





}
package com.dream.shopping.channelservice.controller;

import com.dream.shopping.channelservice.utils.CheckLoginUtil;
import com.dream.shopping.cmmons.utils.WindowUtil;
import com.dream.shopping.facade.po.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: sky
 * Date: 2018/12/6
 * Time: 12:21
 */
@Controller
public class LoginController {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("goodsTypeList", redisTemplate.boundValueOps("goodsTypesPId").get());
        return "Index";
    }

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "Login";
    }

    @RequestMapping("/toRegister")
    public String toRegister(){
        return "Regist";
    }

    @RequestMapping("/login")
    public void login(String userLoginName, String password, HttpServletResponse resp, HttpServletRequest req){

        HttpSession session = req.getSession();
        /*code = StringUtils.trim(code);
        Object scode = session.getAttribute("code");
        String sessionCode = null;
        if (scode != null)
            sessionCode = scode.toString();
        if (!StringUtils.equalsIgnoreCase(code, sessionCode)) {
            msg.put("error", "验证码错误");
            return msg;
        }*/
        User user = CheckLoginUtil.checkLogin(StringUtils.trim(userLoginName), StringUtils.trim(password));
        if (null != user) {
            session.setAttribute("loginUser", user);
            WindowUtil.window(resp,"登陆成功","/channel/index");
        } else {
            WindowUtil.window(resp,"登录失败","/channel/toLogin");
        }
    }

}
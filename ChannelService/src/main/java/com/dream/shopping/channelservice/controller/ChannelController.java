package com.dream.shopping.channelservice.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dream.shopping.channelservice.utils.CheckLoginUtil;
import com.dream.shopping.cmmons.utils.MD5;
import com.dream.shopping.cmmons.utils.WindowUtil;
import com.dream.shopping.facade.IServiceFacade.IGoods_TypeFacade;
import com.dream.shopping.facade.IServiceFacade.INewsFacade;
import com.dream.shopping.facade.IServiceFacade.IUserFacade;
import com.dream.shopping.facade.po.GoodsType;
import com.dream.shopping.facade.po.News;
import com.dream.shopping.facade.po.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

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

    @Reference(version = "1.0.0",timeout = 10000)
    private IUserFacade iUserFacade;

    @Reference(version = "1.0.0",timeout = 10000)
    private INewsFacade iNewsFacade;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("goodsTypeList", redisTemplate.boundValueOps("goodsTypesPId").get());
        return "Index";
    }

    @RequestMapping("/getChildrenByParentId")
    public @ResponseBody List<GoodsType> getChildrenByParentId(Integer parentId){
        return iGoods_typeFacade.selectGoods_TypeByParentId(parentId);
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

    @RequestMapping("/register")
    public void register(
            @RequestParam (value = "userLoginName") String userLoginName,
            @RequestParam (value = "password") String password,
            @RequestParam (value = "passwordRepeat") String passwordRepeat,
            @RequestParam (value = "sex") String sex,
            @RequestParam (value = "userRealName", required = false) String userRealName,
            @RequestParam (value = "age", required = false) Integer age,
            @RequestParam (value = "qq", required = false) String qq,
            @RequestParam (value = "weChat", required = false) String weChat,
            @RequestParam (value = "tel", required = false) String tel,
            @RequestParam (value = "email", required = false) String email,
            HttpServletRequest req,
            HttpServletResponse resp
    ){
        if (!StringUtils.equalsIgnoreCase(password, passwordRepeat)) {
            WindowUtil.window(resp,"密码不正确","/channel/toLogin");
        }else {
            User user = new User();
            user.setUserLoginName(userLoginName);
            user.setPassword(MD5.getMd5(password));
            user.setUserRealName(userRealName);
            user.setSex(sex);
            user.setAge(age);
            user.setQq(qq);
            user.setWeChat(weChat);
            user.setTel(tel);
            user.setEmail(email);
            try {
                int result = iUserFacade.insertUser(user);
                HttpSession session = req.getSession();
                if (result>0) {
                    session.setAttribute("loginUser", user);
                    WindowUtil.window(resp,"注册成功","/channel/index");
                } else {
                    WindowUtil.window(resp,"注册失败","/channel/toRegister");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping("/news")
    public String newsList(Model model){
        model.addAttribute("newsList",iNewsFacade.selectByNews(null).subList(0,5));
        return "Index";
    }

    @RequestMapping("/ad")
    public String ad(){
        return "Index";
    }
}
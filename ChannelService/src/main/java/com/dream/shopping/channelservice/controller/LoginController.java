package com.dream.shopping.channelservice.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dream.shopping.channelservice.utils.JumpIndex;
import com.dream.shopping.cmmons.utils.MD5;
import com.dream.shopping.cmmons.utils.WindowUtil;
import com.dream.shopping.facade.IServiceFacade.*;
import com.dream.shopping.facade.po.Goods;
import com.dream.shopping.facade.po.GoodsType;
import com.dream.shopping.facade.po.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
 * Date: 2018/12/6
 * Time: 12:21
 */
@Controller
public class LoginController {

    private JumpIndex jumpIndex;

    @Reference(version = "1.0.0",timeout = 100000)
    private INewsFacade iNewsFacade;

    @Reference(version = "1.0.0",timeout = 100000)
    private IAdvertisementFacade iAdvertisementFacade;

    @Reference(timeout = 100000)
    private IGoods_TypeFacade iGoods_typeFacade;

    @Reference(version = "1.0.0",timeout = 100000)
    private IUserFacade iUserFacade;

    @Reference(timeout = 100000)
    private IGoodsFacade iGoodsFacade;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

   @Autowired
   public LoginController(JumpIndex jumpIndex){
        this.jumpIndex = jumpIndex;
    }

    @RequestMapping("/index")
    public String test(Model model){
        return jumpIndex.jumpToIndex(model, redisTemplate, iGoods_typeFacade, iNewsFacade, iAdvertisementFacade);
//        return "Product";
    }
//
//    String jumpIndex(Model model) {
//        List<GoodsType> goodsTypeList;
//        String goodsTypeOne= (String) redisTemplate.boundValueOps("goodsTypesPId").get();
//        goodsTypeList= JSONObject.parseArray(goodsTypeOne,GoodsType.class);
//        if (null == goodsTypeOne){
//            GoodsType goodsType = new GoodsType();
//            goodsType.setGoodsTypeGrade(1);
//            goodsTypeList = iGoods_typeFacade.selectGoods_Type(goodsType);
//            goodsTypeOne = JSON.toJSONString(goodsTypeList);
//            redisTemplate.opsForValue().set("goodsTypesPId",goodsTypeOne);
//        }
//        model.addAttribute("goodsTypeList",goodsTypeList);
//
//        /**
//         * 新闻显示
//         */
//        String news = (String) redisTemplate.boundValueOps("newsList").get();
//        if (null == news){
//            List<News> newsList = iNewsFacade.selectByNews(null).subList(0, 5);
//            redisTemplate.opsForValue().set("newsList",JSON.toJSONString(newsList));
//            model.addAttribute("newsList",newsList);
//        }else {
//            List<News> newsList = JSONObject.parseArray(news, News.class);
//            model.addAttribute("newsList", NewsList.interception_of_collection(newsList));
//        }
//
//        /**
//         * 广告显示
//         */
//        String ad = (String) redisTemplate.boundValueOps("adList").get();
//        if (null == ad){
//            List<Advertisement> adList = iAdvertisementFacade.selectAll(null);
//            redisTemplate.opsForValue().set("adList",JSON.toJSONString(adList));
//            model.addAttribute("newsList",adList);
//        }else {
//            List<Advertisement> adList = JSONObject.parseArray(ad, Advertisement.class);
//            model.addAttribute("adList", adList);
//        }
//
//        return "Index";
//    }

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "Login";
    }

    @RequestMapping("/toRegister")
    public String toRegister(){
        return "Regist";
    }

    @RequestMapping("/register")
    public void register(
            @RequestParam(value = "userLoginName") String userLoginName,
            @RequestParam (value = "password") String password,
            @RequestParam (value = "passwordRepeat") String passwordRepeat,
            @RequestParam (value = "userRealName", required = false) String userRealName,
            @RequestParam (value = "tel", required = false) String tel,
            @RequestParam (value = "email", required = false) String email,
            HttpServletRequest req,
            HttpServletResponse resp
    ){
        if (!StringUtils.equalsIgnoreCase(password, passwordRepeat)) {
            WindowUtil.window(resp,"密码不正确","/toRegister");
        }else {
            User user = new User();
            user.setUserLoginName(userLoginName);
            user.setPassword(MD5.getMd5(password));
            user.setUserRealName(userRealName);
            user.setTel(tel);
            user.setEmail(email);
            try {
                int result = iUserFacade.insertUser(user);
                HttpSession session = req.getSession();
                if (result>0) {
                    session.setAttribute("loginUser", user);
                    WindowUtil.window(resp,"注册成功","/channel/index");
                } else {
                    WindowUtil.window(resp,"注册失败","/toRegister");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //商品分类根据Id查询
    @RequestMapping("/findByPId/{id}")
    public @ResponseBody List<GoodsType> findByPId(@PathVariable("id") Integer id){
        return iGoods_typeFacade.selectGoods_TypeByParentId(id);
    }

    //查全部
    @RequestMapping("/query/{id}")
    public @ResponseBody List<GoodsType> getList(@PathVariable("id") Integer id,GoodsType goodsType){
        goodsType.setGoodsTypeGrade(3);
        goodsType.setParentId(id);
        return iGoods_typeFacade.queryGoodsType(goodsType);
    }

    @RequestMapping("/selectGoodsById/{id}")
    public Goods selectGoodsById(@PathVariable ("id") Integer id){
        return iGoodsFacade.selectGoodsById(id);
    }

}
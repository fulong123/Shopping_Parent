package com.dream.shopping.managerweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dream.shopping.facade.IServiceFacade.IAdvertisementFacade;
import com.dream.shopping.facade.po.Advertisement;
import com.dream.shopping.facade.po.News;
import com.dream.shopping.managerweb.utils.WindowUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: sky
 * Date: 2018/11/26
 * Time: 19:11
 */
@Controller
@RequestMapping("/ad")
public class AdvertisementController {

    @Reference(version = "1.0.0",timeout = 100000)
    private IAdvertisementFacade iAdFacade;

    @RequestMapping("/main")
    public String selectAll(Model model){
        model.addAttribute("ads",iAdFacade.selectAll(null));
        return "advertisement/main";
    }

    @RequestMapping("/add")
    public String add(){
        return "advertisement/add";
    }

    @RequestMapping("/addAd")
    public void addNews(Advertisement ad, HttpServletResponse resp){
        if (iAdFacade.insertAdvertisement(ad) > 0){
            WindowUtil.window(resp,"添加成功","/ad/main");
        }else {
            WindowUtil.window(resp,"添加失败","/ad/main");
        }
    }

    @RequestMapping("/initNews")
    public String initNews(Integer newsId, Model model){
        model.addAttribute("news",iAdFacade.selectById(newsId));
        return "news/update";
    }

    @RequestMapping("/updateNews")
    public void updateNews(Advertisement ad, HttpServletResponse resp){
        if (iAdFacade.updateById(ad) > 0){
            WindowUtil.window(resp,"更新成功","/ad/main");
        }else {
            WindowUtil.window(resp,"更新失败","/ad/main");
        }
    }

    @RequestMapping("/deleteNews")
    public void deleteNews(Integer adId, HttpServletResponse resp){
        if (iAdFacade.deleteById(adId) > 0){
            WindowUtil.window(resp,"删除成功","/ad/main");
        }else {
            WindowUtil.window(resp,"删除失败","/ad/main");
        }
    }
}
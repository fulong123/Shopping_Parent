package com.dream.shopping.managerweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dream.shopping.facade.IServiceFacade.INewsFacade;
import com.dream.shopping.facade.po.News;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: sky
 * Date: 2018/11/26
 * Time: 14:45
 */
@Controller
@RequestMapping("/news")
public class NewsController {

    @Reference(version = "1.0.0",timeout = 100000)
    private INewsFacade iNewsFacade;

    @RequestMapping("/main")
    public String selectAll(Model model){
        List<News> newsList = iNewsFacade.selectByNews(null);
        model.addAttribute("newsList",newsList);
        return "news/main";
    }


}
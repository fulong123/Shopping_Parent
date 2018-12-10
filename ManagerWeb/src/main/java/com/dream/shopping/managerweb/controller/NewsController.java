package com.dream.shopping.managerweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dream.shopping.cmmons.utils.WindowUtil;
import com.dream.shopping.facade.IServiceFacade.INewsFacade;
import com.dream.shopping.facade.po.News;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
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

    @RequestMapping("/add")
    public String add(){
        return "news/add";
    }

    @RequestMapping("/addNews")
    public void addNews(News news, HttpServletResponse resp){
        if (iNewsFacade.insertNews(news) > 0){
            WindowUtil.window(resp,"添加成功","/news/main");
        }else {
            WindowUtil.window(resp,"添加失败","/news/main");
        }
    }

    @RequestMapping("/initNews")
    public String initNews(Integer newsId, Model model){
        model.addAttribute("news",iNewsFacade.selectById(newsId));
        return "news/update";
    }

    @RequestMapping("/updateNews")
    public void updateNews(News news, HttpServletResponse resp){
        if (iNewsFacade.updateNews(news) > 0){
            WindowUtil.window(resp,"更新成功","/news/main");
        }else {
            WindowUtil.window(resp,"更新失败","/news/main");
        }
    }

    @RequestMapping("/deleteNews")
    public void deleteNews(Integer newsId, HttpServletResponse resp){
        if (iNewsFacade.deleteNewsById(newsId) > 0){
            WindowUtil.window(resp,"删除成功","/news/main");
        }else {
            WindowUtil.window(resp,"删除失败","/news/main");
        }
    }
}
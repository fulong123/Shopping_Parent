package com.dream.shopping.channelservice.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dream.shopping.facade.IServiceFacade.IGoods_TypeFacade;
import com.dream.shopping.facade.IServiceFacade.INewsFacade;
import com.dream.shopping.facade.IServiceFacade.IUserFacade;
import com.dream.shopping.facade.po.GoodsType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    //商品分类根据Id查询
    @RequestMapping("/findByPId/{id}")
    @ResponseBody
    public List<GoodsType> findByPId(@PathVariable("id") Integer id){
        List<GoodsType> goodsType = iGoods_typeFacade.selectGoods_TypeByParentId(id);
        return goodsType;
    }

    //查全部
    @RequestMapping("/query/{id}")
    @ResponseBody
    public List<GoodsType> getList(@PathVariable("id") Integer id,GoodsType goodsType,Model model){
        goodsType.setGoodsTypeGrade(3);
        goodsType.setParentId(id);
        List<GoodsType> list = iGoods_typeFacade.queryGoodsType(goodsType);
        return list;
    }

    @RequestMapping("/getChildrenByParentId")
    public @ResponseBody List<GoodsType> getChildrenByParentId(Integer parentId){
        return iGoods_typeFacade.selectGoods_TypeByParentId(parentId);
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
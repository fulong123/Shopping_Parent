package com.dream.shopping.channelservice.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dream.shopping.channelservice.utils.JumpIndex;
import com.dream.shopping.facade.IServiceFacade.*;
import com.dream.shopping.facade.po.GoodsType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
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
    public ChannelController(JumpIndex jumpIndex){
        this.jumpIndex = jumpIndex;
    }

    @RequestMapping("/index")
    public String test(Model model) {
        return jumpIndex.jumpToIndex(model, redisTemplate, iGoods_typeFacade, iNewsFacade, iAdvertisementFacade);
    }

    @RequestMapping("/getChildrenByParentId")
    public @ResponseBody List<GoodsType> getChildrenByParentId(Integer parentId){
        return iGoods_typeFacade.selectGoods_TypeByParentId(parentId);
    }

    @RequestMapping("/ad")
    public String ad(){
        return "Index";
    }
}
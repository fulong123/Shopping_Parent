package com.dream.shopping.channelservice.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
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
        List<GoodsType> goodsTypes = iGoods_typeFacade.selectGoods_Type(null);
        redisTemplate.opsForValue().set("goodsType", JSON.toJSONString(goodsTypes));
        model.addAttribute("index", redisTemplate.boundValueOps("goodsType").get());
        return "index";
    }


}
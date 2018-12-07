package com.dream.shopping.channelservice.utils;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dream.shopping.facade.IServiceFacade.IGoods_TypeFacade;
import com.dream.shopping.facade.IServiceFacade.INewsFacade;
import com.dream.shopping.facade.po.GoodsType;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: sky
 * Date: 2018/12/6
 * Time: 17:59
 */
@Component
public final class JumpIndex {

    @Reference(timeout = 10000)
    private IGoods_TypeFacade iGoods_typeFacade;

    @Reference(version = "1.0.0",timeout = 10000)
    private INewsFacade iNewsFacade;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    public String jumpToIndex(Model model){
        List<GoodsType> goodsTypeList;
        String goodsTypeOne= (String) redisTemplate.opsForValue().get("goodsTypesPId");
        goodsTypeList= JSONObject.parseArray(goodsTypeOne,GoodsType.class);
        if (null==goodsTypeOne){
            GoodsType goodsType = new GoodsType();
            goodsType.setGoodsTypeGrade(1);
            goodsTypeList = iGoods_typeFacade.selectGoods_Type(goodsType);
            goodsTypeOne = JSON.toJSONString(goodsTypeList);
            redisTemplate.opsForValue().set("goodsTypesPId",goodsTypeOne);
        }
        model.addAttribute("goodsTypeList",goodsTypeList);
        model.addAttribute("newsList",iNewsFacade.selectByNews(null).subList(0,5));
        return "Index";
    }
}
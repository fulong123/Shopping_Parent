package com.dream.shopping.channelservice.utils;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dream.shopping.cmmons.utils.NewsList;
import com.dream.shopping.facade.IServiceFacade.IAdvertisementFacade;
import com.dream.shopping.facade.IServiceFacade.IGoods_TypeFacade;
import com.dream.shopping.facade.IServiceFacade.INewsFacade;
import com.dream.shopping.facade.po.Advertisement;
import com.dream.shopping.facade.po.GoodsType;
import com.dream.shopping.facade.po.News;
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
public class JumpIndex {

    public String jumpToIndex(Model model, RedisTemplate<String, Object> redisTemplate,
                              IGoods_TypeFacade iGoods_typeFacade, INewsFacade iNewsFacade,
                              IAdvertisementFacade iAdvertisementFacade){
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

        /**
         * 新闻显示
         */
        String news = (String) redisTemplate.boundValueOps("newsList").get();
        if (null == news){
            List<News> newsList = iNewsFacade.selectByNews(null).subList(0, 5);
            redisTemplate.opsForValue().set("newsList",JSON.toJSONString(newsList));
            model.addAttribute("newsList",newsList);
        }else {
            List<News> newsList = JSONObject.parseArray(news, News.class);
            model.addAttribute("newsList", NewsList.interception_of_collection(newsList));
        }

        /**
         * 广告显示
         */
        String ad = (String) redisTemplate.boundValueOps("adList").get();
        if (null == ad){
            List<Advertisement> adList = iAdvertisementFacade.selectAll(null);
            redisTemplate.opsForValue().set("adList",JSON.toJSONString(adList));
            model.addAttribute("newsList",adList);
        }else {
            List<Advertisement> adList = JSONObject.parseArray(ad, Advertisement.class);
            model.addAttribute("adList", adList);
        }

        return "Index";
    }
}
package com.dream.shopping.channelservice.utils;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.dream.shopping.facade.IServiceFacade.IAdvertisementFacade;
import com.dream.shopping.facade.IServiceFacade.IGoods_TypeFacade;
import com.dream.shopping.facade.IServiceFacade.INewsFacade;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: sky
 * Date: 2018/11/30
 * Time: 11:08
 */
@Component
public class CacheRedisUtil {

    void cacheRedis(RedisTemplate<String, Object> redisTemplate, IGoods_TypeFacade iGoods_typeFacade,
                    INewsFacade iNewsFacade, IAdvertisementFacade iAdvertisementFacade){
        redisTemplate.opsForValue().set("newsList",JSON.toJSONString(iNewsFacade.selectByNews(null)));
        redisTemplate.opsForValue().set("adList",JSON.toJSONString(iAdvertisementFacade.selectAll(null)));
        redisTemplate.opsForValue().set("goodsTypesPId",JSON.toJSONString(iGoods_typeFacade.selectGoods_TypeByParentId(-1)));
    }
}
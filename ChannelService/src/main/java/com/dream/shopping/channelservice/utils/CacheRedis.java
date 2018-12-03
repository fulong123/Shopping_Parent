package com.dream.shopping.channelservice.utils;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dream.shopping.facade.IServiceFacade.IGoods_TypeFacade;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: sky
 * Date: 2018/11/30
 * Time: 11:08
 */
public class CacheRedis {

    @Resource
    private static RedisTemplate<String, Object> redisTemplate;

    @Reference(version = "1.0.0",timeout = 10000)
    private static IGoods_TypeFacade iGoods_typeFacade;

    public static void CacheToRedis(){
        
    }
}
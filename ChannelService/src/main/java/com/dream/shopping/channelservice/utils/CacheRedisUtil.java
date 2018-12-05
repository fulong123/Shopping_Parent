package com.dream.shopping.channelservice.utils;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dream.shopping.facade.IServiceFacade.IGoods_TypeFacade;
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

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Reference(timeout = 10000)
    private IGoods_TypeFacade iGoods_typeFacade;

    void selectGoods_TypeByParentId(){
        redisTemplate.opsForValue().set("goodsTypesPId",iGoods_typeFacade.selectGoods_TypeByParentId(-1) + "");
    }




}
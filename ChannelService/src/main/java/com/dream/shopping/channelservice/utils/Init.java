package com.dream.shopping.channelservice.utils;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dream.shopping.facade.IServiceFacade.IAdvertisementFacade;
import com.dream.shopping.facade.IServiceFacade.IGoods_TypeFacade;
import com.dream.shopping.facade.IServiceFacade.INewsFacade;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 描述:缓存预热
 * Created with IntelliJ IDEA.
 * User: sky
 * Date: 2018/12/3
 * Time: 14:43
 */
@Component
public class Init implements ApplicationListener<ContextRefreshedEvent> {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Reference(timeout = 100000)
    private IGoods_TypeFacade iGoods_typeFacade;

    @Reference(version = "1.0.0",timeout = 100000)
    private INewsFacade iNewsFacade;

    @Reference(version = "1.0.0",timeout = 100000)
    private IAdvertisementFacade iAdvertisementFacade;

    /**
     * 描述 IOC容器加载后进行缓存预热
     * @author sky
     * @date 2018/12/5 9:47
     * @param [event]
     * @return void
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext context = event.getApplicationContext();
        CacheRedisUtil bean = context.getBean(CacheRedisUtil.class);
        bean.cacheRedis(redisTemplate,iGoods_typeFacade,iNewsFacade,iAdvertisementFacade);
    }
}
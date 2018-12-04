package com.dream.shopping.channelservice.utils;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dream.shopping.facade.IServiceFacade.IGoods_TypeFacade;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: sky
 * Date: 2018/12/3
 * Time: 14:43
 */
@Component
public class Init implements ApplicationListener<ContextRefreshedEvent> {

    @Reference(timeout = 10000)
    private IGoods_TypeFacade iGoods_typeFacade;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext context = event.getApplicationContext();
        CacheRedisUtil bean = context.getBean(CacheRedisUtil.class);
        bean.selectGoods_TypeByParentId();
    }
}
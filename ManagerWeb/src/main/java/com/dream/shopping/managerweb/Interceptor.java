package com.dream.shopping.managerweb;

import com.dream.shopping.managerweb.interceptor.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: sky
 * Date: 2018/11/26
 * Time: 0:55
 */
@SuppressWarnings("deprecation")
@SpringBootConfiguration
public class Interceptor extends WebMvcConfigurerAdapter {

    private final MyInterceptor myInterceptor;

    @Autowired
    public Interceptor(MyInterceptor myInterceptor) {
        this.myInterceptor = myInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor).addPathPatterns("/**");
    }
}
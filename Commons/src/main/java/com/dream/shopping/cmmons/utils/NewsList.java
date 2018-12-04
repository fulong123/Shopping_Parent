package com.dream.shopping.cmmons.utils;

import com.dream.shopping.facade.po.News;

import java.util.List;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: sky
 * Date: 2018/12/4
 * Time: 20:35
 */
public final class NewsList {

    private NewsList(){
        throw new AbstractMethodError();
    }

    public static List<News> interception_of_collection(List<News> newsList){
        return newsList.subList(0,5);
    }
}
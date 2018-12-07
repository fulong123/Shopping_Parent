package com.dream.shopping.cmmons.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: sky
 * Date: 2018/12/6
 * Time: 23:53
 */
public final class Session {

    private Session (){
        throw new AbstractMethodError();
    }

    public static void setSession(HttpServletRequest req, String key, String value){
        req.getSession().setAttribute(key,value);
    }

    public static Integer getSeesion(HttpServletRequest req, String key){
        Object attribute = req.getSession().getAttribute(key);
        if (attribute != null){
            return 1;
        }
        return 0;
    }
}
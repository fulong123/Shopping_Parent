package com.dream.shopping.pojo.po;

import java.io.Serializable;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: sky
 * Date: 2018/11/19
 * Time: 15:41
 */
public class User implements Serializable {

    private Integer uId;
    private String uName;

    public User() {
    }

    public User(Integer uId, String uName) {
        this.uId = uId;
        this.uName = uName;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }
}
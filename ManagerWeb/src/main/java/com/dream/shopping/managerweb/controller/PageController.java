package com.dream.shopping.managerweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: qingquan
 * Date: 2018/11/28
 * Time: 16:53
 */
@Controller
@RequestMapping("/page")
public class PageController {

    @RequestMapping("/adminAdd")
    public String admin(){
        return "administrator/add";
    }

    @RequestMapping("/userAdd")
    public String user(){
        return "user/register";
    }

    @RequestMapping("/addressAdd")
    public String address(){
        return "address/addressadd";
    }

    @RequestMapping("/adAdd")
    public String ad(){
        return "advertisement/add";
    }

    @RequestMapping("/brandAdd")
    public String brand(){
        return "brand/brandadd";
    }

    @RequestMapping("/goodsAdd")
    public String goods(){
        return "goods/goodsadd";
    }

    @RequestMapping("/goodsTypeAdd")
    public String goodsType(){
        return "goods_type/addgoodstype";
    }

    @RequestMapping("/goodsDetailsAdd")
    public String goodsDetails(){
        return "goodsdetails/goodsdetailsadd";
    }

    @RequestMapping("/newsAdd")
    public String news(){
        return "news/add";
    }
}

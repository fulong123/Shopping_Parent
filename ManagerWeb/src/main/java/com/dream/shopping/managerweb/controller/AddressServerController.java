package com.dream.shopping.managerweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: sky
 * Date: 2018/11/21
 * Time: 20:37
 */
@Controller
@RequestMapping("/address")
public class AddressServerController {

    @RequestMapping("/login")
    public String login(){
        return "";
    }
}
package com.dream.shopping.managerweb.addressservice;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dream.shopping.facade.IAddressFacade;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: huiliao
 * Date: 2018/11/22
 * Time: 19:52
 */
@Controller
@RequestMapping("/address")
public class AddressController {
    @Reference(version = "1.0.0",timeout = 100000)
    private IAddressFacade iAddressFacade;

    @RequestMapping("/login")
    public String login(){
        System.out.println(iAddressFacade);
        System.out.println(iAddressFacade.selectAddressById(33));
        return "/user/register";
    }
}

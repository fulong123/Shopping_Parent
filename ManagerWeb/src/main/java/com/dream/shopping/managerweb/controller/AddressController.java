package com.dream.shopping.managerweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dream.shopping.facade.IServiceFacade.IAddressFacade;
import com.dream.shopping.facade.po.Address;
import com.dream.shopping.facade.vo.AddressVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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

    @Reference(version = "1.0.0", timeout = 100000)
    private IAddressFacade iAddressFacade;


    @RequestMapping("/login")
    public String login() {
        return "address/addressadd";
    }

    @RequestMapping("/init")
    public String register(@RequestParam(value = "id") Integer id, Model model) {
        Address address = iAddressFacade.selectAddressById(id);
        System.out.println(address);
        model.addAttribute("address", address);
        return "address/addressupdate";
    }

    @RequestMapping("/getAll")
    public String getAddress(AddressVo addressVo, Model model) {
        List<Address> addresses = iAddressFacade.selectAll(addressVo);
        model.addAttribute("addresses", addresses);
        return "address/addresslist";
    }

    @RequestMapping("/addAddress")
    public String addAddress(Address address) {
        int i = iAddressFacade.insertAddress(address);
        if (i > 0) {
            return "redirect:/address/getAll";
        } else {
            return "address/addressadd";
        }
    }

    @RequestMapping("/updateAddress")
    public String updateAddress(Address address) {
        int i = iAddressFacade.updateAddress(address);
        System.out.println(i);
        if (i > 0) {
            return "redirect:/address/getAll";
        } else {
            return "address/addressupdate";
        }
    }

    @RequestMapping("/deleteById")
    public String deleteById(@RequestParam(value = "id") Integer id) {
        iAddressFacade.deleteAddressById(id);
        return "redirect:/address/getAll";
    }

    @RequestMapping("/idDefault")
    public String idDefault(@RequestParam(value = "id") Integer id){
        Address address = iAddressFacade.selectAddressById(id);
        address.setIsDefault((address.getIsDefault() == 1)?0:1);
        iAddressFacade.updateAddress(address);
        return "redirect:/address/getAll";
    }
}

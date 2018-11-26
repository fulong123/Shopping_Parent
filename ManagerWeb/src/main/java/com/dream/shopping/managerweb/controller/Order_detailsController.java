package com.dream.shopping.managerweb.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.dream.shopping.facade.IServiceFacade.IOrder_DetailsFacade;
import com.dream.shopping.facade.po.OrderDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: qingquan
 * Date: 2018/11/25
 * Time: 20:25
 */
@Controller
@RequestMapping("/orderDetails")
public class Order_detailsController {
    @Reference(timeout = 100000)
    private IOrder_DetailsFacade order_detailsFacade;

    @RequestMapping("/getAll")
    public String getOrderDetails(@RequestParam(value = "id")Integer id,Model model){
        List<OrderDetails> orderDetailses = order_detailsFacade.selectOrderDetailsByOrderId(id);
        model.addAttribute("orderDetailses",orderDetailses);
        return "order_details/order_detailslist";
    }

    @RequestMapping("/init")
    public String selectById(@RequestParam(value = "id")Integer id,Model model){
        OrderDetails orderDetails = order_detailsFacade.selectOrderDetailsById(id);
        model.addAttribute("orderDetails",orderDetails);
        return "order_details/updateorder_details";
    }

    @RequestMapping("/deleteOrderDetails")
    public String deleteOrderDetails(@RequestParam(value = "id")Integer id){
        order_detailsFacade.deleteOrderDetaIlsById(id);
        return "redirect:/orderDetails/getAll";
    }
}

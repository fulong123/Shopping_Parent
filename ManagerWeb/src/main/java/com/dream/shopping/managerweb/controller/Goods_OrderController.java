package com.dream.shopping.managerweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dream.shopping.facade.IServiceFacade.IGoods_OrderFacade;
import com.dream.shopping.facade.IServiceFacade.IOrder_DetailsFacade;
import com.dream.shopping.facade.po.Goods_Order;
import com.dream.shopping.facade.po.OrderDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: qingquan
 * Date: 2018/11/24
 * Time: 10:51
 */
@Controller
@RequestMapping("/goodsOrder")
public class Goods_OrderController {

    @Reference(timeout = 100000)
    private IGoods_OrderFacade goods_orderFacade;
    @Reference(timeout = 100000)
    private IOrder_DetailsFacade order_detailsFacade;

    @RequestMapping("/getAll")
    public String getGoodsOrder(Goods_Order goods_order, Model model){
        List<Goods_Order> goods_orders = goods_orderFacade.selectGoods_Order(goods_order);
        model.addAttribute("goods_orders",goods_orders);
        return "goods_order/goods_orderlist";
    }

    @RequestMapping("/init")
    public String selectById(Integer id,Model model){
        Goods_Order goods_order = goods_orderFacade.selectGoods_OrderById(id);
        model.addAttribute("goods_order",goods_order);
        return "goods_order/updategoods_order";
    }

    @RequestMapping("/updateGoodsOrder")
    public String updateGoodsOrder(Goods_Order goods_order){
        int i = goods_orderFacade.updateGoods_Order(goods_order);
        if (i>0){
            return "redirect:/goodsOrder/getAll";
        }else {
            return "goods_order/updategoods_order";
        }
    }

    @RequestMapping("/deleteGoodsOrder")
    public String deletaGoodsOrder(Integer id){
        int i = goods_orderFacade.deleteGood_OrderById(id);
        return "redirect:/goodsOrder/getAll";
    }

    @RequestMapping("/getOrderDetails")
    public String getOrderDetails(Integer id,Model model){
        List<OrderDetails> orderDetailses = order_detailsFacade.selectOrderDetailsByOrderId(id);
        model.addAttribute("orderDetailses",orderDetailses);
        return "order_details/order_detailslist";
    }
}

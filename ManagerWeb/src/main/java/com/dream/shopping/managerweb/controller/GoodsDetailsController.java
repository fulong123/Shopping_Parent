package com.dream.shopping.managerweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dream.shopping.facade.IServiceFacade.IGoodsDetailsFacade;
import com.dream.shopping.facade.po.GoodsDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: huiliao
 * Date: 2018/11/23
 * Time: 12:12
 */
@Controller
@RequestMapping("/goodsDetails")
public class GoodsDetailsController {

    @Reference(version = "1.0.0",timeout = 100000)
    private IGoodsDetailsFacade iGoodsDetailsFacade;

    @RequestMapping("getAll")
    @ResponseBody
    public List<GoodsDetails> getGoodsDetails(GoodsDetails goodsDetails){
        return iGoodsDetailsFacade.selectAll(goodsDetails);
    }
    @RequestMapping("/init/{id}")
    @ResponseBody
    public GoodsDetails getGoodsDetailsById(@PathVariable(value = "id") Integer id){
        return iGoodsDetailsFacade.selectGoodsDetailsById(id);
    }

    @RequestMapping("/addGoods")
    public String addGoodsDetails(GoodsDetails goodsDetails) {
        int i = iGoodsDetailsFacade.insertGoodsDetails(goodsDetails);
        if (i > 0) {
            return "redirect:/goods/getAll";
        } else {
            return "/goods/goodsadd";
        }
    }

    @RequestMapping("/updateGoods")
    public String updateGoodsDetails(GoodsDetails goodsDetails) {
        int i = iGoodsDetailsFacade.updateGoodsDetails(goodsDetails);
        if (i > 0) {
            return "redirect:/goods/getAll";
        } else {
            return "/goods/goodsupdate";
        }
    }

    @RequestMapping("/deleteById{id}")
    public String deleteGoodsDetails(@PathVariable(value = "id") Integer id) {
        iGoodsDetailsFacade.deleteGoodsDetailsById(id);
        return "redirect:/goods/getAll";
    }
}

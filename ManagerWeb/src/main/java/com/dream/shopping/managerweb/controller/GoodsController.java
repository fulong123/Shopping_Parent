package com.dream.shopping.managerweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dream.shopping.facade.IServiceFacade.IGoodsFacade;
import com.dream.shopping.facade.po.Goods;
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
@RequestMapping("goods")
public class GoodsController {

    @Reference(version = "1.0.0",timeout = 100000)
    private IGoodsFacade iGoodsFacade;

    @RequestMapping("getAll")
    @ResponseBody
    public List<Goods> getGoods(Goods goods){
        return iGoodsFacade.selectGoodsAll(goods);
    }
    @RequestMapping("/init/{id}")
    @ResponseBody
    public Goods getGoodsById(@PathVariable(value = "id") Integer id){
        return iGoodsFacade.selectGoodsById(id);
    }

    @RequestMapping("/addGoods")
    public String addGoods(Goods goods) {
        int i = iGoodsFacade.insertGoods(goods);
        if (i > 0) {
            return "redirect:/goods/getAll";
        } else {
            return "/goods/goodsadd";
        }
    }

    @RequestMapping("/updateGoods")
    public String updateGoods(Goods goods) {
        int i = iGoodsFacade.updateGoods(goods);
        if (i > 0) {
            return "redirect:/goods/getAll";
        } else {
            return "/goods/goodsupdate";
        }
    }

    @RequestMapping("/deleteById{id}")
    public String deleteGoods(@PathVariable(value = "id") Integer id) {
        iGoodsFacade.deleteGoodsById(id);
        return "redirect:/goods/getAll";
    }
}

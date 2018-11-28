package com.dream.shopping.managerweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dream.shopping.facade.IServiceFacade.IGoods_TypeFacade;
import com.dream.shopping.facade.po.GoodsType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: qingquan
 * Date: 2018/11/26
 * Time: 10:46
 */
@Controller
@RequestMapping("/goodsType")
public class GoodsTypeController {

    @Reference(timeout = 100000)
    private IGoods_TypeFacade goods_typeFacade;

    @RequestMapping("/getAll")
    public String getAll(GoodsType goodsType, Model model){
        List<GoodsType> goodsTypes = goods_typeFacade.selectGoods_Type(goodsType);
        model.addAttribute("goodsTypes",goodsTypes);
        return "goods_type/goods_typelist";
    }

    @RequestMapping("/init")
    public String selectById(@RequestParam(value = "id")Integer id,Model model){
        GoodsType goodsType = goods_typeFacade.selectGoods_TypeByGoodsTypeId(id);
        model.addAttribute("goodsType",goodsType);
        return "/goods_type/updategoods_type";
    }

    @RequestMapping("/addGoodsType")
    public String addGoodsType(GoodsType goodsType){
        int i = goods_typeFacade.insertGoods_Type(goodsType);
        if (i>0){
            return "redirect:/goodsType/getAll";
        }else {
            return "goodsType/addgoods_type";
        }
    }

    @RequestMapping("/deleteGoodsType")
    public String deleteGoodsType(@RequestParam(value = "id")Integer id){
        goods_typeFacade.deleteGoods_TypeById(id);
        return "redirect:/goodsType/getAll";
    }

    @RequestMapping("/add")
    public String add(){
        return "goods_type/addgoodstype";
    }

    @RequestMapping("/getByPId/{pid}")
    @ResponseBody
    public List<GoodsType> selectByPId(@PathVariable(value = "pid") Integer pid){
        return goods_typeFacade.selectGoods_TypeByParentId(pid);
    }

    @RequestMapping("/type")
    @ResponseBody
    public List<GoodsType> selectAll(){
        return goods_typeFacade.selectGoods_Type(null);
    }
}

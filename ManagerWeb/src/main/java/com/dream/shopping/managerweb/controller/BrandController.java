package com.dream.shopping.managerweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dream.shopping.facade.IServiceFacade.IBrandFacade;
import com.dream.shopping.facade.po.Brand;
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
 * Time: 10:56
 */
@Controller
@RequestMapping("/brands")
public class BrandController {

    @Reference(version = "1.0.0", timeout = 100000)
    IBrandFacade brandFacade;

    @RequestMapping("/getAll")
    @ResponseBody
    public List<Brand> getAll(Brand brand) {

        return brandFacade.selectAll(brand);
    }

    @RequestMapping("/init/{id}")
    @ResponseBody
    public Brand init(@PathVariable(value = "id") Integer id) {

        return brandFacade.selectBrandById(id);
    }

    @RequestMapping("/addBrand")
    public String addBrand(Brand brand) {
        int i = brandFacade.insertBrand(brand);
        if (i > 0) {
            return "redirect:/brands/getAll";
        } else {
            return "/brand/brandadd";
        }
    }

    @RequestMapping("/updateBrand")
    public String updateBrand(Brand brand) {
        int i = brandFacade.updateBrand(brand);
        if (i > 0) {
            return "redirect:/brands/getAll";
        } else {
            return "/brand/brandupdate";
        }
    }

    @RequestMapping("/deleteById{id}")
    public String deleteBrand(@PathVariable(value = "id") Integer id) {
        brandFacade.deleteBrandById(id);
        return "redirect:/brands/getAll";
    }
}

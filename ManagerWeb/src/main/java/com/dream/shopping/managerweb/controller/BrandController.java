package com.dream.shopping.managerweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dream.shopping.facade.IServiceFacade.IBrandFacade;
import com.dream.shopping.facade.po.Brand;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
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
    private IBrandFacade brandFacade;

    @Resource
    private FastFileStorageClient storageClient;

    @RequestMapping("/getAll")
    public String getAll(Brand brand, Model model) {
        List<Brand> brands = brandFacade.selectAll(brand);
        model.addAttribute("brands", brands);
        return "brand/brandlist";
    }

    @RequestMapping("/detail/{id}")
    public String getDetail(@PathVariable(value = "id") String id, Model model) {
        Brand brand = brandFacade.selectBrandById(Integer.parseInt(id));
        model.addAttribute("brand", brand);
        return "brand/branddetil";
    }
    @RequestMapping("/aaa")
    public String aaa() {
        return "brand/brandadd";
    }

    @RequestMapping("/type")
    @ResponseBody
    public List<Brand> getType(){
        return brandFacade.selectAll(null);
    }
    @RequestMapping("/deleteAll/{ids}")
    public String deleteAll(@PathVariable(value = "ids") String ids) {
        String[] is = ids.split(",");
        for (String id :
                is) {
            brandFacade.deleteBrandById(Integer.parseInt(id));
        }
        return "redirect:/brands/getAll";
    }

    @RequestMapping("/init")
    public String init(String id, Model model) {
        Brand brand = brandFacade.selectBrandById(Integer.parseInt(id));
        model.addAttribute("brand", brand);
        return "brand/brandupdate";
    }

    @RequestMapping("/addBrand")
    public String addBrand(MultipartFile file, Brand brand) throws IOException {
        if (!file.isEmpty()) {
            StorePath storePath = storageClient.uploadFile(null, file.getInputStream(), file.getSize(), "jpg");
            String path = "http://47.107.33.131:8888/"+storePath.getGroup() + "/" + storePath.getPath();
            brand.setPhoto(path);
        }
        int i = brandFacade.insertBrand(brand);
        if (i>0) {
            return "redirect:/brands/getAll";
        }else {
            return "brand/brandadd";
        }
    }

    @RequestMapping("/updateBrand")
    public String updateBrand(MultipartFile file, Brand brand) throws IOException {
        if (!file.isEmpty()) {
            StorePath storePath = storageClient.uploadFile(null, file.getInputStream(), file.getSize(), "jpg");
            String path = "http://47.107.33.131:8888/"+storePath.getGroup() + "/" + storePath.getPath();
            brand.setPhoto(path);
        }
        int i = brandFacade.updateBrand(brand);
        if (i>0) {
            return "redirect:/brands/getAll";
        }else {
            return "brand/brandupdate";
        }
    }

    @RequestMapping("/deleteById")
    public String deleteBrand(String id) {
        brandFacade.deleteBrandById(Integer.parseInt(id));
        return "redirect:/brands/getAll";
    }
}

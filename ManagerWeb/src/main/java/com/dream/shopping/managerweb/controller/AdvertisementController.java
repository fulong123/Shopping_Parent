package com.dream.shopping.managerweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dream.shopping.facade.IServiceFacade.IAdvertisementFacade;
import com.dream.shopping.facade.po.Advertisement;
import com.dream.shopping.facade.po.News;
import com.dream.shopping.managerweb.utils.WindowUtil;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: sky
 * Date: 2018/11/26
 * Time: 19:11
 */
@Controller
@RequestMapping("/ad")
public class AdvertisementController {

    @Reference(version = "1.0.0",timeout = 100000)
    private IAdvertisementFacade iAdFacade;
    @Resource
    private FastFileStorageClient storageClient;

    @RequestMapping("/main")
    public String selectAll(Model model){
        model.addAttribute("ads",iAdFacade.selectAll(null));
        return "advertisement/main";
    }

    @RequestMapping("/add")
    public String add(){
        return "advertisement/add";
    }

    @RequestMapping("/addAd")
    public void addNews(@RequestParam(value = "file") MultipartFile file,Advertisement ad, HttpServletResponse resp) throws IOException {
        uploadFile(file,ad);
        if (iAdFacade.insertAdvertisement(ad) > 0){
            WindowUtil.window(resp,"添加成功","/ad/main");
        }else {
            WindowUtil.window(resp,"添加失败","/ad/main");
        }
    }

    @RequestMapping("/initAd")
    public String initNews(Integer AdvertisementId, Model model){
        model.addAttribute("ad",iAdFacade.selectById(AdvertisementId));
        return "advertisement/update";
    }

    @RequestMapping("/updateAd")
    public void updateNews(@RequestParam(value = "file") MultipartFile file, Advertisement ad, HttpServletResponse resp) throws IOException {
        uploadFile(file,ad);
        if (iAdFacade.updateById(ad) > 0){
            WindowUtil.window(resp,"更新成功","/ad/main");
        }else {
            WindowUtil.window(resp,"更新失败","/ad/main");
        }
    }

    @RequestMapping("/deleteAd")
    public void deleteNews(Integer adId, HttpServletResponse resp){
        if (iAdFacade.deleteById(adId) > 0){
            WindowUtil.window(resp,"删除成功","/ad/main");
        }else {
            WindowUtil.window(resp,"删除失败","/ad/main");
        }
    }

    private void uploadFile(@RequestParam(value = "file") MultipartFile file, Advertisement ad) throws IOException {
        if (!file.isEmpty()){
            String lastName = Objects.requireNonNull(file.getOriginalFilename()).split("\\.")[1];
            StorePath storePath = storageClient.uploadFile(null, file.getInputStream(), file.getSize(), lastName);
            String path="http://47.107.33.131:8888/"+storePath.getGroup()+"/"+storePath.getPath();
            ad.setAdvertisementPhoto(path);
        }
    }
}
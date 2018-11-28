package com.dream.shopping.managerweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dream.shopping.facade.IServiceFacade.IGoodsDetailsFacade;
import com.dream.shopping.facade.po.GoodsDetails;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

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
    @Resource
    private FastFileStorageClient storageClient;

    @RequestMapping("getAll")
    @ResponseBody
    public List<GoodsDetails> getGoodsDetails(GoodsDetails goodsDetails){
        return iGoodsDetailsFacade.selectAll(goodsDetails);
    }

    @RequestMapping("/init")
    public String getGoodsDetailsById(String id, Model model){
        GoodsDetails details = iGoodsDetailsFacade.selectGoodsDetailsById(Integer.parseInt(id));
        model.addAttribute("details",details);
        return "goodsdetails/goodsdetailsupdate";
    }

    @RequestMapping("/addGoodsDetails")
    public String addGoodsDetails(@RequestParam(value = "file") MultipartFile[] files, GoodsDetails goodsDetails) throws IOException {
        uploadFile(files, goodsDetails);
        int i = iGoodsDetailsFacade.insertGoodsDetails(goodsDetails);
        if (i > 0) {
            return "redirect:/goods/getAll";
        } else {
            return "/goods/goodsadd";
        }
    }

    @RequestMapping("/updateGoodsDetails")
    public String updateGoodsDetails(@RequestParam(value = "file") MultipartFile[] files,GoodsDetails goodsDetails) throws IOException {
        uploadFile(files, goodsDetails);
        int i = iGoodsDetailsFacade.updateGoodsDetails(goodsDetails);
        if (i > 0) {
            return "redirect:/goods/getAll";
        } else {
            return "/goods/goodsupdate";
        }
    }

    private void uploadFile(@RequestParam("file") MultipartFile[] files, GoodsDetails goodsDetails) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (MultipartFile file :
                files) {
            if (!file.isEmpty()) {
                String lastName = Objects.requireNonNull(file.getOriginalFilename()).split("\\.")[1];
                StorePath storePath = storageClient.uploadFile(null, file.getInputStream(), file.getSize(), lastName);
                String path = "http://47.107.33.131:8888/" + storePath.getGroup() + "/" + storePath.getPath();
                System.out.println(path);
                sb.append(path);
                sb.append("#");
            }
        }
        goodsDetails.setGoodsDetailPicture(sb.substring(0, sb.length() - 1));
    }

}

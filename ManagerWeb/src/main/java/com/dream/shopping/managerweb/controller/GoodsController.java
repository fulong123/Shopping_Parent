package com.dream.shopping.managerweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dream.shopping.facade.IServiceFacade.IGoodsDetailsFacade;
import com.dream.shopping.facade.IServiceFacade.IGoodsFacade;
import com.dream.shopping.facade.IServiceFacade.IGoods_TypeFacade;
import com.dream.shopping.facade.po.Goods;
import com.dream.shopping.facade.po.GoodsDetails;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: huiliao
 * Date: 2018/11/23
 * Time: 12:12
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Reference(version = "1.0.0", timeout = 100000)
    private IGoodsFacade iGoodsFacade;
    @Reference(version = "1.0.0", timeout = 100000)
    private IGoodsDetailsFacade iGoodsDetailsFacade;
    @Reference(version = "1.0.0", timeout = 100000)
    private IGoods_TypeFacade iGoodsTypeFacade;
    @Resource
    private FastFileStorageClient storageClient;

    public GoodsController() {
    }

    @RequestMapping("/getAll")
    public String getGoods(Goods goods, Model model) {

        List<Goods> goodsList = iGoodsFacade.selectGoodsAll(goods);

        model.addAttribute("goodsList", goodsList);
        return "goods/goodslist";
    }

    @RequestMapping("/detail/{id}")
    public String getGoodsById(@PathVariable(value = "id") String id, Model model) {
        List<GoodsDetails> goodsDetailses = iGoodsDetailsFacade.selectAll(null);
        for (GoodsDetails goodsDetails :
                goodsDetailses) {
            if (null != goodsDetails) {
                if (Integer.parseInt(id) == goodsDetails.getGoodsId()) {
                    model.addAttribute("goodsDetails", goodsDetails);
                    return "goodsdetails/goodsdetail";
                }
            }
        }
        Goods goods = iGoodsFacade.selectGoodsById(Integer.parseInt(id));
        model.addAttribute("goodsName",goods.getGoodsTitle());
        model.addAttribute("goodsId",goods.getGoodsId());
        return "goodsdetails/goodsdetailsadd";
    }

    @RequestMapping("/init")
    public String goodsDetail(String id, Model model) {
        Goods goods = iGoodsFacade.selectGoodsById(Integer.parseInt(id));
        System.out.println(goods);
        model.addAttribute("goods", goods);
        return "goods/goodsupdate";
    }

    @RequestMapping("/addGoods")
    public String addGoods(MultipartFile file, Goods goods) throws IOException {
        uploadFile(file, goods);
        System.out.println(goods);
        int i = iGoodsFacade.insertGoods(goods);
        if (i > 0) {
            return "redirect:/goods/getAll";
        } else {
            return "/goods/goodsadd";
        }
    }

    @RequestMapping("/updateGoods")
    public String updateGoods(MultipartFile file, Goods goods) throws IOException {
        uploadFile(file, goods);
        int i = iGoodsFacade.updateGoods(goods);
        if (i > 0) {
            return "redirect:/goods/getAll";
        } else {
            return "/goods/goodsupdate";
        }
    }

    private void uploadFile(MultipartFile file, Goods goods) throws IOException {
        if (!file.isEmpty()) {
            String lastName = file.getOriginalFilename().split("\\.")[1];
            StorePath storePath = storageClient.uploadFile(null, file.getInputStream(), file.getSize(), lastName);
            String path = "http://47.107.33.131:8888/" + storePath.getGroup() + "/" + storePath.getPath();
            goods.setGoodsPhoto(path);
        }
    }


    @RequestMapping("/deleteById")
    public String deleteGoods(String id) {
        iGoodsFacade.deleteGoodsById(Integer.parseInt(id));
        List<GoodsDetails> details = iGoodsDetailsFacade.selectAll(null);
        for (GoodsDetails detail :
                details) {
            if (detail.getGoodsId() == Integer.parseInt(id)) {
                iGoodsDetailsFacade.deleteGoodsDetailsById(detail.getGoodsDetailsId());
            }
        }
        return "redirect:/goods/getAll";
    }
    @RequestMapping("/deleteAll/{ids}")
    public String deleteAll(@PathVariable(value = "ids") String ids) {
        String[] strs = ids.split(",");
        for (String id :
                strs) {
            iGoodsFacade.deleteGoodsById(Integer.parseInt(id));
            List<GoodsDetails> details = iGoodsDetailsFacade.selectAll(null);
            for (GoodsDetails detail :
                    details) {
                if (detail.getGoodsId() == Integer.parseInt(id)) {
                    iGoodsDetailsFacade.deleteGoodsDetailsById(detail.getGoodsDetailsId());
                }
            }
        }
        return "redirect:/goods/getAll";
    }
}

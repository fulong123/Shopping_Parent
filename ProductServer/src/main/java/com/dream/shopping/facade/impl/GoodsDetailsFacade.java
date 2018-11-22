package com.dream.shopping.facade.impl;

import com.dream.shopping.facade.goodsservice.IGoodsDetailsFacade;
import com.dream.shopping.facade.po.GoodsDetails;
import com.dream.shopping.productserver.service.GoodsDetailsService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: huiliao
 * Date: 2018/11/22
 * Time: 10:23
 */
@Component
public class GoodsDetailsFacade implements IGoodsDetailsFacade {

    @Resource
    GoodsDetailsService goodsDetailsService;
    @Override
    public List<GoodsDetails> selectAll(GoodsDetails goodsDetails) {
        return goodsDetailsService.selectAll(goodsDetails);
    }

    @Override
    public com.dream.shopping.facade.po.GoodsDetails selectGoodsDetailsById(Integer id) {
        return goodsDetailsService.selectGoodsDetailsById(id);
    }

    @Override
    public int insertGoodsDetails(GoodsDetails goodsDetails) {
        return goodsDetailsService.insertGoodsDetails(goodsDetails);
    }

    @Override
    public int updateGoodsDetails(GoodsDetails goodsDetails) {
        return goodsDetailsService.updateGoodsDetails(goodsDetails);
    }

    @Override
    public int deleteGoodsDetailsById(Integer id) {
        return goodsDetailsService.deleteGoodsDetailsById(id);
    }
}

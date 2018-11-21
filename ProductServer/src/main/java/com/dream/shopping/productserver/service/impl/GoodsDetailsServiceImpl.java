package com.dream.shopping.productserver.service.impl;

import com.dream.shopping.facade.po.GoodsDetails;
import com.dream.shopping.productserver.mapper.GoodsDetailsMapper;
import com.dream.shopping.productserver.service.GoodsDetailsService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述:  商品详情服务的实现
 * Created with IntelliJ IDEA.
 * User: huiliao
 * Date: 2018/11/21
 * Time: 20:47
 */
@Component
public class GoodsDetailsServiceImpl implements GoodsDetailsService {

    @Resource
    GoodsDetailsMapper goodsDetailsMapper;
    @Override
    public List<GoodsDetails> selectAll(GoodsDetails goodsDetails) {
        return goodsDetailsMapper.selectAll(goodsDetails);
    }

    @Override
    public GoodsDetails selectGoodsDetailsById(Integer id) {
        return goodsDetailsMapper.selectGoodsDetailsById(id);
    }

    @Override
    public int insertGoodsDetails(GoodsDetails goodsDetails) {
        return goodsDetailsMapper.insertGoodsDetails(goodsDetails);
    }

    @Override
    public int updateGoodsDetails(GoodsDetails goodsDetails) {
        return goodsDetailsMapper.updateGoodsDetails(goodsDetails);
    }

    @Override
    public int deleteGoodsDetailsById(Integer id) {
        return goodsDetailsMapper.deleteGoodsDetailsById(id);
    }
}

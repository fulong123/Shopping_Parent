package com.dream.shopping.productserver.service.impl;

import com.dream.shopping.facade.po.Goods;
import com.dream.shopping.productserver.mapper.GoodMapper;
import com.dream.shopping.productserver.service.GoodsService;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述: 服务的实现
 * Created with IntelliJ IDEA.
 * User: huiliao
 * Date: 2018/11/21
 * Time: 20:43
 */
public class GoodsServiceImpl implements GoodsService {

    @Resource
    GoodMapper goodMapper;
    @Override
    public List<Goods> selectGoodsAll(Goods goods) {
        return goodMapper.selectGoodsAll(goods);
    }

    @Override
    public Goods selectGoodsById(Integer id) {
        return goodMapper.selectGoodsById(id);
    }

    @Override
    public int insertGoods(Goods goods) {
        return goodMapper.insertGoods(goods);
    }

    @Override
    public int updateGoods(Goods goods) {
        return goodMapper.updateGoods(goods);
    }

    @Override
    public int deleteGoodsById(Integer id) {
        return goodMapper.deleteGoodsById(id);
    }
}

package com.dream.shopping.orderserver.service.impl;

import com.dream.shopping.facade.po.Goods_Order;
import com.dream.shopping.orderserver.mapper.Goods_OrderMapper;
import com.dream.shopping.orderserver.service.IGoods_OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: qingquan
 * Date: 2018/11/21
 * Time: 14:10
 */
@Service
public class Goods_OrderServiceImpl implements IGoods_OrderService {

    @Autowired
    Goods_OrderMapper goods_orderMapper;

    @Override
    public List<Goods_Order> selectGoods_Order(int id) {
        return goods_orderMapper.selectGoods_OrderByUserId(id);
    }

    @Override
    public Goods_Order selectGoods_OrderById(int id) {
        return goods_orderMapper.selectGoods_OrderById(id);
    }

    @Override
    public int deleteGood_OrderById(int id) {
        return goods_orderMapper.deleteGood_OrderById(id);
    }

    @Override
    public int updateGoods_OrderById(int id) {
        return goods_orderMapper.updateGoods_OrderById(id);
    }
}

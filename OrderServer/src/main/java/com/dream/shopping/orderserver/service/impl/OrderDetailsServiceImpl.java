package com.dream.shopping.orderserver.service.impl;

import com.dream.shopping.facade.po.OrderDetails;
import com.dream.shopping.orderserver.mapper.OrderDetailsMapper;
import com.dream.shopping.orderserver.service.IOrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: qingquan
 * Date: 2018/11/21
 * Time: 14:15
 */
@Service
public class OrderDetailsServiceImpl implements IOrderDetailsService {

    @Autowired
    OrderDetailsMapper orderDetailsMapper;


    @Override
    public List<OrderDetails> selectOrderDetailsByOrderId(int id) {
        return orderDetailsMapper.selectOrderDetailsByOrderId(id);
    }

    @Override
    public OrderDetails selectOrderDetailsById(int id) {
        return orderDetailsMapper.selectOrderDetailsById(id);
    }

    @Override
    public int deleteOrderDetaIlsById(int id) {
        return orderDetailsMapper.deleteOrderDetaIlsById(id);
    }

    @Override
    public List<OrderDetails> selectOrderDetails() {
        return orderDetailsMapper.selectOrderDetails();
    }
}

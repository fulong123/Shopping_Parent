package com.dream.shopping.facade.orderservice;

import com.dream.shopping.facade.po.OrderDetails;

import java.util.List;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: qingquan
 * Date: 2018/11/21
 * Time: 14:37
 */
public interface IOrder_DetailsFacade {
    /**
     * 描述 查询所有订单项
     * @author cqq
     * @date 2018/11/20 15:27
     * @param []
     * @return java.util.List<com.dream.shopping.facade.po.OrderDetails>
     */
    List<OrderDetails> selectOrderDetailsByOrderId(int id);
    /**
     * 描述 根据Id查询订单项
     * @author cqq
     * @date 2018/11/20 15:28
     * @param [id]
     * @return com.dream.shopping.facade.po.OrderDetails
     */
    OrderDetails selectOrderDetailsById(int id);
    /**
     * 描述 根据Id删除订单项
     * @author cqq
     * @date 2018/11/20 15:29
     * @param [id]
     * @return int
     */
    int deleteOrderDetaIlsById(int id);
}
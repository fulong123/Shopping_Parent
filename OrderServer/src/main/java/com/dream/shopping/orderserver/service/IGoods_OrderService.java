package com.dream.shopping.orderserver.service;

import com.dream.shopping.facade.po.Goods_Order;

import java.util.List;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: qingquan
 * Date: 2018/11/21
 * Time: 14:09
 */

public interface IGoods_OrderService {
    /**
     * 描述
     * @author cqq
     * @date 2018/11/23 11:23
     * @param [goods_order]
     * @return java.util.List<com.dream.shopping.facade.po.Goods_Order>
     */
    List<Goods_Order> selectGoods_Order(Goods_Order goods_order);
    /**
     * 描述 根据Id查询订单
     * @author cqq
     * @date 2018/11/20 14:59
     * @param [id]
     * @return com.dream.shopping.facade.po.Goods_Order
     */
    Goods_Order selectGoods_OrderById(int id);
    /**
     * 描述 根据Id删除订单
     * @author cqq
     * @date 2018/11/20 15:00
     * @param [id]
     * @return int
     */
    int deleteGood_OrderById(int id);
    /**
     * 描述 根据Id修改订单
     * @author cqq
     * @date 2018/11/20 15:01
     * @param [id]
     * @return int
     */
    int updateGoods_Order(Goods_Order goods_order);
}

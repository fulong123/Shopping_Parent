package com.dream.shopping.orderserver.mapper;

import com.dream.shopping.facade.po.Goods_Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: qingquan
 * Date: 2018/11/20
 * Time: 14:06
 */
@Mapper
@Repository
public interface Goods_OrderMapper {

    /**
     * 描述 查询所有订单
     * @author cqq
     * @date 2018/11/20 14:21
     * @param []
     * @return java.util.List<com.dream.shopping.facade.po.Goods_Order>
     */
    List<Goods_Order> selectGoods_OrderByUserId(int id);

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
    int updateGoods_OrderById(int id);
}
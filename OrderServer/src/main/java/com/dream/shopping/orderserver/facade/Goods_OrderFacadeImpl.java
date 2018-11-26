package com.dream.shopping.orderserver.facade;

import com.alibaba.dubbo.config.annotation.Service;
import com.dream.shopping.facade.IServiceFacade.IGoods_OrderFacade;
import com.dream.shopping.facade.po.Goods_Order;
import com.dream.shopping.orderserver.service.IGoods_OrderService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: qingquan
 * Date: 2018/11/22
 * Time: 19:45
 */
@Component
@Service
public class Goods_OrderFacadeImpl implements IGoods_OrderFacade {

    @Resource
    private IGoods_OrderService goods_orderService;

    @Override
    public List<Goods_Order> selectGoods_Order(Goods_Order goods_order) {
        return goods_orderService.selectGoods_Order(goods_order);
    }

    @Override
    public Goods_Order selectGoods_OrderById(int id) {
        return goods_orderService.selectGoods_OrderById(id);
    }

    @Override
    public int deleteGood_OrderById(int id) {
        return goods_orderService.deleteGood_OrderById(id);
    }

    @Override
    public int updateGoods_Order(Goods_Order goods_order) {
        return goods_orderService.updateGoods_Order(goods_order);
    }
}

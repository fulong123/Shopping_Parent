package com.dream.shopping.orderserver.facade;

import com.alibaba.dubbo.config.annotation.Service;
import com.dream.shopping.facade.IServiceFacade.IOrder_DetailsFacade;
import com.dream.shopping.facade.po.OrderDetails;
import com.dream.shopping.orderserver.service.IOrderDetailsService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: qingquan
 * Date: 2018/11/26
 * Time: 17:40
 */
@Component
@Service
public class Order_DetailsFacadeImpl implements IOrder_DetailsFacade {

    @Resource
    private IOrderDetailsService orderDetailsService;

    @Override
    public List<OrderDetails> selectOrderDetailsByOrderId(int id) {
        return orderDetailsService.selectOrderDetailsByOrderId(id);
    }

    @Override
    public OrderDetails selectOrderDetailsById(int id) {
        return orderDetailsService.selectOrderDetailsById(id);
    }

    @Override
    public int deleteOrderDetaIlsById(int id) {
        return orderDetailsService.deleteOrderDetaIlsById(id);
    }

    @Override
    public List<OrderDetails> selectOrderDetails() {
        return orderDetailsService.selectOrderDetails();
    }
}

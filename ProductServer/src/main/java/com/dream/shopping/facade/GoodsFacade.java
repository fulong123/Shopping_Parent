package com.dream.shopping.facade;

import com.alibaba.dubbo.config.annotation.Service;
import com.dream.shopping.facade.IServiceFacade.IGoodsFacade;
import com.dream.shopping.facade.po.Goods;
import com.dream.shopping.productserver.service.GoodsService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: huiliao
 * Date: 2018/11/22
 * Time: 10:20
 */
@Component
@Service(version = "1.0.0")
public class GoodsFacade implements IGoodsFacade {

    @Resource
    GoodsService goodsService;

    @Override
    public List<Goods> selectGoodsAll(Goods goods) {
        return goodsService.selectGoodsAll(goods);
    }

    @Override
    public Goods selectGoodsById(Integer id) {
        return goodsService.selectGoodsById(id);
    }

    @Override
    public int insertGoods(Goods goods) {
        return goodsService.insertGoods(goods);
    }

    @Override
    public int updateGoods(Goods goods) {
        return goodsService.updateGoods(goods);
    }

    @Override
    public int deleteGoodsById(Integer id) {
        return goodsService.deleteGoodsById(id);
    }
}

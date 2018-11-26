package com.dream.shopping.productypeserver.facade;

import com.alibaba.dubbo.config.annotation.Service;
import com.dream.shopping.facade.IServiceFacade.IGoods_TypeFacade;
import com.dream.shopping.facade.po.GoodsType;
import com.dream.shopping.productypeserver.service.IGoods_TypeService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: qingquan
 * Date: 2018/11/24
 * Time: 10:45
 */
@Component
@Service
public class Goods_TypeFacadeImpl implements IGoods_TypeFacade {

    @Resource
    private IGoods_TypeService goods_typeService;

    @Override
    public int insertGoods_Type(GoodsType goodsType) {
        return goods_typeService.insertGoods_Type(goodsType);
    }

    @Override
    public int deleteGoods_TypeById(int id) {
        return goods_typeService.deleteGoods_TypeById(id);
    }

    @Override
    public int deleteGoods_TypeByParent_id(int id) {
        return goods_typeService.deleteGoods_TypeByParent_id(id);
    }

    @Override
    public List<GoodsType> selectGoods_Type(GoodsType goodsType) {
        return goods_typeService.selectGoods_Type(goodsType);
    }

    @Override
    public List<GoodsType> selectGoods_TypeByGoodsTypeGrade(int num) {
        return goods_typeService.selectGoods_TypeByGoodsTypeGrade(num);
    }

    @Override
    public List<GoodsType> selectGoods_TypeByParentId(int id) {
        return goods_typeService.selectGoods_TypeByParentId(id);
    }

    @Override
    public GoodsType selectGoods_TypeByGoodsTypeId(int id) {
        return goods_typeService.selectGoods_TypeByGoodsTypeId(id);
    }
}

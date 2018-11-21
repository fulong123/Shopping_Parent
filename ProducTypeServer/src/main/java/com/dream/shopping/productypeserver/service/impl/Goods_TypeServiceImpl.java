package com.dream.shopping.productypeserver.service.impl;

import com.dream.shopping.facade.po.GoodsType;
import com.dream.shopping.productypeserver.mapper.Goods_TypeMapper;
import com.dream.shopping.productypeserver.service.IGoods_TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: qingquan
 * Date: 2018/11/21
 * Time: 20:36
 */
@Service
public class Goods_TypeServiceImpl implements IGoods_TypeService {

    @Autowired
    Goods_TypeMapper goods_typeMapper;

    @Override
    public int insertGoods_Type() {
        return goods_typeMapper.insertGoods_Type();
    }

    @Override
    public int deleteGoods_TypeById(int id) {
        return goods_typeMapper.deleteGoods_TypeById(id);
    }

    @Override
    public int deleteGoods_TypeByParent_id(int id) {
        return goods_typeMapper.deleteGoods_TypeByParent_id(id);
    }

    @Override
    public List<GoodsType> selectGoods_Type() {
        return goods_typeMapper.selectGoods_Type();
    }

    @Override
    public List<GoodsType> selectGoods_TypeByGoodsTypeGrade(int num) {
        return goods_typeMapper.selectGoods_TypeByGoodsTypeGrade(num);
    }

    @Override
    public List<GoodsType> selectGoods_TypeByParentId(int id) {
        return goods_typeMapper.selectGoods_TypeByParentId(id);
    }

    @Override
    public GoodsType selectGoods_TypeByGoodsTypeId(int id) {
        return goods_typeMapper.selectGoods_TypeByGoodsTypeId(id);
    }
}

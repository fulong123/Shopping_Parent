package com.dream.shopping.facade.dto;

import com.dream.shopping.facade.po.Goods;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: huiliao
 * Date: 2018/11/29
 * Time: 11:40
 */
public class GoodsDto {
    private Goods goods;
    private String goodsTypeName;

    public GoodsDto() {
    }

    public GoodsDto(Goods goods, String goodsTypeName) {
        this.goods = goods;
        this.goodsTypeName = goodsTypeName;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public String getGoodsTypeName() {
        return goodsTypeName;
    }

    public void setGoodsTypeName(String goodsTypeName) {
        this.goodsTypeName = goodsTypeName;
    }

    @Override
    public String toString() {
        return "GoodsDto{" +
                "goods=" + goods +
                ", goodsTypeName='" + goodsTypeName + '\'' +
                '}';
    }
}

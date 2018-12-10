package com.dream.shopping.solrservice.pojo;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: huiliao
 * Date: 2018/12/5
 * Time: 11:46
 */
@Component
public class Goods implements Serializable {
    private static final long serialVersionUID = 5365786531943271378L;

    @Field(value = "goodsId")
    private Integer goodsId;            //商品id
    @Field(value = "goodsType")
    private String goodsType;           //商品类别
    @Field(value = "goodsTitle")
    private String goodsTitle;          //商品标题
    @Field(value = "goodsPrice")
    private Double goodsPrice;          //商品价格
    @Field(value = "goodsPhoto")
    private String goodsPhoto;          //商品图片

    public Goods() {
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public String getGoodsTitle() {
        return goodsTitle;
    }

    public void setGoodsTitle(String goodsTitle) {
        this.goodsTitle = goodsTitle;
    }

    public Double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsPhoto() {
        return goodsPhoto;
    }

    public void setGoodsPhoto(String goodsPhoto) {
        this.goodsPhoto = goodsPhoto;
    }
}

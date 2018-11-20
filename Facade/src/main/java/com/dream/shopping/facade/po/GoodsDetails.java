package com.dream.shopping.facade.po;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 描述:商品详情实体
 * Created with IntelliJ IDEA.
 * User: sky
 * Date: 2018/11/20
 * Time: 0:01
 */
@Component
@Entity
@Table
public class GoodsDetails implements Serializable {

    private static final long serialVersionUID = 8879790089677387217L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)     //主键生成策略
    private Integer goodsDetailsId;         //详情id
    @Column
    private Integer goodsId;                //商品id
    @Column
    private String goodsOrigin;             //商品产地
    @Column
    private String goodsName;               //商品名称
    @Column
    private String goodsBrand;              //商品品牌
    @Column
    private Double goodsWeight;             //商品重量
    @Column
    private String goods_Specification_packaging;   //规格和包装
    @Column
    private String goodsDetailPicture;      //商品详情图片

    public GoodsDetails() {
    }

    public GoodsDetails(Integer goodsId, String goodsOrigin, String goodsName, String goodsBrand, Double goodsWeight, String goods_Specification_packaging, String goodsDetailPicture) {
        this.goodsId = goodsId;
        this.goodsOrigin = goodsOrigin;
        this.goodsName = goodsName;
        this.goodsBrand = goodsBrand;
        this.goodsWeight = goodsWeight;
        this.goods_Specification_packaging = goods_Specification_packaging;
        this.goodsDetailPicture = goodsDetailPicture;
    }

    public Integer getGoodsDetailsId() {
        return goodsDetailsId;
    }

    public void setGoodsDetailsId(Integer goodsDetailsId) {
        this.goodsDetailsId = goodsDetailsId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsOrigin() {
        return goodsOrigin;
    }

    public void setGoodsOrigin(String goodsOrigin) {
        this.goodsOrigin = goodsOrigin;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsBrand() {
        return goodsBrand;
    }

    public void setGoodsBrand(String goodsBrand) {
        this.goodsBrand = goodsBrand;
    }

    public Double getGoodsWeight() {
        return goodsWeight;
    }

    public void setGoodsWeight(Double goodsWeight) {
        this.goodsWeight = goodsWeight;
    }

    public String getGoods_Specification_packaging() {
        return goods_Specification_packaging;
    }

    public void setGoods_Specification_packaging(String goods_Specification_packaging) {
        this.goods_Specification_packaging = goods_Specification_packaging;
    }

    public String getGoodsDetailPicture() {
        return goodsDetailPicture;
    }

    public void setGoodsDetailPicture(String goodsDetailPicture) {
        this.goodsDetailPicture = goodsDetailPicture;
    }

    @Override
    public String toString() {
        return "GoodsDetails{" +
                "goodsDetailsId=" + goodsDetailsId +
                ", goodsId=" + goodsId +
                ", goodsOrigin='" + goodsOrigin + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsBrand='" + goodsBrand + '\'' +
                ", goodsWeight=" + goodsWeight +
                ", goods_Specification_packaging='" + goods_Specification_packaging + '\'' +
                ", goodsDetailPicture='" + goodsDetailPicture + '\'' +
                '}';
    }
}
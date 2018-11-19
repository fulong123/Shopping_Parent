package com.dream.shopping.pojo.po;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 描述:商品实体
 * Created with IntelliJ IDEA.
 * User: sky
 * Date: 2018/11/19
 * Time: 23:53
 */
@Component
@Entity
@Table
public class Goods implements Serializable {

    private static final long serialVersionUID = -8765016312888932457L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)     //主键生成策略
    private Integer goodsId;            //商品id
    @Column
    private String goodsType;           //商品类别
    @Column
    private String goodsTitle;          //商品标题
    @Column
    private Double goodsPrice;          //商品价格
    @Column
    private Integer dealId;             //商家id
    @Column
    private String createTime;          //创建时间
    @Column
    private Integer quantity_In_Stock;  //库存数量
    @Column
    private Integer sales_Quantity;     //销售数量
    @Column
    private String goodsPicture;        //商品图片

    public Goods() {
    }

    public Goods(Integer goodsId, String goodsType, String goodsTitle, Double goodsPrice, Integer dealId, String createTime, Integer quantity_In_Stock, Integer sales_Quantity, String goodsPicture) {
        this.goodsId = goodsId;
        this.goodsType = goodsType;
        this.goodsTitle = goodsTitle;
        this.goodsPrice = goodsPrice;
        this.dealId = dealId;
        this.createTime = createTime;
        this.quantity_In_Stock = quantity_In_Stock;
        this.sales_Quantity = sales_Quantity;
        this.goodsPicture = goodsPicture;
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

    public Integer getDealId() {
        return dealId;
    }

    public void setDealId(Integer dealId) {
        this.dealId = dealId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getQuantity_In_Stock() {
        return quantity_In_Stock;
    }

    public void setQuantity_In_Stock(Integer quantity_In_Stock) {
        this.quantity_In_Stock = quantity_In_Stock;
    }

    public Integer getSales_Quantity() {
        return sales_Quantity;
    }

    public void setSales_Quantity(Integer sales_Quantity) {
        this.sales_Quantity = sales_Quantity;
    }

    public String getGoodsPicture() {
        return goodsPicture;
    }

    public void setGoodsPicture(String goodsPicture) {
        this.goodsPicture = goodsPicture;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsId=" + goodsId +
                ", goodsType='" + goodsType + '\'' +
                ", goodsTitle='" + goodsTitle + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", dealId=" + dealId +
                ", createTime='" + createTime + '\'' +
                ", quantity_In_Stock=" + quantity_In_Stock +
                ", sales_Quantity=" + sales_Quantity +
                ", goodsPicture='" + goodsPicture + '\'' +
                '}';
    }
}
package com.dream.shopping.facade.po;

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
    @Column(name = "goodsId")
    private Integer goodsId;            //商品id
    @Column(name = "goodsType")
    private String goodsType;           //商品类别
    @Column(name = "goodsTitle")
    private String goodsTitle;          //商品标题
    @Column(name = "goodsPrice")
    private Double goodsPrice;          //商品价格
    @Column(name = "goodsPhoto")
    private String goodsPhoto;            //商品图片
    @Column(name = "createTime")
    private String createTime;          //创建时间
    @Column(name = "quantityInStock")
    private Integer quantityInStock;  //库存数量
    @Column(name = "salesQuantity")
    private Integer salesQuantity;     //销售数量
    @Column(name = "state")
    private Integer state;        //商品状态

    public Goods() {
    }

    public Goods(String goodsType, String goodsTitle,  String goodsPhoto, String createTime, Integer quantityInStock,Double goodsPrice, Integer salesQuantity, Integer state) {
        this.goodsType = goodsType;
        this.goodsTitle = goodsTitle;
        this.goodsPrice = goodsPrice;
        this.goodsPhoto = goodsPhoto;
        this.createTime = createTime;
        this.quantityInStock = quantityInStock;
        this.salesQuantity = salesQuantity;
        this.state = state;
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(Integer quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public Integer getSalesQuantity() {
        return salesQuantity;
    }

    public void setSalesQuantity(Integer salesQuantity) {
        this.salesQuantity = salesQuantity;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsId=" + goodsId +
                ", goodsType='" + goodsType + '\'' +
                ", goodsTitle='" + goodsTitle + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", goodsPhoto='" + goodsPhoto + '\'' +
                ", createTime='" + createTime + '\'' +
                ", quantityInStock=" + quantityInStock +
                ", salesQuantity=" + salesQuantity +
                ", state=" + state +
                '}';
    }
}
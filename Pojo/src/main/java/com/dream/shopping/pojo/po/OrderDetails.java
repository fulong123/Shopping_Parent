package com.dream.shopping.pojo.po;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 描述:订单详情实体
 * Created with IntelliJ IDEA.
 * User: sky
 * Date: 2018/11/19
 * Time: 23:48
 */
@Component
@Entity
@Table
public class OrderDetails implements Serializable {

    private static final long serialVersionUID = -3249474200877266640L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)     //主键生成策略
    private Integer orderDetailsId;         //详情id
    @Column
    private Integer orderId;                //订单id
    @Column
    private Integer goodsId;                //商品id
    @Column
    private Integer merchantId;             //商家id
    @Column
    private String createTime;              //创建时间
    @Column
    private String dealNum;                 //交易数量

    public OrderDetails() {
    }

    public OrderDetails(Integer orderId, Integer goodsId, Integer merchantId, String createTime, String dealNum) {
        this.orderId = orderId;
        this.goodsId = goodsId;
        this.merchantId = merchantId;
        this.createTime = createTime;
        this.dealNum = dealNum;
    }

    public Integer getOrderDetailsId() {
        return orderDetailsId;
    }

    public void setOrderDetailsId(Integer orderDetailsId) {
        this.orderDetailsId = orderDetailsId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getDealNum() {
        return dealNum;
    }

    public void setDealNum(String dealNum) {
        this.dealNum = dealNum;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "orderDetailsId=" + orderDetailsId +
                ", orderId=" + orderId +
                ", goodsId=" + goodsId +
                ", merchantId=" + merchantId +
                ", createTime='" + createTime + '\'' +
                ", dealNum='" + dealNum + '\'' +
                '}';
    }
}
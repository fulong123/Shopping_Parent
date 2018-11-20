package com.dream.shopping.facade.po;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 描述:订单实体
 * Created with IntelliJ IDEA.
 * User: sky
 * Date: 2018/11/19
 * Time: 23:40
 */
@Component
@Entity
@Table
public class Goods_Order implements Serializable {

    private static final long serialVersionUID = -1645075781315825450L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)     //主键生成策略
    private Integer goods_OrderId;        //订单id
    @Column
    private String goods_OrderNum;        //订单编号
    @Column
    private String goods_OrderTime;       //订单创建时间
    @Column
    private String payTime;         //支付时间
    @Column
    private Double goods_OrderSumMoney;   //订单总价
    @Column
    private Integer goods_OrderState;     //订单状态
    @Column
    private String payState;        //支付类型
    @Column
    private String userAddress;     //收货地址
    @Column
    private String userNum;         //收货人电话
    @Column
    private Integer userId;         //用户id

    public Goods_Order() {
    }

    public Goods_Order(String goods_OrderNum, String goods_OrderTime, String payTime, Double goods_OrderSumMoney, Integer goods_OrderState, String payState, String userAddress, String userNum, Integer userId) {
        this.goods_OrderNum = goods_OrderNum;
        this.goods_OrderTime = goods_OrderTime;
        this.payTime = payTime;
        this.goods_OrderSumMoney = goods_OrderSumMoney;
        this.goods_OrderState = goods_OrderState;
        this.payState = payState;
        this.userAddress = userAddress;
        this.userNum = userNum;
        this.userId = userId;
    }

    public Integer getGoods_OrderId() {
        return goods_OrderId;
    }

    public void setGoods_OrderId(Integer goods_OrderId) {
        this.goods_OrderId = goods_OrderId;
    }

    public String getGoods_OrderNum() {
        return goods_OrderNum;
    }

    public void setGoods_OrderNum(String goods_OrderNum) {
        this.goods_OrderNum = goods_OrderNum;
    }

    public String getGoods_OrderTime() {
        return goods_OrderTime;
    }

    public void setGoods_OrderTime(String goods_OrderTime) {
        this.goods_OrderTime = goods_OrderTime;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public Double getGoods_OrderSumMoney() {
        return goods_OrderSumMoney;
    }

    public void setGoods_OrderSumMoney(Double goods_OrderSumMoney) {
        this.goods_OrderSumMoney = goods_OrderSumMoney;
    }

    public Integer getGoods_OrderState() {
        return goods_OrderState;
    }

    public void setGoods_OrderState(Integer goods_OrderState) {
        this.goods_OrderState = goods_OrderState;
    }

    public String getPayState() {
        return payState;
    }

    public void setPayState(String payState) {
        this.payState = payState;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserNum() {
        return userNum;
    }

    public void setUserNum(String userNum) {
        this.userNum = userNum;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Goods_Order{" +
                "goods_OrderId=" + goods_OrderId +
                ", goods_OrderNum='" + goods_OrderNum + '\'' +
                ", goods_OrderTime='" + goods_OrderTime + '\'' +
                ", payTime='" + payTime + '\'' +
                ", goods_OrderSumMoney=" + goods_OrderSumMoney +
                ", goods_OrderState=" + goods_OrderState +
                ", payState='" + payState + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userNum='" + userNum + '\'' +
                ", userId=" + userId +
                '}';
    }
}
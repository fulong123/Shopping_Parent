package com.dream.shopping.facade.po;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 描述:地址实体
 * Created with IntelliJ IDEA.
 * User: huiliao
 * Date: 2018/11/19
 * Time: 20:48
 */
@Component
@Entity
@Table
public class Address implements Serializable {

    private static final long serialVersionUID = -3208957601884456367L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)     //主键生成策略
    @Column(name = "addressId")
    private Integer addressId;                  //地址id
    @Column(name = "distributionArea")
    private String distributionArea;            //配送地区
    @Column(name = "consigneeName")
    private String consigneeName;               //收货人姓名
    @Column(name = "email")
    private String email;                       //电子邮箱
    @Column(name = "detailedAddress")
    private String detailedAddress;             //详细地址
    @Column(name = "postalCode")
    private String postalCode;                  //邮政编码
    @Column(name = "phone")
    private String phone;                       //手机
    @Column(name = "telNum")
    private String telNum;                      //电话
    @Column(name = "landmarkBuilding")
    private String landmarkBuilding;            //标志建筑
    @Column(name = "deliveryTime")
    private String deliveryTime;                //最佳送货时间
    @Column(name = "isDefault")
    private Integer isDefault;                   //是否默认

    public Address() {
    }

    public Address(Integer addressId, String distributionArea, String consigneeName, String email, String detailedAddress, String postalCode, String phone, String telNum, String landmarkBuilding, String deliveryTime, Integer isDefault) {
        this.addressId = addressId;
        this.distributionArea = distributionArea;
        this.consigneeName = consigneeName;
        this.email = email;
        this.detailedAddress = detailedAddress;
        this.postalCode = postalCode;
        this.phone = phone;
        this.telNum = telNum;
        this.landmarkBuilding = landmarkBuilding;
        this.deliveryTime = deliveryTime;
        this.isDefault = isDefault;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getDistributionArea() {
        return distributionArea;
    }

    public void setDistributionArea(String distributionArea) {
        this.distributionArea = distributionArea;
    }

    public String getConsigneeName() {
        return consigneeName;
    }

    public void setConsigneeName(String consigneeName) {
        this.consigneeName = consigneeName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDetailedAddress() {
        return detailedAddress;
    }

    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTelNum() {
        return telNum;
    }

    public void setTelNum(String telNum) {
        this.telNum = telNum;
    }

    public String getLandmarkBuilding() {
        return landmarkBuilding;
    }

    public void setLandmarkBuilding(String landmarkBuilding) {
        this.landmarkBuilding = landmarkBuilding;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", distributionArea='" + distributionArea + '\'' +
                ", consigneeName='" + consigneeName + '\'' +
                ", email='" + email + '\'' +
                ", detailedAddress='" + detailedAddress + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", phone='" + phone + '\'' +
                ", telNum='" + telNum + '\'' +
                ", landmarkBuilding='" + landmarkBuilding + '\'' +
                ", deliveryTime='" + deliveryTime + '\'' +
                ", isDefault='" + isDefault + '\'' +
                '}';
    }
}

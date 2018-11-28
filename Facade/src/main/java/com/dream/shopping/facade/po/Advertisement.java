package com.dream.shopping.facade.po;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: sky
 * Date: 2018/11/20
 * Time: 0:20
 */
@Component
@Entity
@Table
public class Advertisement implements Serializable {

    private static final long serialVersionUID = -1137584755112829452L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)     //主键生成策略
    private Integer AdvertisementId;        //广告id
    @Column
    private String AdvertisementPhoto;      //广告图片
    @Column
    private String AdvertisementType;       //广告类别
    @Column
    private Integer goodsId;                //商品id

    public Advertisement() {
    }

    public Advertisement(String advertisementPhoto, String advertisementType, Integer goodsId) {
        AdvertisementPhoto = advertisementPhoto;
        AdvertisementType = advertisementType;
        this.goodsId = goodsId;
    }

    public Integer getAdvertisementId() {
        return AdvertisementId;
    }

    public void setAdvertisementId(Integer advertisementId) {
        AdvertisementId = advertisementId;
    }

    public String getAdvertisementPhoto() {
        return AdvertisementPhoto;
    }

    public void setAdvertisementPhoto(String advertisementPhoto) {
        AdvertisementPhoto = advertisementPhoto;
    }

    public String getAdvertisementType() {
        return AdvertisementType;
    }

    public void setAdvertisementType(String advertisementType) {
        AdvertisementType = advertisementType;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }


    @Override
    public String toString() {
        return "Advertisement{" +
                "AdvertisementId=" + AdvertisementId +
                ", AdvertisementPhoto='" + AdvertisementPhoto + '\'' +
                ", AdvertisementType='" + AdvertisementType + '\'' +
                ", goodsId=" + goodsId +
                '}';
    }
}

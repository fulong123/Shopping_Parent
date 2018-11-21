package com.dream.shopping.facade.po;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: sky
 * Date: 2018/11/20
 * Time: 0:23
 */
@Component
@Entity
@Table
public class Brand implements Serializable {

    private static final long serialVersionUID = 1110782121567097526L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)     //主键生成策略
    @Column(name = "brandId")
    private Integer brandId;        //品牌id
    @Column(name = "brandName")
    private String brandName;       //品牌名字
    @Column(name = "photo")
    private String photo;           //品牌图片
    public Brand() {
    }

    public Brand(String brandName, String photo) {
        this.brandName = brandName;
        this.photo = photo;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Brand(String brandName) {
        this.brandName = brandName;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "brandId=" + brandId +
                ", brandName='" + brandName + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}
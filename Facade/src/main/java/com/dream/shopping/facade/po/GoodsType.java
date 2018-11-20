package com.dream.shopping.facade.po;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 描述:商品类别实体
 * Created with IntelliJ IDEA.
 * User: sky
 * Date: 2018/11/20
 * Time: 0:08
 */
@Component
@Entity
@Table
public class GoodsType implements Serializable {

    private static final long serialVersionUID = 942073609973844973L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)     //主键生成策略
    private Integer goodsTypeId;        //商品类别id
    @Column
    private String goodsName;           //商品名字
    @Column
    private String goodsDes;            //商品描述
    @Column
    private Integer goodsTypeGrade;     //等级
    @Column
    private Integer parentId;           //父id

    public GoodsType() {
    }

    public GoodsType(String goodsName, String goodsDes, Integer goodsTypeGrade, Integer parentId) {
        this.goodsName = goodsName;
        this.goodsDes = goodsDes;
        this.goodsTypeGrade = goodsTypeGrade;
        this.parentId = parentId;
    }

    public Integer getGoodsTypeId() {
        return goodsTypeId;
    }

    public void setGoodsTypeId(Integer goodsTypeId) {
        this.goodsTypeId = goodsTypeId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsDes() {
        return goodsDes;
    }

    public void setGoodsDes(String goodsDes) {
        this.goodsDes = goodsDes;
    }

    public Integer getGoodsTypeGrade() {
        return goodsTypeGrade;
    }

    public void setGoodsTypeGrade(Integer goodsTypeGrade) {
        this.goodsTypeGrade = goodsTypeGrade;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "GoodsType{" +
                "goodsTypeId=" + goodsTypeId +
                ", goodsName='" + goodsName + '\'' +
                ", goodsDes='" + goodsDes + '\'' +
                ", goodsTypeGrade=" + goodsTypeGrade +
                ", parentId=" + parentId +
                '}';
    }
}
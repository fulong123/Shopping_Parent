package com.dream.shopping.pojo.po;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 描述:新闻实体
 * Created with IntelliJ IDEA.
 * User: sky
 * Date: 2018/11/19
 * Time: 23:36
 */
@Component
@Entity
@Table
public class News implements Serializable {

    private static final long serialVersionUID = -44573069872317817L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    //主键生成策略
    private Integer newsId;         //新闻ID
    @Column
    private String newsTitle;       //新闻标题
    @Column
    private String newsType;        //新闻类型

    public News() {
    }

    public News(String newsTitle, String newsType) {
        this.newsTitle = newsTitle;
        this.newsType = newsType;
    }

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsType() {
        return newsType;
    }

    public void setNewsType(String newsType) {
        this.newsType = newsType;
    }

    @Override
    public String toString() {
        return "News{" +
                "newsId=" + newsId +
                ", newsTitle='" + newsTitle + '\'' +
                ", newsType='" + newsType + '\'' +
                '}';
    }
}
package com.dream.shopping.facade.po;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * 描述:管理员实体
 * Created with IntelliJ IDEA.
 * User: sky
 * Date: 2018/11/19
 * Time: 23:29
 */
@Component
@Entity
@Table
public class Administrator implements Serializable {

    private static final long serialVersionUID = 894775472174228408L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)     //主键生成策略
    private Integer administratorId;        //管理员id
    @Column
    private String administratorName;       //管理员姓名
    @Column
    private String password;                //管理员密码
    @Column
    private String createTime;              //管理员创建时间
    @Column
    private Integer isSuperAdmin;           //是否为超级管理员

    public Administrator() {
    }

    public Administrator(String administratorName, String password, String createTime, Integer isSuperAdmin) {
        this.administratorName = administratorName;
        this.password = password;
        this.createTime = createTime;
        this.isSuperAdmin = isSuperAdmin;
    }

    public Integer getAdministratorId() {
        return administratorId;
    }

    public void setAdministratorId(Integer administratorId) {
        this.administratorId = administratorId;
    }

    public String getAdministratorName() {
        return administratorName;
    }

    public void setAdministratorName(String administratorName) {
        this.administratorName = administratorName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getIsSuperAdmin() {
        return isSuperAdmin;
    }

    public void setIsSuperAdmin(Integer isSuperAdmin) {
        this.isSuperAdmin = isSuperAdmin;
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "administratorId=" + administratorId +
                ", administratorName='" + administratorName + '\'' +
                ", password='" + password + '\'' +
                ", createTime='" + createTime + '\'' +
                ", isSuperAdmin=" + isSuperAdmin +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Administrator that = (Administrator) o;
        return Objects.equals(administratorName, that.administratorName) &&
                Objects.equals(password, that.password);
    }
}
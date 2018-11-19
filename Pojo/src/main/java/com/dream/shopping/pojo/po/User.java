package com.dream.shopping.pojo.po;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: sky
 * Date: 2018/11/19
 * Time: 15:41
 */
@Component
@Entity
@Table
public class User implements Serializable {

    private static final long serialVersionUID = 7159250874103984414L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自动生成策略
    private Integer uId;            //用户ID
    @Column
    private String userRealName;    //用户真实姓名
    @Column
    private String username;        //用户名
    @Column
    private Integer age;            //年龄
    @Column
    private String password;        //密码
    @Column
    private String address;         //地址
    @Column
    private String tel;             //电话
    @Column
    private String qq;              //qq
    @Column
    private String weChat;          //微信
    @Column
    private String email;           //电子邮箱
    @Column
    private String sex;             //性别

    public User() {
    }

    public User(Integer uId, String userRealName, String username, Integer age, String password, String address, String tel, String qq, String weChat, String email, String sex) {
        this.uId = uId;
        this.userRealName = userRealName;
        this.username = username;
        this.age = age;
        this.password = password;
        this.address = address;
        this.tel = tel;
        this.qq = qq;
        this.weChat = weChat;
        this.email = email;
        this.sex = sex;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWeChat() {
        return weChat;
    }

    public void setWeChat(String weChat) {
        this.weChat = weChat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "uId=" + uId +
                ", userRealName='" + userRealName + '\'' +
                ", username='" + username + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", tel='" + tel + '\'' +
                ", qq='" + qq + '\'' +
                ", weChat='" + weChat + '\'' +
                ", email='" + email + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
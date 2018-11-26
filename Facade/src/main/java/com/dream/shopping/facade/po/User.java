package com.dream.shopping.facade.po;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 描述:用户实体
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
    @GeneratedValue(strategy = GenerationType.IDENTITY) //主键生成策略
    private Integer uId;            //用户ID
    @Column
    private String userRealName;    //用户真实姓名
    @Column
    private String userLoginName;   //用户登陆名
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
    private String userIdCard;      //用户身份证
    @Column
    private String inviter;         //邀请人
    @Column
    private String weChat;          //微信
    @Column
    private String email;           //电子邮箱
    @Column
    private String sex;             //性别
    @Column
    private String addressId;       //地址id
    @Column
    private String createTime;      //注册时间
    @Column
    private String lastLoginTime;   //上次登陆时间
    @Column
    private Double Monetary;        //消费金额
    @Column
    private String integral;        //积分
    @Column
    private Double balance;         //余额
    @Column
    private Integer red_Envelopes_Count;    //红包个数
    @Column
    private Double red_EnvelopesValue;      //红包价格
    @Column
    private Integer goodsId;        //商品id

    public User() {
    }

    public User(String userRealName, String userLoginName, Integer age, String password, String address, String tel, String qq, String userIdCard, String inviter, String weChat, String email, String sex, String addressId, String createTime, String lastLoginTime, Double monetary, String integral, Double balance, Integer red_Envelopes_Count, Double red_EnvelopesValue, Integer goodsId) {
        this.userRealName = userRealName;
        this.userLoginName = userLoginName;
        this.age = age;
        this.password = password;
        this.address = address;
        this.tel = tel;
        this.qq = qq;
        this.userIdCard = userIdCard;
        this.inviter = inviter;
        this.weChat = weChat;
        this.email = email;
        this.sex = sex;
        this.addressId = addressId;
        this.createTime = createTime;
        this.lastLoginTime = lastLoginTime;
        this.Monetary = monetary;
        this.integral = integral;
        this.balance = balance;
        this.red_Envelopes_Count = red_Envelopes_Count;
        this.red_EnvelopesValue = red_EnvelopesValue;
        this.goodsId = goodsId;
    }

    public String getUserLoginName() {
        return userLoginName;
    }

    public void setUserLoginName(String userLoginName) {
        this.userLoginName = userLoginName;
    }

    public String getUserIdCard() {
        return userIdCard;
    }

    public void setUserIdCard(String userIdCard) {
        this.userIdCard = userIdCard;
    }

    public String getInviter() {
        return inviter;
    }

    public void setInviter(String inviter) {
        this.inviter = inviter;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Double getMonetary() {
        return Monetary;
    }

    public void setMonetary(Double monetary) {
        Monetary = monetary;
    }

    public String getIntegral() {
        return integral;
    }

    public void setIntegral(String integral) {
        this.integral = integral;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Integer getRed_Envelopes_Count() {
        return red_Envelopes_Count;
    }

    public void setRed_Envelopes_Count(Integer red_Envelopes_Count) {
        this.red_Envelopes_Count = red_Envelopes_Count;
    }

    public Double getRed_EnvelopesValue() {
        return red_EnvelopesValue;
    }

    public void setRed_EnvelopesValue(Double red_EnvelopesValue) {
        this.red_EnvelopesValue = red_EnvelopesValue;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
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
                ", userLoginName='" + userLoginName + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", tel='" + tel + '\'' +
                ", qq='" + qq + '\'' +
                ", userIdCard='" + userIdCard + '\'' +
                ", inviter='" + inviter + '\'' +
                ", weChat='" + weChat + '\'' +
                ", email='" + email + '\'' +
                ", sex='" + sex + '\'' +
                ", addressId='" + addressId + '\'' +
                ", createTime='" + createTime + '\'' +
                ", lastLoginTime='" + lastLoginTime + '\'' +
                ", Monetary=" + Monetary +
                ", integral='" + integral + '\'' +
                ", balance=" + balance +
                ", red_Envelopes_Count=" + red_Envelopes_Count +
                ", red_EnvelopesValue=" + red_EnvelopesValue +
                ", goodsId=" + goodsId +
                '}';
    }
}
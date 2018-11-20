package com.dream.shopping.shoppinguserservice.vo;

import com.dream.shopping.facade.po.User;
import org.springframework.stereotype.Component;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: sky
 * Date: 2018/11/20
 * Time: 12:02
 */
@Component
public class CustomerUser extends User {

    private static final long serialVersionUID = -6266009756248001560L;

    private Integer uId;            //用户ID

    private String userRealName;    //用户真实姓名

    private String userLoginName;   //用户登陆名

    private Integer age;            //年龄

    private String password;        //密码

    private String address;         //地址

    private String tel;             //电话

    private String qq;              //qq

    private String userIdCard;      //用户身份证

    private String inviter;         //邀请人

    private String weChat;          //微信

    private String email;           //电子邮箱

    private String sex;             //性别

    private String addressId;       //地址id

    private String createTime;      //注册时间

    private String lastLoginTime;   //上次登陆时间

    private Double Monetary;        //消费金额

    private String integral;        //积分

    private Double balance;         //余额

    private Integer red_Envelopes_Count;    //红包个数

    private Double red_EnvelopesValue;      //红包价格

    private Integer goodsId;        //商品id

    public CustomerUser() {
    }

    public CustomerUser(Integer uId, Integer age1) {
        this.uId = uId;
        this.age = age1;
    }

    @Override
    public Integer getuId() {
        return uId;
    }

    @Override
    public void setuId(Integer uId) {
        this.uId = uId;
    }

    @Override
    public String getUserRealName() {
        return userRealName;
    }

    @Override
    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }

    @Override
    public String getUserLoginName() {
        return userLoginName;
    }

    @Override
    public void setUserLoginName(String userLoginName) {
        this.userLoginName = userLoginName;
    }

    @Override
    public Integer getAge() {
        return age;
    }

    @Override
    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getTel() {
        return tel;
    }

    @Override
    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String getQq() {
        return qq;
    }

    @Override
    public void setQq(String qq) {
        this.qq = qq;
    }

    @Override
    public String getUserIdCard() {
        return userIdCard;
    }

    @Override
    public void setUserIdCard(String userIdCard) {
        this.userIdCard = userIdCard;
    }

    @Override
    public String getInviter() {
        return inviter;
    }

    @Override
    public void setInviter(String inviter) {
        this.inviter = inviter;
    }

    @Override
    public String getWeChat() {
        return weChat;
    }

    @Override
    public void setWeChat(String weChat) {
        this.weChat = weChat;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getSex() {
        return sex;
    }

    @Override
    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String getAddressId() {
        return addressId;
    }

    @Override
    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    @Override
    public String getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String getLastLoginTime() {
        return lastLoginTime;
    }

    @Override
    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    @Override
    public Double getMonetary() {
        return Monetary;
    }

    @Override
    public void setMonetary(Double monetary) {
        Monetary = monetary;
    }

    @Override
    public String getIntegral() {
        return integral;
    }

    @Override
    public void setIntegral(String integral) {
        this.integral = integral;
    }

    @Override
    public Double getBalance() {
        return balance;
    }

    @Override
    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public Integer getRed_Envelopes_Count() {
        return red_Envelopes_Count;
    }

    @Override
    public void setRed_Envelopes_Count(Integer red_Envelopes_Count) {
        this.red_Envelopes_Count = red_Envelopes_Count;
    }

    @Override
    public Double getRed_EnvelopesValue() {
        return red_EnvelopesValue;
    }

    @Override
    public void setRed_EnvelopesValue(Double red_EnvelopesValue) {
        this.red_EnvelopesValue = red_EnvelopesValue;
    }

    @Override
    public Integer getGoodsId() {
        return goodsId;
    }

    @Override
    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

}
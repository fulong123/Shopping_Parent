package com.dream.shopping.facade.po;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: sky
 * Date: 2018/12/7
 * Time: 19:34
 */
@Component
public class MessageStateInfo {

    private int id;

    private String msgType;

    private String msgObj;

    private int msgState;  //1:表示未发送  2:表示发送成功  3:表示未接受  4：表示结束但是失败  5：表示消费成功

    private Date msgCreateTime;

    private Date msgUpdateTime;

    public MessageStateInfo() {
    }

    public MessageStateInfo(String msgType, String msgObj, int msgState, Date msgCreateTime, Date msgUpdateTime) {
        this.msgType = msgType;
        this.msgObj = msgObj;
        this.msgState = msgState;
        this.msgCreateTime = msgCreateTime;
        this.msgUpdateTime = msgUpdateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getMsgObj() {
        return msgObj;
    }

    public void setMsgObj(String msgObj) {
        this.msgObj = msgObj;
    }

    public int getMsgState() {
        return msgState;
    }

    public void setMsgState(int msgState) {
        this.msgState = msgState;
    }

    public Date getMsgCreateTime() {
        return msgCreateTime;
    }

    public void setMsgCreateTime(Date msgCreateTime) {
        this.msgCreateTime = msgCreateTime;
    }

    public Date getMsgUpdateTime() {
        return msgUpdateTime;
    }

    public void setMsgUpdateTime(Date msgUpdateTime) {
        this.msgUpdateTime = msgUpdateTime;
    }

    @Override
    public String toString() {
        return "MessageStateInfo{" +
                "id=" + id +
                ", msgType='" + msgType + '\'' +
                ", msgObj='" + msgObj + '\'' +
                ", msgState=" + msgState +
                ", msgCreateTime=" + msgCreateTime +
                ", msgUpdateTime=" + msgUpdateTime +
                '}';
    }
}
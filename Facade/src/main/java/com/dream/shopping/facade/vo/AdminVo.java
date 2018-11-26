package com.dream.shopping.facade.vo;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: sky
 * Date: 2018/11/26
 * Time: 20:06
 */
@Component
public class AdminVo implements Serializable {

    private static final long serialVersionUID = 167703936613214504L;

    private AdminCustomer adminCustomer;
    private String startTime;
    private String endTime;

    public AdminVo() {
    }

    public AdminVo(AdminCustomer adminCustomer) {
        this.adminCustomer = adminCustomer;
    }

    public AdminCustomer getAdminCustomer() {
        return adminCustomer;
    }

    public void setAdminCustomer(AdminCustomer adminCustomer) {
        this.adminCustomer = adminCustomer;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "AdminVo{" +
                "adminCustomer=" + adminCustomer +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }

}
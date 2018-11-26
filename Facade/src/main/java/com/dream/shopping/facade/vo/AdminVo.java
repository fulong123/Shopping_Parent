package com.dream.shopping.facade.vo;

import com.dream.shopping.facade.po.Administrator;
import org.springframework.stereotype.Component;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: sky
 * Date: 2018/11/26
 * Time: 20:06
 */
@Component
public class AdminVo extends Administrator {

    private static final long serialVersionUID = 167703936613214504L;

    private String administratorName;
    private String startTime;
    private String endTime;
    private Integer isSuperAdmin;

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
    public String getAdministratorName() {
        return administratorName;
    }

    @Override
    public void setAdministratorName(String administratorName) {
        this.administratorName = administratorName;
    }

    @Override
    public Integer getIsSuperAdmin() {
        return isSuperAdmin;
    }

    @Override
    public void setIsSuperAdmin(Integer isSuperAdmin) {
        this.isSuperAdmin = isSuperAdmin;
    }

    @Override
    public String toString() {
        return "AdminVo{" +
                "startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }

}
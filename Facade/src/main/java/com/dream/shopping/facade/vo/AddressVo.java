package com.dream.shopping.facade.vo;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import java.io.Serializable;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: huiliao
 * Date: 2018/11/20
 * Time: 11:32
 */
@Component
public class AddressVo implements Serializable {

    private static final long serialVersionUID = -7235225216870775844L;

    private ConstomAddress constomAddress;

    public AddressVo() {
    }

    public AddressVo(ConstomAddress constomAddress) {
        this.constomAddress = constomAddress;
    }

    public ConstomAddress getConstomAddress() {
        return constomAddress;
    }

    public void setConstomAddress(ConstomAddress constomAddress) {
        this.constomAddress = constomAddress;
    }

    @Override
    public String toString() {
        return "AddressVo{" +
                "constomAddress=" + constomAddress +
                '}';
    }
}

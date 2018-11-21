package com.dream.shopping.facade.impl;

import com.dream.shopping.facade.addressservice.IAddressFacade;
import com.dream.shopping.facade.po.Address;
import com.dream.shopping.addressserver.service.AddressService;
import com.dream.shopping.facade.vo.AddressVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: huiliao
 * Date: 2018/11/20
 * Time: 14:22
 */
@Component
public class AddressFacade implements IAddressFacade {

    private AddressService addressService = null;

    @Autowired
    public void setAddressService(AddressService addressService) {
        this.addressService = addressService;
    }

    @Override
    public List<Address> selectAll(AddressVo addressVo) {
        return addressService.selectAll(addressVo);
    }

    @Override
    public Address selectAddressById(Integer id) {
        return addressService.selectAddressById(id);
    }

    @Override
    public int insertAddress(Address address) {
        return addressService.insertAddress(address);
    }

    @Override
    public int updateAddress(Address address) {
        return addressService.updateAddress(address);
    }

    @Override
    public int deleteAddressById(Integer id) {
        return addressService.deleteAddressById(id);
    }
}

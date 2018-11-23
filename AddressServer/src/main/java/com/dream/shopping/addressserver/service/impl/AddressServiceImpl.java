package com.dream.shopping.addressserver.service.impl;

import com.dream.shopping.facade.po.Address;
import com.dream.shopping.addressserver.mapper.AddressMapper;
import com.dream.shopping.addressserver.service.AddressService;
import com.dream.shopping.facade.vo.AddressVo;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: huiliao
 * Date: 2018/11/20
 * Time: 14:15
 */
@Component
public class AddressServiceImpl implements AddressService {


    @Resource
    private AddressMapper addressMapper;


    @Override
    public List<Address> selectAll(AddressVo addressVo) {
        return addressMapper.selectAll(addressVo);
    }

    @Override
    public Address selectAddressById(Integer id) {
        return addressMapper.selectAddressById(id);
    }

    @Override
    public int insertAddress(Address address) {
        return addressMapper.insertAddress(address);
    }

    @Override
    public int updateAddress(Address address) {
        return addressMapper.updateAddress(address);
    }

    @Override
    public int deleteAddressById(Integer id) {
        return addressMapper.deleteAddressById(id);
    }
}

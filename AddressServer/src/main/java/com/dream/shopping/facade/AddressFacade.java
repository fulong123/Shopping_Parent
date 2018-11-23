package com.dream.shopping.facade;

import com.alibaba.dubbo.config.annotation.Service;
import com.dream.shopping.facade.IServiceFacade.IAddressFacade;
import com.dream.shopping.facade.po.Address;
import com.dream.shopping.addressserver.service.AddressService;
import com.dream.shopping.facade.vo.AddressVo;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: huiliao
 * Date: 2018/11/20
 * Time: 14:22
 */

@Service(version = "1.0.0")
@Component
public class AddressFacade implements IAddressFacade {

    @Resource
    private AddressService addressService = null;

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

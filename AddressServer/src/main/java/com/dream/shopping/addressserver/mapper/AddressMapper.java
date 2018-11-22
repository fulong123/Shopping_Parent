package com.dream.shopping.addressserver.mapper;

import com.dream.shopping.facade.po.Address;
import com.dream.shopping.facade.vo.AddressVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 描述:
 * Created with IntelliJ IDEA.
 * User: huiliao
 * Date: 2018/11/20
 * Time: 11:41
 */
@Mapper
public interface AddressMapper{

    /**
     * 描述 通过条件查询地址
     * @author huiliao
     * @date 2018/11/20 11:50
     * @param addressVo
     * @return java.util.List<com.dream.shopping.pojo.po.Address>
     */
    List<Address> selectAll(AddressVo addressVo);

    /**
     * 描述 通过id查询用户
     * @author huiliao
     * @date 2018/11/20 11:55
     * @param id
     * @return com.dream.shopping.pojo.po.Address
     */
    Address selectAddressById(Integer id);

    /**
     * 描述 添加地址
     * @author huiliao
     * @date 2018/11/20 11:58
     * @param address
     * @return int
     */
    int insertAddress(Address address);

    /**
     * 描述 修改地址
     * @author huiliao
     * @date 2018/11/20 11:59
     * @param address
     * @return int
     */
    int updateAddress(Address address);

    /**
     * 描述 通过id删除地址
     * @author huiliao
     * @date 2018/11/20 11:59
     * @param id
     * @return int
     */
    int deleteAddressById(Integer id);
}

package com.dream.shopping.facade;

import com.dream.shopping.facade.addressservice.IAddressFacade;
import com.dream.shopping.facade.po.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FacadeApplicationTests {

    @Resource
    IAddressFacade iAddressFacade;
    @Test
    public void contextLoads() {
    }

    @Test
    public void test1(){
        Address address = iAddressFacade.selectAddressById(22);
        System.out.println(address);
    }
}

package com.dream.shopping.managerweb;


import com.dream.shopping.facade.IServiceFacade.IAddressFacade;
import com.dream.shopping.facade.po.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ManagerwebApplicationTests {

    @Resource
    IAddressFacade iAddressFacade;
    @Test
    public void contextLoads() {
    }

    @Test
    public void test1(){
        Address address = iAddressFacade.selectAddressById(1);
        System.out.println(address);
    }

}

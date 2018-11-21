package com.dream.shopping.addressserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.dream.shopping.addressserver.mapper")
public class AddressserverApplication {


    public static void main(String[] args) {
        SpringApplication.run(AddressserverApplication.class, args);
    }
}

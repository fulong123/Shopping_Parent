package com.dream.shopping.channelservice;

import net.unicon.cas.client.configuration.EnableCasClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCasClient
//@EnableCaching
public class ChannelserviceApplication {

    public static void main(String[] args) {

       SpringApplication.run(ChannelserviceApplication.class, args);
    }
}

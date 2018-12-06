package com.dream.shopping.channelservice;

import net.unicon.cas.client.configuration.EnableCasClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableCasClient
public class ChannelserviceApplication {

    public static void main(String[] args) {

       SpringApplication.run(ChannelserviceApplication.class, args);
    }
}

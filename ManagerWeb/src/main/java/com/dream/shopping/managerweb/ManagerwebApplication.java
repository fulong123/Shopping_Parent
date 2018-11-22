package com.dream.shopping.managerweb;

import com.dream.shopping.managerweb.userService.impl.UserConsumerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ManagerwebApplication {

    public static void main(String[] args) {
//        ConfigurableApplicationContext run =
//                SpringApplication.run(ManagerwebApplication.class, args);
//        UserConsumerService bean = run.getBean(UserConsumerService.class);
//        System.out.println(bean.selectById(36));
        SpringApplication.run(ManagerwebApplication.class,args);
    }
}

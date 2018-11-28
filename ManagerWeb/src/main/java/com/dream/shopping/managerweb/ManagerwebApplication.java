package com.dream.shopping.managerweb;

import com.github.tobato.fastdfs.FdfsClientConfig;
import net.unicon.cas.client.configuration.EnableCasClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;


@Import(FdfsClientConfig.class)
//@EnableCasClient
@SpringBootApplication
public class ManagerwebApplication {
    public static void main(String[] args) {

        SpringApplication.run(ManagerwebApplication.class,args);
    }
}

package com.dream.shopping.shoppinguserservice.config;

import com.github.springtestdbunit.bean.DatabaseConfigBean;
import com.github.springtestdbunit.bean.DatabaseDataSourceConnectionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
/**
 * 描述 redis配置类
 * @author sky
 * @date 2018/11/20 19:01
 * @param
 * @return
 */
@Configuration
public class DBUnitConfig {

    @Bean
    public DatabaseConfigBean dbUnitDatabaseConfig() {

        DatabaseConfigBean bean = new DatabaseConfigBean();
        bean.setAllowEmptyFields(true);
        return bean;
    }

    @Bean
    public DatabaseDataSourceConnectionFactoryBean dbUnitDatabaseConnection(
            DatabaseConfigBean dbUnitDatabaseConfig, DataSource dataSource) {
        DatabaseDataSourceConnectionFactoryBean bean =
                new DatabaseDataSourceConnectionFactoryBean(dataSource);
        bean.setDatabaseConfig(dbUnitDatabaseConfig);
        return bean;
    }
}
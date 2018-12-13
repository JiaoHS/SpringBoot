package com.xjtu.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties(JdbcProperties.class)
public class JdbcConfig {

//    @Value("${jdbc.url}")
//    String url;
//    @Value("${jdbc.driverClassName}")
//    String driverClassName;
//    @Value("${jdbc.username}")
//    String username;
//    @Value("${jdbc.password}")
//    String password;
//    @Autowired
//    private JdbcProperties jdbc;
    @Bean
    public DataSource dataSource(JdbcProperties jdbc){

        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(jdbc.getUrl());
        dataSource.setDriverClassName(jdbc.getDriverClassName());
        dataSource.setUsername(jdbc.getUsername());
        dataSource.setPassword(jdbc.getPassword());
        return dataSource;
    }
}

package com.xjtu.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @auther coraljiao
 * @date 2018/12/27 17:08
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DataSourceTest {
    @Autowired
    DataSource dataSource;
    @Test
    public void contextLoads() throws SQLException {
        System.out.println(dataSource.getClass());

        Connection connection = dataSource.getConnection();
        //默认是HikariProxyConnection@1389810291 wrapping com.mysql.cj.jdbc.ConnectionImpl@4667c4c1
        //2018-12-27 [main] INFO  com.zaxxer.hikari.HikariDataSource - HikariPool-1 - Starting...
        //2018-12-27 [main] WARN  com.zaxxer.hikari.util.DriverDataSource - Registered driver with driverClassName=com.mysql.jdbc.Driver was not found, trying direct instantiation.
        //2018-12-27 [main] INFO  com.zaxxer.hikari.HikariDataSource - HikariPool-1 - Start completed.
        //HikariProxyConnection@1674938191 wrapping com.mysql.cj.jdbc.ConnectionImpl@60c73e58

        //配置alibaba的Druid数据源后
        //2018-12-27 [main] INFO  com.alibaba.druid.pool.DruidDataSource - {dataSource-1} inited
        //com.mysql.cj.jdbc.ConnectionImpl@2c05ff9d
        System.out.println(connection);
        connection.close();
    }
}

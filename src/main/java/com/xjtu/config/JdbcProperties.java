package com.xjtu.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "jdbc")
@Data
public class JdbcProperties {
    String url;
    String driverClassName;
    String username;
    String password;

//    public String getUrl() {
//        return url;
//    }
//
//    public String getDriverClassName() {
//        return driverClassName;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setUrl(String url) {
//        this.url = url;
//    }
//
//    public void setDriverClassName(String driverClassName) {
//        this.driverClassName = driverClassName;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
}

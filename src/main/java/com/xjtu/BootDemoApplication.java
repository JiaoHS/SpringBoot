package com.xjtu;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//声明配置类，开启配置，扫描包
@SpringBootApplication
public class BootDemoApplication {
    public static void main(String[] args){
        SpringApplication.run(BootDemoApplication.class,args);//配置项目启动
    }
}

package com.xjtu;


//import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

//声明配置类，开启配置，扫描包
@SpringBootApplication
@MapperScan("com.xjtu.mapper")  //扫描mapper接口
public class BootDemoApplication {
    public static void main(String[] args){
        SpringApplication.run(BootDemoApplication.class,args);//配置项目启动
    }
}

package com.xjtu.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
@Slf4j
@RestController
public class HelloController {

//    @Autowired
//    private DataSource dataSource;

    @GetMapping("hello.do")
    public String Hello(){
//        System.out.println("Hello is Runing");
        log.debug("Hello is Runing");
        return "Hello Spring Boot!";
    }
}

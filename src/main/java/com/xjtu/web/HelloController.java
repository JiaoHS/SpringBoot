package com.xjtu.web;

import com.xjtu.pojo.User;
import com.xjtu.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.util.List;

//@Slf4j
@RestController
@RequestMapping("user")
public class HelloController {

//    @Autowired
//    private DataSource dataSource;


    @Autowired
    private UserService userService;

    @GetMapping("{id}")
    public User Hello(@PathVariable("id") Long id) {
//        System.out.println("Hello is Runing");
//        log.debug("Hello is Runing");
//        return "Hello Spring Boot!";
        return userService.queryById(id);
    }

    @GetMapping("list")
    public List<User> List() {
//        System.out.println("Hello is Runing");
//        log.debug("Hello is Runing");
//        return "Hello Spring Boot!";
        return userService.queryList();
    }
}

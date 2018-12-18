package com.xjtu.controller;

import com.xjtu.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@Slf4j
@Controller
//@RequestMapping("user")
public class HelloController {

//    @Autowired
//    private DataSource dataSource;
//    @RequestMapping({"/","/index.html"})
//    public String hello(){
//        return "index";
//    }

    //    @Autowired
//    private UserService userService;
//
//    @GetMapping("{id}")
//    public User Hello(@PathVariable("id") Long id) {
////        System.out.println("Hello is Runing");
////        log.debug("Hello is Runing");
////        return "Hello Spring Boot!";
//        return userService.queryById(id);
//    }
//
//    @GetMapping("list")
//    public List<User> List() {
////        System.out.println("Hello is Runing");
////        log.debug("Hello is Runing");
////        return "Hello Spring Boot!";
//        return userService.queryList();
//    }
    @RequestMapping("/hello")
    @ResponseBody
    public String Success(@RequestParam("user") String username) {
        if (username.equals("aaa")) {
            throw new UserNotExistException();
        }
        return "success";
    }
}

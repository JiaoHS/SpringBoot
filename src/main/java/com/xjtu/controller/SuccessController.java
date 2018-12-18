package com.xjtu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Map;

@Controller
public class SuccessController {
    @RequestMapping("/success")
    public String success(Map<String, String> map) {

        map.put("hello", "hello好");
        map.put("hello2", "hello2好");
        map.put("hello3", "hello3好");
        return "success";
    }

    @RequestMapping("/success2")
    public String success2(Map<String, Object> map) {

        map.put("hello","<h1>你好</h1>");
        map.put("list",Arrays.asList("zhagnan","lisi","saf"));
        return "success2";
    }

}


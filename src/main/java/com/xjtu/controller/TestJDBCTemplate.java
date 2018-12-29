package com.xjtu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @auther coraljiao
 * @date 2018/12/27 20:34
 * @description
 */
@Controller
public class TestJDBCTemplate {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @ResponseBody
    @RequestMapping("/query")
    public Map<String,Object> map(){
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from user");

        return maps.get(0);
    }
}

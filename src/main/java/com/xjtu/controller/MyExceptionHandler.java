package com.xjtu.controller;

import com.xjtu.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {
//    @ResponseBody
//    @ExceptionHandler(UserNotExistException.class)
//    public Map<String,Object> handlerException(Exception e){
//        Map<String,Object> map=new HashMap<>();
//        map.put("status","404");
//        map.put("message",e.getMessage());
//        return map;
//    }


    @ExceptionHandler(UserNotExistException.class)
    public String handlerException(Exception e, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        //传入自己的状态码
        request.setAttribute("javax.servlet.error.status_code", 432);
        map.put("code", "user not exist");
        map.put("message", e.getMessage());
        request.setAttribute("ext",map);
        //转发到error
        return "forward:/error";
    }
}

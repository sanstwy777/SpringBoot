package com.atkjs927.springboot.controller;

import com.atkjs927.springboot.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {

    /*
    @RequestMapping({"/","/index.html"})
    public String index() {
        return "index";
    }
    */

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(@RequestParam("user") String user) {
        if(user.equals("aaa")) {
            throw new UserNotExistException();
        }
        return "hello";
    }

    @RequestMapping("/success")
    public String success(Map<String,Object> map) {
        map.put("hello", "<h1>Hello!!!</h1>");
        map.put("users", Arrays.asList("123", "456", "789"));
        return "success";
    }
}

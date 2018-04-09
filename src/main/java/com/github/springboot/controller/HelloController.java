package com.github.springboot.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by verse on 2018/4/8.
 */
@EnableAutoConfiguration //表示注入spring容器
@RestController //表示该接口全部返回json格式
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        return "hello world!!!";
    }
}

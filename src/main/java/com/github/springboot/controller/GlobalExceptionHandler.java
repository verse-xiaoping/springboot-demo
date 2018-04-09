package com.github.springboot.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局捕获异常,其他地方报错时候回自动访问resultError这个接口
 * Created by verse on 2018/4/9.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Map<String, Object> resultError(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("errorCode","500");
        map.put("errorMsg","系统错误");
        return map;
    }
}

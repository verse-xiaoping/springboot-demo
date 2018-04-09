package com.github.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by verse on 2018/4/9.
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(Map<String, Object> map){
        map.put("name","verse");
        map.put("age","27");
        ArrayList<String> list = new ArrayList<>();
        list.add("三哥");
        list.add("杰哥");
        map.put("userList",list);
        return "index";
    }
}

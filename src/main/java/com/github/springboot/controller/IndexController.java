package com.github.springboot.controller;

import com.github.springboot.test1.service.UserServiceTest1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by verse on 2018/4/9.
 */
@Controller
public class IndexController {

    @Autowired
    UserServiceTest1 userServiceTest1;


    @Value("${verse}")
    private String verse;
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
    @RequestMapping("/sendMsg")
    @ResponseBody
    public void sendMsg(){
        System.out.println("================1===============");
        userServiceTest1.sendSms();
        System.out.println("================2===============");
    }
    @RequestMapping("/getVerse")
    @ResponseBody
    public String getVerse(){
        //读取配置文件的属性
        return verse;
    }
}

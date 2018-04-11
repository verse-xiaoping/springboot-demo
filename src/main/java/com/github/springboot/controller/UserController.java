package com.github.springboot.controller;

import com.github.springboot.entity.User;
import com.github.springboot.service.UserService;
import com.github.springboot.test1.dao.UserMapperTest1;
import com.github.springboot.test1.service.UserServiceTest1;
import com.github.springboot.test2.dao.UserMapperTest2;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xiaoping
 * @date 2018-04-10 16:06
 */
@RestController
public class UserController {

    private static Logger logger = Logger.getLogger(UserController.class);
    @Resource
    UserService userService;
    @Autowired
    UserMapperTest1 userMapperTest1;
    @Autowired
    UserMapperTest2 userMapperTest2;
    @Autowired
    UserServiceTest1 userServiceTest1;

    @RequestMapping("/findByName")
    public User findByName() {
        return userService.findByName("verse");
    }

    @RequestMapping("/findByNameTest1")
    public User findByNameTest1(String name) {
        logger.info("=================" + name);
        return userMapperTest1.findByName(name);
    }

    @RequestMapping("/saveTest1")
    public String saveTest1(String name, Integer age) {
        userMapperTest1.insert(name, age);
        return "success";
    }

    @RequestMapping("/saveTest2")
    public String saveTest2(String name, Integer age) {
        userMapperTest2.insert(name, age);
        return "success";
    }

    @RequestMapping("/saveTest3")
    public String userServiceTest1(String name, Integer age) {
        //测试分布式事务
        userServiceTest1.insertTest1(name, age);
        return "success";
    }
}

package com.github.springboot.service;

import com.github.springboot.entity.User;
import com.github.springboot.mapper.UserMapper;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author xiaoping
 * @date 2018-04-10 16:05
 */
@Service
public class UserService {
    @Resource
    UserMapper userMapper;
    public User findByName(String name){
        return userMapper.findByName(name);
    }

    public  int insert(String name, Integer age){
        return userMapper.insert(name, age);
    }
}

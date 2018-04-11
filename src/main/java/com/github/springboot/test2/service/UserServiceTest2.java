package com.github.springboot.test2.service;

import com.github.springboot.test2.dao.UserMapperTest2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xiaoping
 * @date 2018-04-10 17:11
 */
@Service
public class UserServiceTest2 {
    @Autowired
    UserMapperTest2 userMapperTest2;

    @Transactional
    public String insertTest1(String name, Integer age) {
        userMapperTest2.insert(name, age);
        int i = 1 / 0;
        return "success";
    }
}

package com.github.springboot.test1.service;

import com.github.springboot.test1.dao.UserMapperTest1;
import com.github.springboot.test2.dao.UserMapperTest2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xiaoping
 * @date 2018-04-10 17:10
 */
@Service
public class UserServiceTest1 {
    @Autowired
    UserMapperTest1 userMapperTest1;
    @Autowired
    UserMapperTest2 userMapperTest2;
    @Transactional
    public String insertTest1(String name, Integer age) {
        //如果是分开的事务管理，这里的事务回滚只会作用到test1包下面的方法userMapperTest1.insert，test2包下面的添加依旧会执行
        //如果统一使用Atomikos管理事务，就可以达到多数据源的统一回滚事务
        userMapperTest1.insert(name, age);
        userMapperTest2.insert(name, age);
        int i = 1 / 0;
        return "success";
    }
}

package com.github.springboot.mapper;

import com.github.springboot.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author xiaoping
 * @date 2018-04-10 16:03
 */
public interface UserMapper {
    @Select("Select * from user where name=#{name}")
    User findByName(@Param("name") String name);

    @Insert("insert into user values(null, #{name},#{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);
}

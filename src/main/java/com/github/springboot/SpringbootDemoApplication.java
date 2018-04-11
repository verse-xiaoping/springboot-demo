package com.github.springboot;

import com.github.springboot.datasource.DbConfig1;
import com.github.springboot.datasource.DbConfig2;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@MapperScan(basePackages = {"com.github.springboot.mapper"})
@EnableConfigurationProperties(value = {DbConfig1.class, DbConfig2.class})
public class SpringbootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemoApplication.class, args);
	}
}

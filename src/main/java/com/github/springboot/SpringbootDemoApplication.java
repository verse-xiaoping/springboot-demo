package com.github.springboot;

import com.github.springboot.datasource.DbConfig1;
import com.github.springboot.datasource.DbConfig2;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@MapperScan(basePackages = {"com.github.springboot.mapper"})
@EnableConfigurationProperties(value = {DbConfig1.class, DbConfig2.class})
@EnableScheduling //启用任务调度
@EnableAsync      //启用异步注解
public class SpringbootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemoApplication.class, args);
	}
}

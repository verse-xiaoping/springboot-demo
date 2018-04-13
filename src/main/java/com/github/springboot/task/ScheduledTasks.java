package com.github.springboot.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author xiaoping
 * @date 2018-04-11 17:37
 */

@Component
public class ScheduledTasks {

    @Scheduled(fixedRate = 50000)
    public void test(){
        //执行任务调度的方法(不推荐使用，太过简单，报错的话会重复调用)
        System.out.println("执行任务-----1秒执行一次");
    }
}

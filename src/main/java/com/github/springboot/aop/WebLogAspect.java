package com.github.springboot.aop;

import com.github.springboot.controller.UserController;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @author xiaoping
 * @date 2018-04-11 17:06
 */
@Aspect //定义一个切面
@Component //交给spring管理
public class WebLogAspect {
    private static Logger logger = Logger.getLogger(WebLogAspect.class);

    /**
     * 从com.github.springboot.controller开始拦截执行
     */
    @Pointcut("execution(public * com.github.springboot.controller..*.*(..))")
    public void webLog() {
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        //接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("--------------------------start---------------------------");
        //记录下请求内容
        logger.info("URL:" + request.getRequestURI());
        logger.info("HTTP_METHOD:" + request.getMethod());
        logger.info("IP:" + request.getRemoteAddr());
        Enumeration<String> enumeration = request.getParameterNames();
        while (enumeration.hasMoreElements()) {
            String name = enumeration.nextElement();
            logger.info("name: "+ name);
            logger.info("value:" + request.getParameter(name));
        }
    }
   @AfterReturning(returning = "object", pointcut = "webLog()")
    public void doAfterReturning(Object object) throws Throwable {
        //处理完请求，返回内容
        logger.info("Return:  " + object);
        logger.info("--------------------------end---------------------------");
    }
}

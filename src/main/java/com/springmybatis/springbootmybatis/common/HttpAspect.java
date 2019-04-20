package com.springmybatis.springbootmybatis.common;

import com.springmybatis.springbootmybatis.model.MongoLog;
import com.springmybatis.springbootmybatis.util.MongoDBUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author amc2533064395@163.com
 * @date 2019/4/20 14:07
 */
@Aspect
@Component
public class HttpAspect {
    private final static Logger LOGGER = LoggerFactory.getLogger(HttpAspect.class);


    @Autowired
    private MongoDBUtil mongoDBUtil;


    @Pointcut(value = "execution(public * com.springmybatis.springbootmybatis.controller.UserController.*(..))")
    public void p() {
    }

    @Before("p()")
    public void doBefore(JoinPoint joinPoint) {
        MongoLog mongoLog = new MongoLog();
        LOGGER.info("1");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //URL
        LOGGER.warn("URL={}", request.getRequestURI());


        //Method
        LOGGER.warn("Method={}", request.getMethod());

        //IP
        LOGGER.warn("IP={}", request.getRemoteAddr());

        //Class.Method
        LOGGER.warn("CLass.Method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName() + "()");

        //Args
        LOGGER.warn("Args={}", joinPoint.getArgs());

        //存入mongodb

        mongoLog.setUrl(request.getRequestURI());
        mongoLog.setMethod(request.getMethod());
        mongoLog.setCLassMethod(joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName() + "()");
        mongoLog.setIp(request.getRemoteAddr());
        mongoDBUtil.saveObj(mongoLog);


    }

    @After("p()")
    public void doAfter() {
        LOGGER.info("2");
        LOGGER.warn("HttpAspect doAfter Running : " + new Date());
    }

}

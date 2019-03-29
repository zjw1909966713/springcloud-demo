package com.imooc.product.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;

/**
 * 定义一个切面，统一处理web请求的日志
 */
@Aspect
@Component
public class WebLogAspect {
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(public * com.imooc.product.controller.*.*(..))")
     public void WebLog() {
    }


    @Before("WebLog()")
    public void doBefore(JoinPoint joinPoint){

        logger.info("");
        // 接收到请求，记录请求内容

        logger.info("*********************************************request start:"+ new DateTime().toString("yyyy-MM-dd HH:mm:ss")+"*************************************************************");


        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        HttpServletRequest request = attributes.getRequest();


        // 记录下请求内容

        logger.info("URL : " + request.getRequestURL().toString());

        logger.info("HTTP_METHOD : " + request.getMethod());

        logger.info("IP : " + request.getRemoteAddr());

        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature
                ().getName());

        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));

        //获取所有参数方法一：

        Enumeration<String> enu = request.getParameterNames();

        while (enu.hasMoreElements()) {

            String paraName = enu.nextElement();

           logger.info(paraName + ": " + request.getParameter(paraName));

        }

    }



    @AfterReturning(pointcut = "WebLog()",returning ="retVal" )
    public void doAfterReturning(JoinPoint joinPoint, Object retVal) {
        // 处理完请求，返回内容
        logger.info("RESPONSE :"+ retVal);
        logger.info("*********************************************request end:"+ new DateTime().toString("yyyy-MM-dd HH:mm:ss")+"***************************************************************");

        logger.info("");
    }





}

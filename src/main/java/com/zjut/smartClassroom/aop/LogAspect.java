package com.zjut.smartClassroom.aop;

import com.alibaba.fastjson.JSONArray;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.aspectj.lang.JoinPoint;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect // 使之成为切面类
@Component // 把切面类加入到IOC容器中
public class LogAspect {
     private Logger logger = LoggerFactory.getLogger(LogAspect.class);

    public static enum Level {
        TRACE, DEBUG, INFO, WARN, ERROR
    }

    /**
     * Log at the specified level. If the "logger" is null, nothing is logged.
     * If the "level" is null, nothing is logged. If the "txt" is null,
     * behaviour depends on the SLF4J implementation.
     */

    public static void log(Logger logger, Level level, String txt) {
        if (logger != null && level != null) {
            switch (level) {
                case TRACE:
                    logger.trace(txt);
                    break;
                case DEBUG:
                    logger.debug(txt);
                    break;
                case INFO:
                    logger.info(txt);
                    break;
                case WARN:
                    logger.warn(txt);
                    break;
                case ERROR:
                    logger.error(txt);
                    break;
            }
        }
    }


    @Pointcut("execution(public * com.zjut.smartClassroom.Controller.*.*(..))")
    public void log(){}

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        logger.info("HTTP_METHOD : " + request.getMethod());
//        logger.debug("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
//        logger.debug("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
//        logger.debug("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
//        logger.debug("ARGS : " + Arrays.toString(joinPoint.getArgs()));

//        // 记录下请求内容
//        LogAspect logAspect = new LogAspect();
//        log(logger, Level.INFO, "URL : " + request.getRequestURL().toString());
//        log(logger, Level.INFO, "HTTP_METHOD : " + request.getMethod());
//        log(logger, Level.INFO, "IP : " + request.getRemoteAddr());
//        log(logger, Level.INFO, "CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
//        log(logger, Level.INFO, "ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "ret",pointcut = "log()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 将对象转成json
        Object obj = JSONArray.toJSON(ret);
        String json = obj.toString();
        System.out.println("将Person对象转成json:" + json);
        // 处理完请求，返回内容
        logger.info("RESPONSE : " + json);

//        // 处理完请求，返回内容
//        log(logger, Level.INFO, "RESPONSE : " + ret);
    }
}

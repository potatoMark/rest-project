package com.fujitsu.cn.iot.console.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * Web层日志切面
 *
 * @author 程序猿DD
 * @version 1.0.0
 * @date 16/5/17 上午10:42.
 * @blog http://blog.didispace.com
 */
@Aspect
@Order(9)
@Component
public class WebLogAspect {


    private static final Logger LOG = LoggerFactory.getLogger(ExceptionAdvice.class);

    ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("execution(public * com.fujitsu.cn.iot.console.controller..*.*(..))")
    public void webLog(){}

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        startTime.set(System.currentTimeMillis());

        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        LOG.info("URL : " + request.getRequestURL().toString());
        LOG.info("HTTP_METHOD : " + request.getMethod());
        LOG.info("X-Auth-Token : "+request.getHeader("X-Auth-Token"));
        LOG.info("IP : " + request.getRemoteAddr());
        LOG.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        LOG.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));

    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        LOG.info("RESPONSE : " + ret);
        LOG.info("SPEND TIME : " + (System.currentTimeMillis() - startTime.get()));
    }

    @Around(value="execution(public * com.fujitsu.cn.iot.console.controller..*.*(..))")
    private Object aroundLayer(ProceedingJoinPoint pjp) throws Throwable{
        Object retVal = null;

        if (!pjp.getSignature().getName().equals("login")) {
            retVal = pjp.proceed();
        }

        return retVal;

    }


}


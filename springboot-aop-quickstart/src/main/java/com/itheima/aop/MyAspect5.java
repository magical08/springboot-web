package com.itheima.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * ClassName:MyAspect2
 * Package:com.itheima.aop
 * Description:
 *
 * @Author zhuzhu
 * @Create 2024/4/12 16:54
 * @Version 1.0
 */
@Order(2)
@Slf4j
//@Aspect
@Component
public class MyAspect5 {
    @Before("execution(* com.itheima.service.impl.DeptServiceImpl.*(..))")
    public void before(){

            log.info("before ...5");

    }
    @After("execution(* com.itheima.service.impl.DeptServiceImpl.*(..))")
    public void after(){

        log.info("after ...5");
    }
}

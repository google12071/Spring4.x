package com.learn.spring.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @ClassName WaiterServerAspect
 * @Description:
 * @Author lfq
 * @Date 2020/5/27
 **/
@Aspect
@Slf4j
public class WaiterServerAspect {
    @Before("execution(* greetTo(..))")
    public void beforeGreeting() {
        log.info("welcome");
    }

    @After("execution(* ser*(..))")
    public void afterServer() {
        log.info("enjoy yourself");
    }
}

package com.learn.spring.aop.aspect.impl;

import com.learn.spring.aop.aspect.Waiter;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName NativeWaiter
 * @Description:
 * @Author lfq
 * @Date 2020/5/27
 **/
@Slf4j
public class NativeWaiter implements Waiter {
    @Override
    public void greetTo(String clientName) {
        log.info("NativeWaiter,greet to " + clientName + "...");
    }

    @Override
    public void serveTo(String clientName) {
        log.info("NativeWaiter,serveTo to " + clientName + "...");
    }

    public void smile(String clientName, int times) {
        log.info("NativeWaiter,smile to  " + clientName + times + "times...");
    }
}

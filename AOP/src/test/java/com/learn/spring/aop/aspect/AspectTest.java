package com.learn.spring.aop.aspect;

import com.learn.spring.aop.aspect.impl.NativeWaiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

/**
 * @ClassName AspectTest
 * @Description:
 * @Author lfq
 * @Date 2020/5/27
 **/
@Slf4j
public class AspectTest {
    public static void main(String[] args) {
        Waiter waiter = new NativeWaiter();

        AspectJProxyFactory proxyFactory = new AspectJProxyFactory();
        proxyFactory.setTarget(waiter);
        proxyFactory.addAspect(WaiterServerAspect.class);

        Waiter proxy = proxyFactory.getProxy();
        proxy.greetTo("fq");
        proxy.serveTo("fq");
    }
}

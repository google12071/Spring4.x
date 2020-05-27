package com.learn.spring.aop.aspect;

import com.learn.spring.aop.aspect.impl.NativeWaiter;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName AspectTest
 * @Description:
 * @Author lfq
 * @Date 2020/5/27
 **/
@Slf4j
public class AspectTest {
    @Test
    public void addAspectManual() {
        Waiter waiter = new NativeWaiter();
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory();
        proxyFactory.setTarget(waiter);
        proxyFactory.addAspect(WaiterServerAspect.class);

        Waiter proxy = proxyFactory.getProxy();
        proxy.greetTo("fq");
        proxy.serveTo("fq");
    }

    @Test
    public void addAspectBySchema() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/aop/aop-beans.xml");
        Waiter waiter = (Waiter) context.getBean("waiter");
        waiter.greetTo("fq");
        waiter.serveTo("fq");
    }
}

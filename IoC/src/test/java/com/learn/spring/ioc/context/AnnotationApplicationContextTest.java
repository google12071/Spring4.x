package com.learn.spring.ioc.context;

import com.learn.spring.ioc.bean.pojo.BeansConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName AnnotationApplicationContext
 * @Description:注解配置
 * @Author lfq
 * @Date 2020/5/17
 **/
@Slf4j
public class AnnotationApplicationContextTest {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeansConfig.class);
        Object object = context.getBean("person");
        if (object != null) {
            log.info("person:{}", object);
        }
    }
}

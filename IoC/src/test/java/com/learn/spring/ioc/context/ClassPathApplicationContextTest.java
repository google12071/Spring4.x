package com.learn.spring.ioc.context;

import com.learn.spring.ioc.bean.pojo.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName ClassPathApplicationContext
 * @Description:
 * @Author lfq
 * @Date 2020/5/17
 **/
@Slf4j
public class ClassPathApplicationContextTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/learn/spring/ioc/bean/beans.xml");
        Student student = (Student) context.getBean("student");
        log.info("student:{}", student);
    }
}

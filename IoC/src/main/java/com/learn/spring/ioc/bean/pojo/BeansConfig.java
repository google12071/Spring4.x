package com.learn.spring.ioc.bean.pojo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName Student
 * @Description:基于注解方式装配Bean
 * @Author lfq
 * @Date 2020/5/17
 **/
@Configuration
public class BeansConfig {
    @Bean(name = "person", initMethod = "init", destroyMethod = "destroy")
    public Person getPerson() {
        Person person = new Person();
        person.setName("张三");
        person.setAddress("浙江省杭州市");
        person.setAge(23);
        return person;
    }
}

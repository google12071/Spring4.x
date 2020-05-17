package com.learn.spring.ioc.bean.pojo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName Person
 * @Description:
 * @Author lfq
 * @Date 2020/5/17
 **/
@Slf4j
@Data
public class Person {
    private String name;
    private Integer age;
    private String address;

    public Person() {
    }

    public Person(String name, Integer age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public void init() {
        log.info("调用Person初始化方法");
    }

    public void destroy() {
        log.info("调用Person的销毁方法");
    }
}

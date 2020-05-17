package com.learn.spring.ioc.bean.beanfactory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @ClassName MyBeanFactoryPostProcessor
 * @Description:使用工厂后处理器对Bean进行调整
 * @Author lfq
 * @Date 2020/5/17
 **/
@Slf4j
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        //ApplicationContext启动后，首先为配置文件中每个Bean生成一个BeanDefinition对象，BeanDefinition是Bean在Spring
        //容器内部表示
        BeanDefinition bd = beanFactory.getBeanDefinition("student");
        bd.getPropertyValues().addPropertyValue("rank", "5");
        log.info("StudentBeanFactoryPostProcessor.postProcessBeanFactory()！");
    }
}

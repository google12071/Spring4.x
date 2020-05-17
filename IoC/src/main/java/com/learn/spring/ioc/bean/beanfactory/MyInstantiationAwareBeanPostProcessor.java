package com.learn.spring.ioc.bean.beanfactory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

import java.beans.PropertyDescriptor;

/**
 * @ClassName MyInstantiationAwareBeanPostProcessor
 * @Description:
 * @Author lfq
 * @Date 2020/5/17
 **/
@Slf4j
public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {
    @Override
    public Object postProcessBeforeInstantiation(Class beanClass, String beanName) throws BeansException {
        if ("car".equals(beanName)) {
            log.info("CarInstantiationAwareBeanPostProcessor.postProcessBeforeInstantiation");
        }
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if("car".equals(beanName)){
            log.info("CarInstantiationAwareBeanPostProcessor.postProcessAfterInstantiation");
        }
        return true;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds,
                                                    Object bean, String beanName) throws BeansException {
        if ("car".equals(beanName)) {
            log.info("CarInstantiationAwareBeanPostProcessor.postProcessPropertyValues");
        }
        return pvs;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}

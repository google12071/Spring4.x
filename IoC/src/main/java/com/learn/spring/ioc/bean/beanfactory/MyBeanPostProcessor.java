package com.learn.spring.ioc.bean.beanfactory;

import com.learn.spring.ioc.bean.pojo.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @ClassName MyBeanPostProcessor
 * @Description:BeanPostProcessor属于容器级别控制
 * @Author lfq
 * @Date 2020/5/17
 **/
@Slf4j
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("car".equals(beanName)) {
            Car car = (Car) bean;
            if (car.getColor() == null) {
                log.info("调用CarBeanPostProcessor.postProcessBeforeInitialization()，若color为空，设置为默认黑色。");
                car.setColor("黑色");
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if ("car".equals(beanName)) {
            Car car = (Car) bean;
            if (car.getMaxSpeed() >= 200) {
                log.info("调用CarBeanPostProcessor.postProcessAfterInitialization()，将maxSpeed调整为200。");
                car.setMaxSpeed(200);
            }
        }
        return bean;
    }
}

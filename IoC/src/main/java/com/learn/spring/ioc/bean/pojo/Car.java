package com.learn.spring.ioc.bean.pojo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * @ClassName Car
 * @Description: Bean生命周期
 * @Author lfq
 * @Date 2020/5/17
 **/
@Slf4j
public class Car implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {
    private String brand;
    private String color;
    private Integer maxSpeed;
    private String name;
    private BeanFactory beanFactory;
    private String beanName;

    public Car() {
        log.info("调用Car无参构造函数");
    }

    public Car(String brand, String color, Integer maxSpeed, String name) {
        this.brand = brand;
        this.color = color;
        this.maxSpeed = maxSpeed;
        this.name = name;
        log.info("调用Car有参构造函数");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
        log.info("调用BeanFactoryAware.setBeanFactory()");
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
        log.info("调用BeanNameAware.setBeanName()");
    }

    @Override
    public void destroy() throws Exception {
        log.info("调用DisposableBean.destroy()");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("调用InitializingBean.afterPropertiesSet()");
    }

    public void carInit() {
        this.maxSpeed = 240;
        log.info("调用carInit()，将maxSpeed设置为240");
    }

    public void carDestroy() {
        log.info("调用carDestroy()");
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
        log.info("调用setBrand()设置属性");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
        log.info("调用setColor()设置属性");
    }

    public Integer getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(Integer maxSpeed) {
        this.maxSpeed = maxSpeed;
        log.info("调用setMaxSpeed()设置属性");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        log.info("setName()设置属性");
    }

    public void introduce() {
        log.info("introduce:" + this.toString());
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Car{");
        sb.append("brand='").append(brand).append('\'');
        sb.append(", color='").append(color).append('\'');
        sb.append(", maxSpeed=").append(maxSpeed);
        sb.append(", name='").append(name).append('\'');
        sb.append(", beanFactory=").append(beanFactory);
        sb.append(", beanName='").append(beanName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

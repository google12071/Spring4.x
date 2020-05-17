package com.learn.spring.ioc.bean;

import com.learn.spring.ioc.bean.beanfactory.MyBeanPostProcessor;
import com.learn.spring.ioc.bean.beanfactory.MyInstantiationAwareBeanPostProcessor;
import com.learn.spring.ioc.bean.pojo.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @ClassName BeanLifeCycleTest
 * @Description:
 * @Author lfq
 * @Date 2020/5/17
 **/
@Slf4j
public class BeanLifeCycleTest {
    private static void lifeCycleInBeanFactory() {
        //装载配置文件并启动容器
        Resource res = new ClassPathResource("com/learn/spring/ioc/bean/beans.xml");

        DefaultListableBeanFactory bf = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(bf);
        reader.loadBeanDefinitions(res);

        //向容器中注册CarBeanPostProcessor后处理器
        ((ConfigurableBeanFactory) bf).addBeanPostProcessor(new MyBeanPostProcessor());

        //向容器中注册CarInstantiationAwareBeanPostProcessor后处理器
        ((ConfigurableBeanFactory) bf).addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());

        //首次从容器中获取car，将触发容器实例化该Bean，这将引发Bean生命周期方法的调用。
        Car car1 = (Car) bf.getBean("car");
        car1.introduce();
        car1.setColor("红色");

        //第二次从容器中获取car，直接从缓存池中获取
        Car car2 = (Car) bf.getBean("car");

        //查看car1和car2是否指向同一引用
        log.info("car1==car2:" + (car1 == car2));
        //关闭容器
        bf.destroySingletons();
    }

    public static void main(String[] args) {
        lifeCycleInBeanFactory();
    }
}

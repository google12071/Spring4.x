## SpringBean生命周期

 Spring容器管理Bean的过程中,Bean的生命周期会包括创建、初始化、属性复制、销毁等操作,正确理解Bean的生命周期对于开发者至关重要,POJO对象通过实现BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean等接口,可以对Bean的生命周期做定制,满足个性化需求.本文分别对BeanFactory和ApplicationCOntext中Bean的生命周期进行分析,期望进一步加深对Spring容器的理解.

### 一、BeanFactory

- BeanFactory生命周期图解

  ![image-20200517145619140](https://tva1.sinaimg.cn/large/007S8ZIlly1gevgdix71pj314b0u0e82.jpg)

- 核心处理流程

   当调用者通过getBean(beanName)从容器请求某一个Bean时,其生命周期大致会经历以下步骤:

  - 若容器注册了InstantiationAwareBeanPostProcessor接口,则在实例化之前,将调用该接口的postProcessBeforeInstantiation方法
  - 根据配置调用Bean的构造函数或工厂方法实例化Bean
  - 若容器注册了InstantiationAwareBeanPostProcessor接口,则在实例化之后,将调用该接口的postProcessAfterInstantiation方法
  - 若Bean配置了属性值信息,则容器下一步将设置属性值到对应的属性中,在此之前会先调用接口的postProcessPropertyValues方法
  - 调用Bean的属性设置方法(Setter)方法设置属性值
  - 若Bean实现了BeanNameAware接口,则将调用setBeanName方法,将配置文件中Bean对应的的名称设置到Bean中
  - 若Bean实现了BeanFactoryAware接口,则将调用setBeanFactory方法,将BeanFactory容器实例设置到Bean中
  - 若BeanFactory装配了BeanPostProcessor后处理器,则将调用BeanPostProcessor的Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException方法对Bean进行处理,其中入参bean是当前正在处理的bean,beanName是Bean的配置名,返回加工处理后的对象.BeanPostProcessor在Spring中占有重要地位,通过实现该接口,可以对Bean进行改造.
  - 若Bean实现了InitializingBean接口,则将调用afterPropertiesSet方法
  - 通过Bean定义,调用init-method方法,该方法可完成一些初始化工作
  - 若BeanFactory装配了BeanPostProcessor后处理器,则调用postProcessAfterInitialization方法,该方法可再次修改Bean
  - 若Bean定义为单例,则查看Spring缓存池中是否存在准备就绪的Bean,若有直接返回;若无,创建单例模Bean,并放入缓存池,下次获取Bean时,直接返回;若Bean定义为prototype,每次获取Bean都新创建
  - 若Bean中定义destroy方法,则销毁容器后,将完成Bean的销毁或资源释放操作.

- 方法分类

  - Bean自身方法

    构造方法、Setter方法、init-method、destroy-method

  - Bean级生命周期接口方法

    由Bean实现接口实现

  - 容器级生命周期接口方法

    由InstantiationAwareBeanPostProcessor和BeanPostProcessor两个接口实现,一般称它们的实现类为“后处理器”,后处理器接口一般不由Bean本身实现,它的影响为全局性的.开发者通过合理编写后处理器,可对感兴趣的Bean进行加工处理

  - 工厂后处理器接口方法

    工厂后处理器也是容器级的,应用上下文装配配置文件后立即调用

    Bean级生命周期接口和容器级生命周期接口时个性和共性辩证统一的体现,前者解决Bean个性化处理问题,后者解决容器中Bean共性处理问题

### 二、ApplicationContext

- ApplicationContext生命周期图图解

  ![image-20200517151828983](https://tva1.sinaimg.cn/large/007S8ZIlly1gevh0ltqqfj311u0u04qr.jpg)

- ApplicationContext与BeanFactory生命周期对比

  BeanFactory需要手动注册后处理器,开发者通过ApplicationContext管理Bean的生命周期.Application会利用Java反射机制自动识别出配置文件中定义的BeanPostProcessor,并自动将它们注册到应用上下文中.后者需要手工注册,ApplicationContext可以自动注册.

### 三、核心接口及实现类

- BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean
- InstantiationAwareBeanPostProcessor
- BeanPostProcessor
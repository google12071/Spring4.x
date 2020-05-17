## IoC容器

### 一、基础

- IoC概念

  控制反转,包含两层含义,控制表示Bean创建及管理交由Spring容器统一控制管理;反转表示原先类的创建、初始化、赋值等操作从调用类中剥离,转交由Spring容器统一管理,从而实现Bean依赖解耦合.

  > IoC控制反转理解起来相对抽象,软件界泰斗级人物Martin Fowler提出DI(依赖注入)的概念,即调用类对某一接口的实现类的依赖关系由第三方(容器或写作文类)注入,以移除调用类对某一接口实现类的依赖,DI(依赖注入)相对IoC更形象直观.

- IoC类型

  - 构造器注入

    将接口实现类通过构造器函数传入

  - 属性注入

    通过Setter方法完成调用类所需依赖的注入,相对于构造器注入,更加灵活方便.

  - 接口注入(不建议使用)

    将调用类依赖注入的方法抽取到一个接口中,调用类通过实现该接口提供相应的注入方法.此法需要格外新增接口,与构造器注入、属性注入无本质区别,但增加类数量,不建议使用

### 二、BeanFactory

 BeanFacotry是Spring框架的基础设施,面向Spring本身,常用于表示为Spring容器

> BeanFactory启动IoC容器时,并不会初始化配置文件中定义的Bean,初始化完成在首次调用时,对于单利类型,BeanFactory会缓存Bean实例,以后通过getBean()方法获取Bean时,将直接从缓存中获取Bean实例.

### 三、ApplicationContext

ApplicationContext面向Spring框架开发者,提供了国际化支持和框架事件体系,继承自BeanFactory,开发中一般选择ApplicationContext,而非更底层的BeanFactory

- 继承体系

  ![image-20200517141330068](https://tva1.sinaimg.cn/large/007S8ZIlly1gevf505h0qj31xc0cmabd.jpg)

  相对于BeanFactory,ApplicationContext提供了更完善的管理Bean的方法,其主要实现类是ClassPathXmlApplicationContext和FileSystemXmlApplicationContext,前者默认从类路径加载配置文件,后者默认从文件系统中加载配置文件.

> ApplicationContext初始化和BeanFacotry有一个重大区别:BeanFacotry当首次访问某个Bean时,才实例化目标Bean,初始化容器时,并未初始化Bean;ApplicationContext初始化应用上下文时即完成所有单例Bean的初始化,启动初始化时间相对较长,但后续获取Bean无需再次初始化.

- WebApplicationContext

  Spring专门为Web应用设计而生,它允许从相对于Web根目录的路径中装载配置文件并完成初始化工作.
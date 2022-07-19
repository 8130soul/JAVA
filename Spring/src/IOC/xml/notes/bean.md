---
####在spring中，默认bean是单例
1. 设置单例多例（scope）
    - 默认值 singleton
    - prototype 多例
2. 区别
    - singleton在加载xml文件时就创建对象
    - prototype在调用getBean方法时创建对象
    
---
####bean的生命周期
1. 通过构造器（无参构造）创建bean实例
2. 为bean的属性赋值和引入其他的bean
3. 调用bean的初始化方法（需要进行初始化设置）
4. 获取bean的对象
5. 当容器关闭，调用destory方法销毁（需要进行销毁方法的设置）

#### 加上后置处理器  实现该接口BeanPostProcessor
创建处理器类，并在xml文件中配置后置处理器
1. 通过构造器（无参构造）创建bean实例
2. 为bean的属性赋值和引入其他的bean
3. *把bean实例传递给bean的后置处理器的方法* postProcessBeforeInitialization
4. 调用bean的初始化方法（需要进行初始化设置）
5. *把bean实例传递给bean的后置处理器的方法* postProcessAfterInitialization
6. 获取bean的对象
7. 当容器关闭，调用destory方法销毁（需要进行销毁方法的设置）
---
###自动装配（IOC.xml）
spring根据指定的装配原则（属性名称或者属性类型），自动将匹配的属性注入
IOC.xml.autowire:byName | byType





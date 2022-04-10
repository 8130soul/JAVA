String实现了serializable接口：支持序列化
String实现了comparable接口：可以比较大小
String内部定义了final char[] value用户存储字符串数据

String的实例化方法
方式一:通过字面量方式
     该方式赋值都在常量池中，不可变
     重新赋值、连接或者replace方法都是在内存空间中重新创建一个常量，然后再指向这个常量
方式二:new 一个对象

常量与常量拼接，常量池
有对象参与，堆
如果拼接的结果调用intern方法，返回值在常量池

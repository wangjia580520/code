1.自定义注解的使用方式

1.1 先自定义注解

1.2 具体使用 ApplicationContextAware

2.使用抽象父类或者接口实现 多路复用的请求接口

3.使用自定义注解LogOut实现日志输出或者校验

请求接口方式
http://127.0.0.1:8762/interface/Impl001
http://127.0.0.1:8762/interface/Impl002
http://127.0.0.1:8762/abstract/ab001
http://127.0.0.1:8762/abstract/ab002

4.添加日志输出
4.1 按照日志级别输出到不同文件中使用log4j2.xml文件，修改application.yml里面的日志路径
    请求url:http://127.0.0.1:8762/log1
           http://127.0.0.1:8762/log2
4.2 自定义输出日志，可以根据业务和代码输出到不同文件中，使用MarkFactory
    修改application.yml中的日志路径
    请求url:  http://127.0.0.1:8762/log3
             http://127.0.0.1:8762/log4

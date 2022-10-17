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
4.3 mysql数据库导出数据和导入数据
导出结构--no-data 有就是只是结构，没有就是数据和结构都有
mysqldump -h127.0.0.1 -uroot -p123456 -P3306 --set-gtid-purged=OFF --default-character-set=utf-8 --hex-blob --routines --triggers --no-data --databases ciyou --tables admin grade > ajia.sql
导入数据库
mysql -h127.0.0.1 -uroot -p123456 -P3306 -v -v -v -e "warnings;source ./ajia.sql;" & > import.log

4.4 zookeeper 在config文件夹中需要配置保存数据的地址和日志的地址

dataDir=D:\\Program Files (x86)\\zookeeper-3.4.12\\data  
dataLogDir=D:\\Program Files (x86)\\zookeeper-3.4.12\\log 

需要注意的是，windows环境下路径标识使用 \\  或者 /

4.5 elasticsearch的聚合+数组数据结合使用
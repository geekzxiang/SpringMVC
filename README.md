#SpringMVC
##Tomcat相关
Mac系统Homebrew路径为：usr/local/Celler/tomcat/version/libexec/bin/	
启动命令：sudo ./startup.sh

#MySQL安装配置
1. MySql成功安装后在终端中输入如下命令：

输入 alias 命令
alias mysql=/usr/local/mysql/bin/mysql

回车，在输入
alias mysqladmin=/usr/local/mysql/bin/mysqladmin

#MySQL语法问题
1. MySQL的不同版本，建表语句有的可以加单引号，有的加单引号会报错
2. MySQL的不同版本，建表语句有的只有一个字段可以为timestamp

#MySQL问题汇总
1. MySql操作时报错：You must SET PASSWORD before executing this statement

非常诡异啊，明明用密码登陆进去了，怎么还提示需要密码。 
参考官方的一个文档，见http://dev.mysql.com/doc/refman/5.6/en/alter-user.html。如下操作后就ok了： 

	mysql> create database mydb; 
	ERROR 1820 (HY000): You must SET PASSWORD before executing this statement 
	mysql> SET PASSWORD = PASSWORD('123456'); 
	Query OK, 0 rows affected (0.03 sec) 

	mysql> show databases; 
	Query OK, 1 row affected (0.00 sec) 

也就是用mysql> SET PASSWORD = PASSWORD('123456');这句话重新设置一次密码！问题解决！

#mac 安装 nginx 环境
1. brew search nginx
2. brew install nginx
3. 启动:sudo nginx
4. 访问localhost:8080,发现已出现nginx的欢迎页面了。  
5. 重新加载配置|重启|停止|退出:nginx -s reload|reopen|stop|quit
6. 测试配置是否有语法错误:nginx -t     
7. ln -s  /usr/local/sbin/nginx /usr/bin/nginx 做个软连接。
  
常用的指令有：     
8. nginx -V 查看版本，以及配置文件地址  
9. nginx -v 查看版本   
10. nginx -c filename 指定配置文件    
11. nginx -h 帮助 
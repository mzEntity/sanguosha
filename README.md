# sanguosha

## 初次设置

打开mysql命令行：

```mysql
create database sanguosha;
create user 'sanguosha_root'@'localhost' identified by 'password';
grant all privileges on sanguosha.* to 'sanguosha_root'@'localhost';
```

打开server项目下java/resources/application.properties，修改spring.web.resources.static-locations为本机data路径

运行springboot项目，访问localhost:8080/hello查看是否存在响应。
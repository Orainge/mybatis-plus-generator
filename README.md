# 1 项目说明

该项目为 Mybatis plus 自动代码生成工具，使用 Maven 管理，可以通过配置，快速生成mapper和xml文件。

## 1.1 数据库驱动说明

目前项目中默认配置了 MySQL 数据库和 Oracle 数据库的连接。

# 2 配置说明

## 2.1 MySQL 配置

- 包：com.orainge.tools.mybatisplus.generator

- 类名：DefaultMysqlGenerator

  ```java
  {
          // 要存放 domain 和 mapper 的包
          packageName = "com.orainge.tools.mybatisplus.generator.mysql";
    
          // 项目文件根文件夹在硬盘上的绝对路径
          projectPath = "/path/to/project";
    
          // Java 代码在项目中的相对路径，默认为 "/src/main/java"
  //        outputDir = "/src/main/java";
    
          // MySQL 数据库的 IP
          host = "127.0.0.1";
    
          // MySQL 数据库的端口
          port = "3306";
    
          // 数据库名称
          database = "database_name";
    
          // 数据库用户名
          username = "username";
    
          // 数据库密码
          password = "password";
    
          // 自定义 JDBC-URL，如果不自定义就使用默认生成的 JDBC-URL
          // 如果使用了自定义的 JDBC-URL，则上面设置的数据库参数无效。
  //        jdbcUrl = "";
    
          // 要创建的数据库表名
          tables = new String[]{
                  "table_name_1",
                  "table_name_2"
          };
      }

## 2.2 Oracle 配置

- 包：com.orainge.tools.mybatisplus.generator

- 类名：DefaultOracleGenerator

  ```java
  {
          // 要存放 domain 和 mapper 的包
          packageName = "com.orainge.tools.mybatisplus.generator.oracle";
    
          // 项目文件根文件夹在硬盘上的绝对路径
          projectPath = "/path/to/project";
    
          // Java 代码在项目中的相对路径，默认为 "/src/main/java"
  //        outputDir = "/src/main/java";
    
          // Oracle 数据库的 IP
          host = "127.0.0.1";
    
          // Oracle 数据库的端口
          port = "3306";
    
          // 数据库名称
          serviceName = "service_name";
    
          // 数据库用户名
          username = "username";
    
          // 数据库密码
          password = "password";
    
          // 自定义 JDBC-URL，如果不自定义就使用默认生成的 JDBC-URL
          // 如果使用了自定义的 JDBC-URL，则上面设置的数据库参数无效。
  //        jdbcUrl = "";
    
          // 要创建的数据库表名
          tables = new String[]{
                  "table_name_1",
                  "table_name_2"
          };
      }
  ```

# 3 运行

## 3.1 MySQL 数据库

- 包：com.orainge.tools.mybatisplus.generator
- 类名：DefaultMySqlGenerator
- 方法：main

## 3.2 Oracle 数据库

- 包：com.orainge.tools.mybatisplus.generator
- 类名：DefaultOracleGenerator
- 方法：main

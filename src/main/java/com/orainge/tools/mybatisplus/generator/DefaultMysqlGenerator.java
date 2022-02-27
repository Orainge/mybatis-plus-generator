package com.orainge.tools.mybatisplus.generator;

import com.orainge.tools.mybatisplus.generator.utils.MysqlGenerator;

public class DefaultMysqlGenerator extends MysqlGenerator {
    {
        packageName = "com.orainge.tools.mybatisplus.generator.mysql";
        projectPath = "/path/to/project";
//        outputDir = "/src/main/java";
        host = "127.0.0.1";
        port = "3306";
        database = "database_name";
        username = "username";
        password = "password";
//        jdbcUrl = ""; // 自定义 jdbcUrl
        tables = new String[]{
                "table_name_1",
                "table_name_2"
        };
    }

    /**
     * 执行创建操作
     */
    public static void main(String[] args) {
        new DefaultMysqlGenerator().generate();
    }
}

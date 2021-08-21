package com.orainge.tools.mybatisplus.generator;

import com.orainge.tools.mybatisplus.generator.init.OracleGenerator;

public class DefaultOracleGenerator extends OracleGenerator {
    {
        packageName = "com.orainge.tools.mybatisplus.generator.oracle";
        projectPath = "/path/to/project";
//        outputDir = "/src/main/java";
        host = "127.0.0.1";
        port = "3306";
        serviceName = "service_name";
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
        new DefaultOracleGenerator().generate();
    }
}

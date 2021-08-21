package com.orainge.tools.mybatisplus.generator.init;

import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;

/**
 * MySQL 数据库代码生成器
 *
 * @author orainge
 */
public class MysqlGenerator extends MybatisPlusGenerator {
    // 包名
    protected String packageName = "com.orainge.tools.mybatisplus.generator";

    // 生成后的实体类所在文件夹
    protected String projectPath = "/path/to/project";

    // 代码生成路径
    protected String outputDir = "/src/main/java";

    // 代码注释中"作者"信息
    protected String author = "";

    // 数据库驱动名称
    protected String driverName = "com.mysql.cj.jdbc.Driver";

    // MySQL IP 地址
    protected String host = "127.0.0.1";

    // MySQL 端口
    protected String port = "3306";

    // 数据库名称
    protected String database = "database_name";

    // 数据库用户名
    protected String username = "username";

    // 数据库密码
    protected String password = "password";

    // 数据库 JDBC 地址
    protected String jdbcUrl = null;

    // 待生成的数据库表
    protected String[] tables = {
            "TABLE_1",
            "TABLE_2"
    };

    public void generate() {
        String jdbcUrlExecute;
        if (jdbcUrl == null || "".equals(jdbcUrl)) {
            jdbcUrlExecute = "jdbc:mysql://" + host + ":" + port + "/" + database
                    + "?useUnicode=true&serverTimezone=GMT&useSSL=false&characterEncoding=utf8";
        } else {
            jdbcUrlExecute = jdbcUrl;
        }
        execute(tables, true, author, projectPath, outputDir, jdbcUrlExecute, driverName, username, password, packageName);
    }

    protected DataSourceConfig buildDataSourceConfig(String jdbcUrl, String driverName, String username, String password) {
        DataSourceConfig dsc = super.buildDataSourceConfig(jdbcUrl, driverName, username, password);
        dsc.setTypeConvert(new MySqlTypeConvert() {
            @Override
            public DbColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
                //将数据库中timestamp转换成date
                if (fieldType.toLowerCase().contains("timestamp")) {
                    return DbColumnType.DATE;
                }
                return (DbColumnType) super.processTypeConvert(globalConfig, fieldType);
            }
        });
        return dsc;
    }
}

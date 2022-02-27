package com.orainge.tools.mybatisplus.generator.utils;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.LikeTable;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Mybatis Plus 代码创建器
 *
 * @author orainge
 */
public abstract class MybatisPlusGenerator {
    private static final Logger logger = LoggerFactory.getLogger(MybatisPlusGenerator.class);

    protected void execute(String[] tables, String tablePrefix,
                           boolean needMapper, String author,
                           String projectPath, String outputDir,
                           String jdbcUrl, String driverName,
                           String username, String password,
                           String packageName) {
        logger.info("创建任务 - 开始");
        for (int i = 1; i <= tables.length; i++) {
            String table = tables[i - 1];

            // 代码生成器
            AutoGenerator mpg = new AutoGenerator();
            mpg.setGlobalConfig(buildGlobalConfig(projectPath, outputDir, author));
            mpg.setDataSource(buildDataSourceConfig(jdbcUrl, driverName, username, password)); // 数据源配置
            mpg.setPackageInfo(buildPackageConfig(packageName)); // 包配置

            // 配置模板
            TemplateConfig templateConfig = new TemplateConfig();
            if (!needMapper) {
                // 不生成mapper xml文件
                templateConfig.setXml(null);
            }
            templateConfig.setService(null);
            templateConfig.setServiceImpl(null);
            templateConfig.setController(null);
            mpg.setTemplate(templateConfig);

            // 策略配置
            mpg.setStrategy(buildStrategyConfig(table, tablePrefix));
            mpg.setTemplateEngine(new FreemarkerTemplateEngine());
            mpg.execute();

            logger.info("[" + i + "/" + tables.length + "] 处理结束: " + table);
        }
        logger.info("创建任务 - 结束");
    }

    /**
     * 全局构造配置类
     */
    protected GlobalConfig buildGlobalConfig(String projectPath, String outputDir, String author) {
        // 全局配置
        GlobalConfig gc = new GlobalConfig();

        gc.setOutputDir(projectPath + outputDir); // 输出路径
        gc.setAuthor(author); // 添加作者
        gc.setOpen(false); // 生成文件不打开
        gc.setFileOverride(false);
        gc.setActiveRecord(true);
        gc.setEnableCache(false); // XML 二级缓存
        gc.setBaseResultMap(true); //生成默认 Result Map
        gc.setBaseColumnList(true); // 生成java mysql字段映射
//        gc.setSwagger2(true); // 实体属性 Swagger2 注解

        // 自定义文件命名
        // %s 会自动填充表实体属性！
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setControllerName("%sController");

        return gc;
    }

    /**
     * 数据库配置信息
     */
    protected DataSourceConfig buildDataSourceConfig(String jdbcUrl, String driverName, String username, String password) {
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(jdbcUrl);
        dsc.setDriverName(driverName);
        dsc.setUsername(username);
        dsc.setPassword(password);
        return dsc;
    }

    /**
     * Java 包设置
     */
    protected PackageConfig buildPackageConfig(String packageName) {
        PackageConfig pc = new PackageConfig();
        pc.setParent(packageName);
        pc.setEntity("domain");
        pc.setXml("mapper");
        pc.setMapper("mapper");
        pc.setController("controller");
        pc.setService("service");
        pc.setServiceImpl("service");
        return pc;
    }

    /**
     * 生成策略配置
     */
    protected StrategyConfig buildStrategyConfig(String table, String tablePrefix) {
        StrategyConfig strategy = new StrategyConfig();
        // 命名规则
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);

        // 默认生成的po类不继承，手动修改继承
//        strategy.setSuperEntityClass("你自己的父类实体,没有就不用设置!");
//        strategy.setSuperControllerClass("你自己的父类控制器,没有就不用设置!");

        strategy.setSuperServiceClass(null); // 自定义 service 父类
        strategy.setSuperServiceImplClass(null); // 自定义 service 实现类父类
        strategy.setRestControllerStyle(true); // 控制层是否使用Rest风格
        strategy.setEntityBuilderModel(true);
        strategy.setEntityLombokModel(false);
        strategy.setEntitySerialVersionUID(true);
        strategy.setEntityTableFieldAnnotationEnable(true);
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setLikeTable(new LikeTable(table));
        strategy.setTablePrefix(tablePrefix);

        return strategy;
    }
}

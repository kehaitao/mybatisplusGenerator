package com.example.demo;



import com.baomidou.mybatisplus.annotation.DbType;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.BeetlTemplateEngine;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {


//
//  //要生成的表，及输出路径
//  static String[] TO_CREATE_TABLES = new String[]{"block", "channel_origin", "channel_target", "order", "tenant", "user", "oauth_user", "oauth_session_key"};
//  static String BASE_OUT_PUT_DIR = "src/main/java";
//  static String XML_OUT_PUT_DIR = "src/main/resources/mapper";
//  static String AUTHOR = "Jelly";
//  //配置数据源
  static String DATA_SOURCE_URL = "jdbc:mysql://127.0.0.1:3306/bh?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=GMT%2B8";
  static String DATA_SOURCE_DRIVER = "com.mysql.jdbc.Driver";
  static String DATA_SOURCE_USER = "root";
  static String DATA_SOURCE_PASSWORD = "root";
//  //生成表的父类
//  static String SUPER_CONTROLLER = "com.qingtengcloud.web.v1.base.BaseController";
// com.bh.mybatis

  public static void main(String[] args) {

    AutoGenerator mpg = new AutoGenerator();

// set freemarker engine   mpg.setTemplateEngine(new FreemarkerTemplateEngine());
// set beetl engine   mpg.setTemplateEngine(new BeetlTemplateEngine());
// set custom engine (reference class is your custom engine class)  mpg.setTemplateEngine(new CustomTemplateEngine());


    // 全局配置
    GlobalConfig gc = new GlobalConfig();
    gc.setAuthor("kht");
    gc.setOutputDir("D:\\bh\\old\\testmybitis");
    gc.setFileOverride(true);// 是否覆盖同名文件，默认是false
    gc.setActiveRecord(true);// 不需要ActiveRecord特性的请改为false
    gc.setEnableCache(false);// XML 二级缓存
    gc.setBaseResultMap(true);// XML ResultMap
    gc.setBaseColumnList(false);// XML columList
    /* 自定义文件命名，注意 %s 会自动填充表实体属性！ */
     gc.setMapperName("%sMapper");
     gc.setXmlName("%sMapper");
     gc.setServiceName("%sService");
     gc.setServiceImplName("%sServiceImpl");
     gc.setControllerName("%sController");
    mpg.setGlobalConfig(gc);

    // 数据源配置
    DataSourceConfig dsc = new DataSourceConfig();
    dsc.setDbType(DbType.MYSQL);

    dsc.setUrl(DATA_SOURCE_URL);
    // dsc.setSchemaName("public");
    dsc.setDriverName(DATA_SOURCE_DRIVER);
    dsc.setUsername(DATA_SOURCE_USER);
    dsc.setPassword(DATA_SOURCE_PASSWORD);
    mpg.setDataSource(dsc);

    // 包配置
    PackageConfig pc = new PackageConfig();
    pc.setParent("com.bh");
//        pc.setModuleName("test");

    // 策略配置
    StrategyConfig strategy = new StrategyConfig();
    strategy.setNaming(NamingStrategy.underline_to_camel); //数据库表名映射策略，下划线转驼峰命名
    strategy.setColumnNaming(NamingStrategy.underline_to_camel); //数据库表字段映射到实体的命名策略，下划线转驼峰命名
    strategy.setInclude(new String[] {
        "t_quick_login"
    });//需要包含的表名，允许正则表达式（与exclude二选一配置）
//        strategy.setExclude(new String[]{"test"}); // 排除生成的表
    strategy.setEntityBuilderModel(true);//是否为构建者模型
    strategy.setEntityLombokModel(true); //是否为lombok模型
//    strategy.setSuperControllerClass(SUPER_CONTROLLER);//自定义继承的Controller类全称，带包名
    strategy.setControllerMappingHyphenStyle(true);// Controller中驼峰转连字符
    strategy.setRestControllerStyle(true); //生成 @RestController 控制器
    strategy.setTablePrefix("t_");//表前缀





    // 自定义实体父类
    // strategy.setSuperEntityClass("com.baomidou.demo.TestEntity");
    // 自定义实体，公共字段
    // strategy.setSuperEntityColumns(new String[] { "test_id", "age" });
    // 自定义 mapper 父类
    // strategy.setSuperMapperClass("com.baomidou.demo.TestMapper");
    // 自定义 service 父类
    // strategy.setSuperServiceClass("com.baomidou.demo.TestService");
    // 自定义 service 实现类父类
    // strategy.setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl");
    // 自定义 controller 父类
    // strategy.setSuperControllerClass("com.baomidou.demo.TestController");
    // 【实体】是否生成字段常量（默认 false）
    // public static final String ID = "test_id";
    // strategy.setEntityColumnConstant(true);
    // 【实体】是否为构建者模型（默认 false）
    // public User setName(String name) {this.name = name; return this;}
    // strategy.setEntityBuilderModel(true);
    mpg.setStrategy(strategy);
    mpg.setPackageInfo(pc);

//        // 调整 xml 生成目录演示
//        focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                return "/develop/code/xml/" + tableInfo.getEntityName() + ".xml";
//            }
//        });
//        cfg.setFileOutConfigList(focList);
//        mpg.setCfg(cfg);

//        // 关闭默认 xml 生成，调整生成 至 根目录
//        TemplateConfig tc = new TemplateConfig();
//        tc.setXml(null);
//        mpg.setTemplate(tc);

    // 自定义模板配置，可以 copy 源码 mybatis-plus/src/main/resources/templates 下面内容修改，
    // 放置自己项目的 src/main/resources/templates 目录下, 默认名称一下可以不配置，也可以自定义模板名称
    // TemplateConfig tc = new TemplateConfig();
    // tc.setController("...");
    // tc.setEntity("...");
    // tc.setMapper("...");
    // tc.setXml("...");
    // tc.setService("...");
    // tc.setServiceImpl("...");
    // 如上任何一个模块如果设置 空 OR Null 将不生成该模块。
    // mpg.setTemplate(tc);

    // 执行生成
    mpg.execute();

    // 打印注入设置【可无】
//        System.err.println(mpg.getCfg().getMap().get("abc"));



  }

}

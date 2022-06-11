import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        //创建代码生成器对象
        AutoGenerator autoGenerator = new AutoGenerator();
        //全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        String oPtah = System.getProperty("user.dir");//获取当前项目路径
        globalConfig.setOutputDir(oPtah+"/src/main/java");//生成文件的输目录
        globalConfig.setOpen(false);//生成完成后不弹出文件框
        globalConfig.setFileOverride(true);//文件覆盖
        globalConfig.setAuthor("Ling");//作者
        globalConfig.setServiceName("%sService");//去除service的I前缀
        globalConfig.setIdType(IdType.ID_WORKER);  //主键策略(主键如果是long类型，则是IdType.ID_WORKER。如果是char类型，则是ID_WORKER_STR)

        globalConfig.setDateType(DateType.ONLY_DATE);//定义生成的实体类中日期类型
        globalConfig.setSwagger2(true);//定义生成的实体类中日期类型
        autoGenerator.setGlobalConfig(globalConfig);

        ///2、数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);   //设置数据库类型
        dsc.setUrl("jdbc:mysql://localhost:3306/test?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8");  //指定数据库
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("20010119");
        autoGenerator.setDataSource(dsc);



        //3、包的配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.ling");
//        pc.setModuleName("mp"); //模块名

        // 子包
        pc.setEntity("entity");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setController("controller");
        autoGenerator.setPackageInfo(pc);

        // 4、策略配置（逆向工程，根据表生成代码）
        StrategyConfig strategy = new StrategyConfig();
        strategy.setInclude("book"); // 设置要映射的表名
        strategy.setNaming(NamingStrategy.underline_to_camel);//数据库表映射到实体的命名策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true); // 自动lombok；
        strategy.setLogicDeleteFieldName("deleted");
        strategy.setTablePrefix("tb_"); //去掉表的前缀 //生成实体时去掉表前缀

        // 自动填充配置
//        TableFill gmtCreate = new TableFill("gmt_create", FieldFill.INSERT);
//        TableFill gmtModified = new TableFill("gmt_modified", FieldFill.INSERT_UPDATE);
//        ArrayList<TableFill> tableFills = new ArrayList<>();
//        tableFills.add(gmtCreate);
//        tableFills.add(gmtModified);
//        strategy.setTableFillList(tableFills);
        // 乐观锁
        strategy.setVersionFieldName("version");strategy.setRestControllerStyle(true);
        strategy.setControllerMappingHyphenStyle(true);
        autoGenerator.setStrategy(strategy);

//        不加这个会报空指针异常
        InjectionConfig injectionConfig = new InjectionConfig() {
            //自定义属性注入:abc
            //在.ftl(或者是.vm)模板中，通过${cfg.abc}获取属性
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                this.setMap(map);
            }
        };
        //自定义配置
        autoGenerator.setCfg(injectionConfig);

        // 执行生成
        autoGenerator.execute();
    }
}

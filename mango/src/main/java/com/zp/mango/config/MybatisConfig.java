package com.zp.mango.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@MapperScan(value = "com.zp.mango.**.dao")//扫描Dao层
public class MybatisConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        //1、创建SqlSessionFaction工厂Bean
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        //2、设置数据源
        sessionFactoryBean.setDataSource(dataSource);
        //3、对应我们的实体类所在的包
        sessionFactoryBean.setTypeAliasesPackage("com.zp.mango.**.model");
        //4、获取mapper.xml文件
        PathMatchingResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        //扫描映射文件
        sessionFactoryBean.setMapperLocations(resourcePatternResolver.getResources("classpath*:**/generator/*.xml"));

        return sessionFactoryBean.getObject();
    }
}

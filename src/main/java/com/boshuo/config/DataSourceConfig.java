//package com.runfkj.config;
//
//import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//
//import com.alibaba.druid.pool.DruidDataSource;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class DataSourceConfig {
//
//    static final String MAPPER_LOCATION = "classpath*:mapper/**/*.xml";
//
//    static final String ENTITY_PACKAGES = "com.runfkj.dao.**.*";
//
//    @Bean(name = "mysqlDataSource")
//    @ConfigurationProperties(prefix = "mysql.datasource")
//    public DataSource dataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "sqlServerDataSource")
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DataSource firstDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//
//
//}

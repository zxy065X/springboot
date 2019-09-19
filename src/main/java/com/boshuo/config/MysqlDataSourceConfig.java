package com.boshuo.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * mysql连接配置
 */
@Configuration
public class MysqlDataSourceConfig {

    static final String MAPPER_LOCATION = "classpath*:mapper/**/*.xml";

    static final String ENTITY_PACKAGES = "com.runfkj.dao.**.*";

    @Bean(name = "mysqlDataSource")
    @Qualifier("mysqlDataSource")
    @ConfigurationProperties(prefix = "mysql.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

//    @Bean(name = "first.SqlSessionTemplate")
//    public SqlSessionFactory sqlSessionFactory(@Qualifier("mysqlDataSource") DataSource dataSource)throws Exception {
//        final MybatisSqlSessionFactoryBean sqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
//        sqlSessionFactoryBean.setDataSource(dataSource);
//        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(MAPPER_LOCATION));
//        sqlSessionFactoryBean.setTypeAliasesPackage(ENTITY_PACKAGES);
//        return sqlSessionFactoryBean.getObject();
//    }
//
//    @Bean
//    public PlatformTransactionManager platformTransactionManager (@Qualifier("mysqlDataSource")DataSource dataSource){
//        return new DataSourceTransactionManager(dataSource);
//    }
}

package com.boshuo.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * sqlServer 连接配置
 */
@Configuration
public class SqlServerDataSoureceConfig {

    static final String MAPPER_LOCATION = "classpath*:mapper/**/*.xml";

    static final String ENTITY_PACKAGES = "com.runfkj.dao.**.*";

    @Bean(name = "sqlServerDataSource")
    @Qualifier("sqlServerDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource firstDataSource() {
        return DataSourceBuilder.create().build();
    }

//    @Bean
//    public JdbcTemplate secondDataSource(@Qualifier("sqlServerDataSource") DataSource dataSource) {
//        return new JdbcTemplate(dataSource);
//    }

//    @Bean(name = "second.SqlSessionTemplate")
//    public SqlSessionFactory sqlSessionFactoryBean(@Qualifier("sqlServerDataSource") DataSource dataSource) throws Exception {
//        final MybatisSqlSessionFactoryBean sqlSessionFactoryBean = new MybatisSqlSessionFactoryBean ();
//        sqlSessionFactoryBean.setDataSource(dataSource);
//        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(MAPPER_LOCATION));
//        sqlSessionFactoryBean.setTypeAliasesPackage(ENTITY_PACKAGES);
//        return sqlSessionFactoryBean.getObject();
//    }
//
//    @Bean
//    public PlatformTransactionManager platformTransactionManager(@Qualifier("sqlServerDataSource")DataSource dataSource){
//        return new DataSourceTransactionManager(dataSource);
//    }
}

package com.boshuo.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Component
@Primary
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Autowired
    @Qualifier("mysqlDataSource")
    private DataSource mysqlDateSource;

    @Autowired
    @Qualifier("sqlServerDataSource")
    private DataSource sqlServerDateSource;

    @Override
    protected Object determineCurrentLookupKey() {
        logger.info("数据源是："+DataSourceContextHolder.getDbType());
        return DataSourceContextHolder.getDbType();
    }


    @Override
    public void afterPropertiesSet(){
        Map<Object,Object> map = new HashMap<>();
        map.put("mysqlDataSource",mysqlDateSource);
        map.put("sqlServerDataSource",sqlServerDateSource);
        setTargetDataSources(map);
        setDefaultTargetDataSource(mysqlDateSource);
        super.afterPropertiesSet();
    }
}

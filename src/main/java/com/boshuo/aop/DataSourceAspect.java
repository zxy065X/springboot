package com.boshuo.aop;

import com.boshuo.config.DataSourceContextHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(-1)
public class DataSourceAspect {

    private static Logger logger = LoggerFactory.getLogger(DataSourceAspect.class);

    @Before("execution(* com.boshuo.dao..*.*(..))")
    public void process(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        logger.info("请求接口前缀是："+methodName);
       /* MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        DB db = methodSignature.getMethod().getAnnotation(DB.class);*/
//        if (ObjectUtils.isNotEmpty(db)) {
            if (methodName.startsWith("get")
                    || methodName.startsWith("count")
                    || methodName.startsWith("find")
                    || methodName.startsWith("list")
                    || methodName.startsWith("select")
                    || methodName.startsWith("check")) {
                DataSourceContextHolder.setDbType("mysqlDataSource");
            } else {
                //切换dataSource
                logger.info("切换到sqlserver了");
                DataSourceContextHolder.setDbType("sqlServerDataSource");
            }
        /*}else{
            throw new RuntimeException(methodName + "方法未找到数据源配置!");
        }*/
    }


    @After("execution(*  com.boshuo.dao..*.*(..))")
    public void after() {
        DataSourceContextHolder.clearDbType();
    }
}

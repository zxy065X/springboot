# springboot

用springboot+mybatisplus做的数据处理，从mysql取数据，存到sqlserver中，aop监听请求数据接口名自动切换数据源


代码如下：

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

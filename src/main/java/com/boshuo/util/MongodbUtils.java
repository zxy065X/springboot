package com.boshuo.util;

import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MongodbUtils {

    static String dbName = "www";
    static String collectionNanme = "";

    public static class MongodbHandle{
        public static Mongo mongo =new MongoClient("116.62.152.242",27017);
    }

    private Mongo getmongo(){
        return MongodbHandle.mongo;
    }

    public void test(){

    }

    public static <T> T dbObject2Bean(DBObject dbObject, T bean) throws IllegalAccessException,
            InvocationTargetException, NoSuchMethodException {
        if (bean == null) {
            return null;
        }
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            String varName = field.getName();
            Object object = dbObject.get(varName);
            if (object != null) {
                BeanUtils.setProperty(bean, varName, object);
            }
        }
        return bean;
    }

}

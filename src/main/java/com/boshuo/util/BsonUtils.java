package com.boshuo.util;


import org.bson.Document;

import java.lang.reflect.*;
import java.util.*;

/**
 * bson转object
 */
public class BsonUtils {



    public static Object populate(Object src, Object target) {

        Method[] srcMethods = src.getClass().getMethods();

        Method[] targetMethods = target.getClass().getMethods();

        for (Method m : srcMethods) {

            String srcName = m.getName();

            if (srcName.startsWith("get")) {

                try {

                    Object result = m.invoke(src);

                    for (Method mm : targetMethods) {

                        String targetName = mm.getName();

                        if (targetName.startsWith("set")
                                && targetName.substring(3, targetName.length())

                                .equals(srcName.substring(3, srcName.length()))) {

                            mm.invoke(target, result);

                        }

                    }

                } catch (Exception e) {

                }

            }

        }

        return target;

    }




    public static <T> List<T> toBeans(List<Document> documents, Class<T> clazz){
        List<T> list = new ArrayList<T>();
        for (int i = 0; null != documents && i < documents.size(); i++) {
            list.add(toBean(documents.get(i), clazz));
        }
        return list;
    }


    public static <T> T toBean(Document document, Class<T> clazz) {
        T entity = null;
        try {
            entity = (T) clazz.newInstance();

            Field[] fields = clazz.getDeclaredFields();

            for (Field field : fields) {
                if (Modifier.isStatic(field.getModifiers())) {
                    continue;//静态成员不转换
                }
                field.setAccessible(true);
                Class fieldClazz = field.getType();
                String key = field.getName();

                if ("id".equals(key)) {
                    key = "_id";
                }
                Object value = null;
                try {
                    value = field.get(entity);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Object val = document.get(key);
                if (val == null) {
                    continue;
                }
                if (isPrimitive(fieldClazz) || fieldClazz == String.class) {
                    if (field != null) field.set(entity, val);
                    continue;
                }
                //数组
                if (fieldClazz.isArray()) {
                    String itemClazzName = fieldClazz.getTypeName().substring(0, fieldClazz.getTypeName().length() - 2);

                    Class itemClazz = null;
                    try {
                        itemClazz = Class.forName(itemClazzName);
                    } catch (ClassNotFoundException e) {
                        //此时为基本类型
                        itemClazz = toPrimitiveClass(itemClazzName);
                    }
                    Object array = toArray(document.get(key), itemClazz);
                    if (field != null) field.set(entity, array);
                    continue;
                }
                //列表
                if (List.class.isAssignableFrom(fieldClazz)) {
                    ParameterizedType fc = (ParameterizedType) field.getGenericType();
                    TypeVariable[] types = fieldClazz.getTypeParameters();
                    List list = (List) value;
                    if (value == null) {
                        list = new ArrayList<>();
                        if (field != null) field.set(entity, list);
                    }
                    toList(document.get(key), list, (Class) fc.getActualTypeArguments()[0]);
                    continue;
                }
                //哈希表
                if (Map.class.isAssignableFrom(fieldClazz)) {
                    ParameterizedType fc = (ParameterizedType) field.getGenericType();
                    Map map = (Map) value;
                    if (value == null) {
                        map = new HashMap<>();
                        if (field != null) field.set(entity, map);
                    }
                    toMap(document.get(key), map, (Class) fc.getActualTypeArguments()[0], (Class) fc.getActualTypeArguments()[1]);
                    continue;
                }
                document.put(key, toBean((Document) val, fieldClazz));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return entity;
    }

    @SuppressWarnings("rawtypes")
    private static boolean isPrimitive(Class clazz) {
        if(clazz.isPrimitive()) {
            return true;
        }
        if(Long.class == clazz || Integer.class == clazz || Double.class == clazz || Float.class == clazz || Short.class == clazz || Boolean.class == clazz) {
            return true;
        }
        return false;
    }

    @SuppressWarnings("rawtypes")
    private static Class toPrimitiveClass(String primitiveClazzName) {
        Class itemClazz = null;
        //此时为基本类型
        if("long".equals(primitiveClazzName)) {
            itemClazz = long.class;
        }else if("int".equals(primitiveClazzName)) {
            itemClazz = int.class;
        }else if("short".equals(primitiveClazzName)) {
            itemClazz = short.class;
        }else if("double".equals(primitiveClazzName)) {
            itemClazz = double.class;
        }else if("float".equals(primitiveClazzName)) {
            itemClazz = float.class;
        }else if("boolean".equals(primitiveClazzName)) {
            itemClazz = boolean.class;
        }else {
            throw new RuntimeException("nonsupport type !!!");
        }
        return itemClazz;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private static Object toArray(Object value, Class itemClazz) {
        List list = (List)value;

        Object array = Array.newInstance(itemClazz, list.size());
        int i = 0;
        for (Object object : list) {
            if(object instanceof Document) {
                Array.set(array, i++, toBean((Document)object,itemClazz));
            }else {
                Array.set(array, i++, object);
            }
        }
        return array;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    private static void toList(Object value , List list,Class itemClazz) throws InstantiationException, IllegalAccessException {
        if(value.getClass() == Document[].class) {
            Document[] documents = (Document[])value;
            for (Document document : documents) {
                list.add(toBean(document, itemClazz));
            }
        }else {
            List vals = (List)value;
            for (Object object : vals) {
                list.add(object);
            }
        }
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private static void toMap(Object value , Map map,Class keyClazz,Class itemClazz) throws InstantiationException, IllegalAccessException {
        Set<Map.Entry> entries = ((Map) value).entrySet();
        for (Map.Entry entry : entries) {
            Object keyV = entry.getKey().getClass() == String.class ? entry.getKey() : toPrimitive(entry.getKey().toString(), keyClazz);
            Object itemV = entry.getValue();
            if (itemV instanceof Document) {
                map.put(keyV, toBean((Document) itemV, itemClazz));
            } else {
                map.put(keyV, itemV);
            }
        }
    }

    @SuppressWarnings("rawtypes")
    private static Object toPrimitive(String value,Class clazz) {
        if(int.class == clazz || Integer.class == clazz) {
            return Integer.valueOf(value);
        }else if(long.class == clazz || Long.class == clazz) {
            return Long.valueOf(value);
        }else if(short.class == clazz || Short.class == clazz) {
            return Short.valueOf(value);
        }else if(double.class == clazz || Double.class == clazz) {
            return Double.valueOf(value);
        }else if(float.class == clazz || Float.class == clazz) {
            return Float.valueOf(value);
        }else if(boolean.class == clazz || Boolean.class == clazz) {
            return Boolean.valueOf(value);
        }else {
            throw new RuntimeException("Map key nonsupport !!!");
        }
    }
}

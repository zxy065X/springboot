package com.boshuo.util;

import java.util.ArrayList;
import java.util.List;

public class StringUitl {

    public static boolean isEmpty(String cs) {
        return cs == null || cs.length() == 0;
    }


    public static String list2String(List<?> list, String splitStr) {
        if (null == list || list.size() == 0) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        for (Object obj : list) {
            if (sb.length() == 0) {
                sb.append(obj);
            } else {
                sb.append(splitStr);
                sb.append(obj);
            }
        }
        return sb.toString();
    }


    public static List<?> string2List(String arg, String splitStr) {
        if (isEmpty(arg)) {
            return null;
        }
        String[] argArr = arg.split(splitStr);
        List<Object> list = new ArrayList<>();
        for (String string : argArr) {
            list.add(string);
        }
        return list;
    }


    public static String list2String(List<?> list) {
        return list2String(list, ",");
    }

    public static List<?> string2List(String arg) {
        return string2List(arg, ",");
    }


    public static String filterEmoji(String source) {
        if (source != null && source.length() > 0) {
            return source.replaceAll("[\ud800\udc00-\udbff\udfff\ud800-\udfff]", "");
        } else {
            return source;
        }
    }

}

package com.boshuo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ParamCheckUtil {
	
	static ScriptEngine jse = new ScriptEngineManager().getEngineByName("JavaScript");  

	public static boolean isMate(String arg, String regulation){
		if(arg==null||arg.length()==0){
			return false;
		}
		String myParam=arg;
		Pattern p = Pattern.compile(regulation);  
		Matcher m = p.matcher(myParam);  
		return m.matches();  
		
	}
	
	public static boolean isMobile(String mobile){
		String regulation="^(((13[0-9])|(14[579])|(15([0-3]|[5-9]))|(16[6])|(17[0135678])|(18[0-9])|(19[89]))\\d{8})$";
		return isMate(mobile, regulation);  
		
	}
	
	public static boolean  isPinteger(String arg){
		return isMate(arg, "\\d+");  
	}
	
	public static boolean isEmall(String emall){
		String regulation="^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		return isMate(emall, regulation);  
	}
	
	/**
	 * 验证时间类型
	 * @param dateStr 传入的时间字符串
	 * @param regulation 时间正则
	 * @return
	 */
	public static boolean isFormatDate(String dateStr, String regulation){
		if(dateStr==null||dateStr.length()==0){
			return false;
		}
		String myParam=dateStr;
		SimpleDateFormat sdf=new SimpleDateFormat(regulation);
		try {
			sdf.parse(myParam);
			return true;
		} catch (ParseException e) {
			return false;
		}
		
	}
	
	/**
	 * 
	 * @param dateStr
	 * @param regulation
	 * @return
	 */
	public static boolean isInclude(String param, String regulation){
		try {
			String[] include=regulation.split(",");
			for (String string : include) {
				if(param.equals(string)){
					return true;
				}
			}
			return false;
		} catch (RuntimeException e) {
			return false;
		}
		
	}
	
	
	public static boolean isRange(String param, String regulation){
		try {
			regulation=regulation.replaceAll("value", param);
			return (boolean) jse.eval(regulation);
		} catch (ScriptException e) {
			return false;
		}
		
	}

}

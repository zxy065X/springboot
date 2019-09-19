package com.boshuo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 定义用户登录注解
 * 用于对需要登录才能访问的接口进行拦截
 * 并解析userId作为参数传入
 * @author pl
 *
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Login {

	/**
	 * 是否必须登录
	 */
	boolean required() default true;
	
	/**
	 * 允许什么角色访问
	 */
	String  role() default "";
	
	/**
	 * 是否使用userId
	 */
	boolean isUse() default true;
	
	/**
	 * 如果使用，接收id的参数的名
	 */
	String value() default "userId";  
	
	/**
	 * 使用第几个参数接收
	 */
	int paramIndex() default 0; 
	
	/**
	 * 指明从什么中获取参数类型
	 */
	Type getType() default Type.HEADTOKEN;
	
	public static enum Type{
		PARAMID,//userid通过参数直传
		COOKIE, //生成token放到cookie中
		HEADTOKEN;//生成token放在请求头
	}
}

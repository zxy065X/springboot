package com.boshuo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 接口参数校验（只支持用String类型接收的参数）
 * @author pl
 *
 */
@Target({ElementType.PARAMETER,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Param {
	
	/**
	 * 是否必须
	 * @return
	 */
	boolean required() default true ;
    /**
     * 特殊参数可以自定义正则
     * （比如时间）
     * @return
     */
    String regulation() default "";
    
    /**
     * 参数类型
     * @return
     */
    ParamType type() default ParamType.PLAIN;
    
    /**
     * warn
     */
    
    String warn() default "";
    /**
     * 参数类型
     * @author pl
     *
     */
    public static enum ParamType{
    	
    	/**
    	 * 普通类型
    	 */
    	PLAIN(""),
    	
    	/**
    	 * 特定的取值如（"-1,2,3"）
    	 */
    	QUALIFIER(""),
    	
		/**
		 * 手机号
		 */
    	MOBILE("^(((13[0-9])|(14[579])|(15([0-3]|[5-9]))|(16[6])|(17[0135678])|(18[0-9])|(19[89]))\\d{8})$"),
    	/**
    	 * 正整数
    	 */
    	PINTEGER(""),
    	/**
    	 * 时间
    	 * 默认yyyy-MM-dd，
    	 * regulation可以支持自定义
    	 */
		DATE("yyyy-MM-dd"),
    	
		/**
		 * 邮箱
		 */
    	EMALL("^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$"),
    	
    	/**
    	 * 范围(仅支持数字类型)
    	 * 正则就是一个java运算符(值必须写value)
    	 * 一般来说设计到范围取值是业务逻辑，不建议使用魔法值
    	 * value<=78||value>=69.6
    	 */
    	RANGE("");
        
    	
    	private final String value;
 		
 		public String value() {
 		     return value;
 		}
 		ParamType(String value) {
         	 this.value = value;
        }
    	
	}
    
    
}

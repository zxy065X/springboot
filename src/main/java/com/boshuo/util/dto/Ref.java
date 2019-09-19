package com.boshuo.util.dto;

/**
 * Created by superbone on 2017/4/21.
 * 返回值工具类
 */
public class Ref {

    /**请求成功,无返回值*/
    public static CommonResult<Void> ok(){
        CommonResult result = new CommonResult();
        result.setCode(0);
        result.setData(null);
        result.setMsg("成功");
        return result;
    }

    /**请求成功,无返回值*/
    public static CommonResult<Void> success(){
        CommonResult result = new CommonResult();
        result.setCode(0);
        result.setData(null);
        return result;
    }

    /**请求成功,有返回值T*/
    public static <T> CommonResult<T> ok(T t){
        CommonResult result = new CommonResult();
        result.setCode(0);
        result.setData(t);
        result.setMsg("成功");
        return result;
    }

    /**请求成功,有返回值T和成功提示*/
    public static  CommonResult<Void> okMsg(String msg){
        CommonResult result = new CommonResult();
        result.setCode(0);
        result.setData(null);
        result.setMsg(msg);
        return result;
    }

    /**请求成功,有返回值T和成功提示*/
    public static <T> CommonResult<T> okMsg(T t,String msg){
        CommonResult result = new CommonResult();
        result.setCode(0);
        result.setData(t);
        result.setMsg(msg);
        return result;
    }

    /**请求失败,业务逻辑错误*/
    public static <T> CommonResult<T> error(){
    	CommonResult result = new CommonResult();
    	result.setCode(3);
    	result.setData(null);
    	result.setMsg("系统错误，请联系管理员");
    	return result;
    }
    /**请求失败,业务逻辑错误*/
    public static <T> CommonResult<T> error(String errMsg){
        CommonResult result = new CommonResult();
        result.setCode(3);
        result.setData(null);
        result.setMsg(errMsg);
        return result;
    }
    /**请求失败,业务逻辑错误*/
    public static <T> CommonResult<T> error(int code,String errMsg){
    	CommonResult result = new CommonResult();
    	result.setCode(code);
    	result.setData(null);
    	result.setMsg(errMsg);
    	return result;
    }

    /**请求失败,token错误*/
    public static <T> CommonResult<T> tokenError(String msg){
        CommonResult result = new CommonResult();
        result.setCode(1);
        result.setData(null);
        result.setMsg(msg);
        return result;
    }

    /**请求失败,参数校验错误*/
    public static <T> CommonResult<T> paramError(String msg){
        CommonResult result = new CommonResult();
        result.setCode(2);
        result.setData(null);
        result.setMsg(msg);
        return result;
    }

    /**请求失败,请求超时错误*/
    public static <T> CommonResult<T> timeOutError(){
        CommonResult result = new CommonResult();
        result.setCode(4);
        result.setData(null);
        result.setMsg("请求超时");
        return result;
    }



    /**请求失败,服务器异常*/
    public static <T> CommonResult<T> serverError(String errMsg){
        CommonResult result = new CommonResult();
        result.setCode(5);
        result.setData(null);
        result.setMsg(errMsg);
        return result;
    }

    /**请求失败,没有对应的权限*/
    public static <T> CommonResult<T> noAuthError(){
        CommonResult result = new CommonResult();
        result.setCode(6);
        result.setData(null);
        result.setMsg("没有该操作的权限");
        return result;
    }

    /**在其他地方登陆*/
    public static <T> CommonResult<T> otherLogin(){
        CommonResult result = new CommonResult();
        result.setCode(7);
        result.setData(null);
        result.setMsg("该用户在其他地方登录了");
        return result;
    }

    /**用户被禁用*/
    public static <T> CommonResult<T> disableMember(){
        CommonResult result = new CommonResult();
        result.setCode(8);
        result.setData(null);
        result.setMsg("该用户被禁用");
        return result;
    }

}

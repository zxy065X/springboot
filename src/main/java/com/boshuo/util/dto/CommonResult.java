package com.boshuo.util.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class CommonResult<T> implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -383514593485525363L;
	/**
     * 0:   成功
     * 1:   token无效
     * 2:   参数校验错误
     * 3:   业务逻辑错误
     * 4:   请求超时(预留,可用于异步限时请求或者熔断处理等.初期暂不实现)
     * 5:   服务器异常
     * 6:   没有权限
     * 7:   用户异地登录
     * 8:   用户被禁用
     */
    private Integer code;
    private String msg;
    private T data;

}
package com.boshuo.entity.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author zhangxy
 * @email 18086665761@163.com
 * @date 2019-09-10 17:56:20
 */
@Data
@TableName("account_info")
public class AccountInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String id;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 职位
	 */
	private String position;
	/**
	 * 电话
	 */
	private String phone;
	/**
	 * 鐧婚檰鍚?
	 */
	private String loginname;
	/**
	 * 简介
	 */
	private String info;
	/**
	 * 
	 */
	private Integer level;
	/**
	 * 鍥惧儚
	 */
	private String headimg;
	/**
	 * 
	 */
	private Date createtime;

}

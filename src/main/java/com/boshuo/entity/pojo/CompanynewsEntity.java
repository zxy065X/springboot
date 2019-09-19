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
 * @date 2019-09-11 10:07:27
 */
@Data
@TableName("companynews")
public class CompanynewsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String id;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 简介
	 */
	private String introduction;
	/**
	 * 地址
	 */
	private String address;
	/**
	 * 规模
	 */
	private Integer scope;
	/**
	 * 
	 */
	private Integer status;
	/**
	 * 绠€绉?
	 */
	private String subtitle;
	/**
	 * 寮€濮嬫椂闂?
	 */
	private Date starttime;
	/**
	 * 缁撴潫鏃堕棿
	 */
	private Date endtime;
	/**
	 * 鏂瑰紡  1 涓撳満  2 缁煎悎  3 鍚堜綔
	 */
	private String kind;
	/**
	 * 
	 */
	private Date createtime;
	/**
	 * 
	 */
	private Date updatetime;
	/**
	 * 
	 */
	private Integer deleteflag;

}

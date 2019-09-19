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
 * @date 2019-09-11 08:48:55
 */
@Data
@TableName("offer_jobs")
public class OfferJobsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String id;
	/**
	 * 浼佷笟id
	 */
	private String comid;
	/**
	 * 鑱屼綅鍚嶇О
	 */
	private String name;
	/**
	 * 浠锋牸
	 */
	private String price;
	/**
	 * 鑱屼綅浠嬬粛
	 */
	private String description;
	/**
	 * 闇€姹傞噺
	 */
	private Integer postioncount;
	/**
	 * 
	 */
	private Integer companycount;
	/**
	 * 
	 */
	private Integer deliverycount;
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
	private Date time;

}

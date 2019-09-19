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
 * @date 2019-09-10 18:39:10
 */
@Data
@TableName("companies")
public class CompaniesEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String id;
	/**
	 * 浼佷笟鍚嶇О
	 */
	private String comname;
	/**
	 * 浼佷笟閭
	 */
	private String comemail;
	/**
	 * 浼佷笟鍦板潃
	 */
	private String comaddress;
	/**
	 * 鑱旂郴浜?
	 */
	private String comcontact;
	/**
	 * 鑱旂郴鏂瑰紡
	 */
	private String comphone;
	/**
	 * 浼佷笟绠€浠?
	 */
	private String comintroduction;
	/**
	 * 浼佷笟缃戠珯
	 */
	private String comwebsite;
	/**
	 * 
	 */
	private String sourcetype;
	/**
	 * 
	 */
	private Integer positioncount;
	/**
	 * 鎷涜仒鑱屼綅
	 */
	private String compositions;
	/**
	 * 婵″倹鐏夐弰顖炴敘閸烆喕姹夐崨姗€鍊嬬拠椋庢畱鐏忚鲸婀佹潻娆庨嚋id
	 */
	private String accountid;
	/**
	 * 浼佷笟logo
	 */
	private String comlogo;
	/**
	 * 浼佷笟banner鍥?
	 */
	private String comimg;
	/**
	 * 
	 */
	private Date updatetime;
	/**
	 * 鑱屼綅id
	 */
	private Date createtime;
	/**
	 * 
	 */
	private Date tiem;
	/**
	 * 
	 */
	private Integer deleteflag;

}

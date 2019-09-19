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
@TableName("suggests")
public class SuggestsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String id;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private String offerjob;
	/**
	 * 
	 */
	private Integer status;
	/**
	 * 
	 */
	private Date date;
	/**
	 * 
	 */
	private Date time;

}

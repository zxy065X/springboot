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
 * @date 2019-09-10 10:35:52
 */
@Data
@TableName("signs")
public class SignsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String _id;
	/**
	 * 
	 */
	private String openid;
	/**
	 * 
	 */
	private String newid;
	/**
	 * 
	 */
	private Date time;


}

package com.boshuo.entity.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 工作经历
 * 
 * @author zhangxy
 * @email 18086665761@163.com
 * @date 2019-09-11 17:59:03
 */
@Data
@TableName("qz_gzjl")
public class QzGzjlEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String id;
	/**
	 * 关联求职者id
	 */
	private String userid;
	/**
	 * 公司名称
	 */
	private String company;
	/**
	 * 职位
	 */
	private String job;
	/**
	 * 工作职责
	 */
	private String description;
	/**
	 * 寮€濮嬫椂闂?
	 */
	private Date begin;
	/**
	 * 缁撴潫鏃堕棿
	 */
	private Date end;
	/**
	 * 0
	 */
	private Integer deleteflag;

}

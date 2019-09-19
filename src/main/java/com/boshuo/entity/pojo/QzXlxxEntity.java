package com.boshuo.entity.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 学历信息
 * 
 * @author zhangxy
 * @email 18086665761@163.com
 * @date 2019-09-11 17:23:04
 */
@Data
@TableName("qz_xlxx")
public class QzXlxxEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 学校
	 */
	@TableId
	private String id;
	/**
	 * 关联求职者id
	 */
	private String userid;
	/**
	 * 学校
	 */
	private String school;
	/**
	 * 专业
	 */
	private String major;
	/**
	 * 学历
	 */
	private String level;
	/**
	 * 毕业时间
	 */
	private Date end;
	/**
	 * 0
	 */
	private Integer deleteflag;

}

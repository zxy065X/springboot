package com.boshuo.entity.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import lombok.Data;

/**
 * ${comments}
 * 
 * @author zhangxy
 * @email 18086665761@163.com
 * @date 2019-09-18 11:56:22
 */
@Data
@TableName("bst_Person_Educate")
public class BstPersonEducateEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * $column.comments
	 */
	@TableId
	private Integer mid;
	/**
	 * $column.comments
	 */
	private Integer perid;
	/**
	 * $column.comments
	 */
	private String username;
	/**
	 * $column.comments
	 */
	private Integer resid;
	/**
	 * $column.comments
	 */
	private Integer beginyear;
	/**
	 * $column.comments
	 */
	private Integer beginmonth;
	/**
	 * $column.comments
	 */
	private Integer endyear;
	/**
	 * $column.comments
	 */
	private Integer endmonth;
	/**
	 * $column.comments
	 */
	private String schoolname;
	/**
	 * $column.comments
	 */
	private String schoolplace;
	/**
	 * $column.comments
	 */
	private Integer degree;
	/**
	 * $column.comments
	 */
	private String certno;
	/**
	 * $column.comments
	 */
	private Integer specialtytype;
	/**
	 * $column.comments
	 */
	private String specialty;
	/**
	 * $column.comments
	 */
	private String specialtydesc;
	/**
	 * $column.comments
	 */
	private Integer lang;
	/**
	 * $column.comments
	 */
	private Integer state;

}

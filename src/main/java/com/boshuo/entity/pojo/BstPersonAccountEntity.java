package com.boshuo.entity.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * ${comments}
 * 
 * @author zhangxy
 * @email 18086665761@163.com
 * @date 2019-09-18 14:10:22
 */
@Data
@TableName("bst_Person_Account")
public class BstPersonAccountEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * $column.comments
	 */
	@TableId
	private Integer perid;
	/**
	 * $column.comments
	 */
	private String username;
	/**
	 * $column.comments
	 */
	private String password;
	/**
	 * $column.comments
	 */
	private String passwords;
	/**
	 * $column.comments
	 */
	private String email;
	/**
	 * $column.comments
	 */
	private Boolean acceptmail;
	/**
	 * $column.comments
	 */
	private Date regdate;
	/**
	 * $column.comments
	 */
	private Date logindate;
	/**
	 * $column.comments
	 */
	private Integer loginnum;
	/**
	 * $column.comments
	 */
	private String clientip;
	/**
	 * $column.comments
	 */
	private Integer resumenum;
	/**
	 * $column.comments
	 */
	private Date resumeupdatedate;
	/**
	 * $column.comments
	 */
	private Integer letternum;
	/**
	 * $column.comments
	 */
	private Integer searchernum;
	/**
	 * $column.comments
	 */
	private Integer flag;
	/**
	 * $column.comments
	 */
	private Integer topflag;
	/**
	 * $column.comments
	 */
	private Integer bestflag;
	/**
	 * $column.comments
	 */
	private Date topenddate;
	/**
	 * $column.comments
	 */
	private Date bestenddate;
	/**
	 * $column.comments
	 */
	private Integer advflag;
	/**
	 * $column.comments
	 */
	private Integer moneys;
	/**
	 * $column.comments
	 */
	private Integer drawmoneys;
	/**
	 * $column.comments
	 */
	private Integer outsendtotal;
	/**
	 * $column.comments
	 */
	private Integer outsendnum;
	/**
	 * $column.comments
	 */
	private Integer friendtotal;
	/**
	 * $column.comments
	 */
	private Integer friendnum;
	/**
	 * $column.comments
	 */
	private Integer applyjobtotal;
	/**
	 * $column.comments
	 */
	private Integer applyjobnum;
	/**
	 * $column.comments
	 */
	private Date maildate;
	/**
	 * $column.comments
	 */
	private Integer atttotal;
	/**
	 * $column.comments
	 */
	private Integer attnum;
	/**
	 * $column.comments
	 */
	private Integer authidcard;
	/**
	 * $column.comments
	 */
	private Integer authemail;
	/**
	 * $column.comments
	 */
	private Integer authmobile;
	/**
	 * $column.comments
	 */
	private Integer integral;
	/**
	 * $column.comments
	 */
	private String integralover;
	/**
	 * $column.comments
	 */
	private Integer integralappjob;
	/**
	 * $column.comments
	 */
	private Integer regfrom;
	/**
	 * $column.comments
	 */
	private Integer subid;
	/**
	 * $column.comments
	 */
	private String qqopenid;
	/**
	 * $column.comments
	 */
	private String wxopenid;
	/**
	 * $column.comments
	 */
	private String wxuserid;
	/**
	 * $column.comments
	 */
	private String pass;

}

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
 * @date 2019-09-18 08:36:16
 */
@Data
@TableName("bst_Company_Job")
public class BstCompanyJobEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * $column.comments
	 */
	@TableId
	private Integer jobid;
	/**
	 * $column.comments
	 */
	private Integer comid;
	/**
	 * $column.comments
	 */
	private String username;
	/**
	 * $column.comments
	 */
	private String jobname;
	/**
	 * $column.comments
	 */
	private Integer jobproperty;
	/**
	 * $column.comments
	 */
	private String jobno;
	/**
	 * $column.comments
	 */
	private Integer department;
	/**
	 * $column.comments
	 */
	private Integer mans;
	/**
	 * $column.comments
	 */
	private Integer validitydays;
	/**
	 * $column.comments
	 */
	private String jobtype;
	/**
	 * $column.comments
	 */
	private String workplace;
	/**
	 * $column.comments
	 */
	private String jobtypename;
	/**
	 * $column.comments
	 */
	private String workplacename;
	/**
	 * $column.comments
	 */
	private String specialty;
	/**
	 * $column.comments
	 */
	private String specialtyname;
	/**
	 * $column.comments
	 */
	private String jobtag;
	/**
	 * $column.comments
	 */
	private String jobdesc;
	/**
	 * $column.comments
	 */
	private Integer monthpay;
	/**
	 * $column.comments
	 */
	private Integer astalk;
	/**
	 * $column.comments
	 */
	private String otherpay;
	/**
	 * $column.comments
	 */
	private Integer resumelang;
	/**
	 * $column.comments
	 */
	private Integer degree;
	/**
	 * $column.comments
	 */
	private Integer advance;
	/**
	 * $column.comments
	 */
	private Integer workyears;
	/**
	 * $column.comments
	 */
	private Integer sex;
	/**
	 * $column.comments
	 */
	private Integer minage;
	/**
	 * $column.comments
	 */
	private Integer maxage;
	/**
	 * $column.comments
	 */
	private Integer languagesign;
	/**
	 * $column.comments
	 */
	private Integer languagelevel;
	/**
	 * $column.comments
	 */
	private String linkman;
	/**
	 * $column.comments
	 */
	private String phone;
	/**
	 * $column.comments
	 */
	private Integer phonekeep;
	/**
	 * $column.comments
	 */
	private String fax;
	/**
	 * $column.comments
	 */
	private String email;
	/**
	 * $column.comments
	 */
	private Integer emailkeep;
	/**
	 * $column.comments
	 */
	private String testaddress;
	/**
	 * $column.comments
	 */
	private String postcode;
	/**
	 * $column.comments
	 */
	private String address;
	/**
	 * $column.comments
	 */
	private Integer acceptmail;
	/**
	 * $column.comments
	 */
	private Integer autoreply;
	/**
	 * $column.comments
	 */
	private Integer visitnum;
	/**
	 * $column.comments
	 */
	private Integer sendnum;
	/**
	 * $column.comments
	 */
	private Integer jobflag;
	/**
	 * $column.comments
	 */
	private Integer bestflag;
	/**
	 * $column.comments
	 */
	private Integer hotflag;
	/**
	 * $column.comments
	 */
	private Integer topflag;
	/**
	 * $column.comments
	 */
	private Date topdate;
	/**
	 * $column.comments
	 */
	private Integer topdays;
	/**
	 * $column.comments
	 */
	private Date createdate;
	/**
	 * $column.comments
	 */
	private Date updatedate;
	/**
	 * $column.comments
	 */
	private Integer sourceweb;
	/**
	 * $column.comments
	 */
	private String sourcejobid;

}

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
 * @date 2019-09-18 08:50:46
 */
@Data
@TableName("bst_Company_Account")
public class BstCompanyAccountEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * $column.comments
	 */
	@TableId
	private Integer comid;
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
	private String companyname;
	/**
	 * $column.comments
	 */
	private String licence;
	/**
	 * $column.comments
	 */
	private Integer trade;
	/**
	 * $column.comments
	 */
	private Integer property;
	/**
	 * $column.comments
	 */
	private Integer employee;
	/**
	 * $column.comments
	 */
	private String existdate;
	/**
	 * $column.comments
	 */
	private String companymemo;
	/**
	 * $column.comments
	 */
	private String linkman;
	/**
	 * $column.comments
	 */
	private Integer gender;
	/**
	 * $column.comments
	 */
	private String linkmanjob;
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
	private String mobilephone;
	/**
	 * $column.comments
	 */
	private String fax;
	/**
	 * $column.comments
	 */
	private Integer emailkeep;
	/**
	 * $column.comments
	 */
	private Integer locusarea;
	/**
	 * $column.comments
	 */
	private Integer locuscity;
	/**
	 * $column.comments
	 */
	private String locusname;
	/**
	 * $column.comments
	 */
	private Integer locusroad;
	/**
	 * $column.comments
	 */
	private Integer locusoffices;
	/**
	 * $column.comments
	 */
	private String address;
	/**
	 * $column.comments
	 */
	private String postcode;
	/**
	 * $column.comments
	 */
	private String website;
	/**
	 * $column.comments
	 */
	private Integer urlsign;
	/**
	 * $column.comments
	 */
	private String weburl;
	/**
	 * $column.comments
	 */
	private Integer logokeep;
	/**
	 * $column.comments
	 */
	private String logourl;
	/**
	 * $column.comments
	 */
	private String logoindexurl;
	/**
	 * $column.comments
	 */
	private String logobesturl;
	/**
	 * $column.comments
	 */
	private Integer certsign;
	/**
	 * $column.comments
	 */
	private String certurl;
	/**
	 * $column.comments
	 */
	private String autoreplysubject;
	/**
	 * $column.comments
	 */
	private String autoreplybody;
	/**
	 * $column.comments
	 */
	private Integer templateid;
	/**
	 * $column.comments
	 */
	private String indexbanner;
	/**
	 * $column.comments
	 */
	private String indexads;
	/**
	 * $column.comments
	 */
	private Integer hidename;
	/**
	 * $column.comments
	 */
	private Integer videoflag;
	/**
	 * $column.comments
	 */
	private String videourl;
	/**
	 * $column.comments
	 */
	private String videophotourl;
	/**
	 * $column.comments
	 */
	private Date videodate;
	/**
	 * $column.comments
	 */
	private Integer videodays;
	/**
	 * $column.comments
	 */
	private Integer videostate;
	/**
	 * $column.comments
	 */
	private Integer visitnum;
	/**
	 * $column.comments
	 */
	private Integer userlevel;
	/**
	 * $column.comments
	 */
	private String usersetting;
	/**
	 * $column.comments
	 */
	private Date begindate;
	/**
	 * $column.comments
	 */
	private Date enddate;
	/**
	 * $column.comments
	 */
	private Integer totalmoney;
	/**
	 * $column.comments
	 */
	private Integer goldmoney;
	/**
	 * $column.comments
	 */
	private Integer jobtotal;
	/**
	 * $column.comments
	 */
	private Integer resumetotal;
	/**
	 * $column.comments
	 */
	private Integer advancetotal;
	/**
	 * $column.comments
	 */
	private Integer jobnum;
	/**
	 * $column.comments
	 */
	private Integer resumenum;
	/**
	 * $column.comments
	 */
	private Integer advancenum;
	/**
	 * $column.comments
	 */
	private Integer userstate;
	/**
	 * $column.comments
	 */
	private Date stopdate;
	/**
	 * $column.comments
	 */
	private Date regdate;
	/**
	 * $column.comments
	 */
	private Integer refreshnum;
	/**
	 * $column.comments
	 */
	private Integer renum;
	/**
	 * $column.comments
	 */
	private Date redate;
	/**
	 * $column.comments
	 */
	private Integer smstotal;
	/**
	 * $column.comments
	 */
	private Integer smsnum;
	/**
	 * $column.comments
	 */
	private Date smsdate;
	/**
	 * $column.comments
	 */
	private Integer simpletotal;
	/**
	 * $column.comments
	 */
	private Integer simplenum;
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
	private Integer searchernum;
	/**
	 * $column.comments
	 */
	private String bestcolor;
	/**
	 * $column.comments
	 */
	private Date updatedate;
	/**
	 * $column.comments
	 */
	private Integer saleid;
	/**
	 * $column.comments
	 */
	private Integer mapplace;
	/**
	 * $column.comments
	 */
	private Integer mapscope;
	/**
	 * $column.comments
	 */
	private String mapid;
	/**
	 * $column.comments
	 */
	private Integer mapview;
	/**
	 * $column.comments
	 */
	private String weal;
	/**
	 * $column.comments
	 */
	private Integer weals;
	/**
	 * $column.comments
	 */
	private Integer sourceweb;
	/**
	 * $column.comments
	 */
	private String sourcecomid;
	/**
	 * $column.comments
	 */
	private Integer attentions;
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

}

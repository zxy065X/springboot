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
 * @date 2019-09-18 12:41:40
 */
@Data
@TableName("bst_Person_Resume")
public class BstPersonResumeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * $column.comments
	 */
	@TableId
	private Integer resid;
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
	private String resumename;
	/**
	 * $column.comments
	 */
	private Integer languagesign;
	/**
	 * $column.comments
	 */
	private Integer visitnum;
	/**
	 * $column.comments
	 */
	private Integer visitstate;
	/**
	 * $column.comments
	 */
	private Integer defaultsign;
	/**
	 * $column.comments
	 */
	private Integer cnresume;
	/**
	 * $column.comments
	 */
	private String appraise;
	/**
	 * $column.comments
	 */
	private String workobject;
	/**
	 * $column.comments
	 */
	private String skilldesc;
	/**
	 * $column.comments
	 */
	private Integer skillkeep;
	/**
	 * $column.comments
	 */
	private Integer currenttrade;
	/**
	 * $column.comments
	 */
	private Integer currentjobtype;
	/**
	 * $column.comments
	 */
	private Integer currentjob;
	/**
	 * $column.comments
	 */
	private Integer currentjoblevel;
	/**
	 * $column.comments
	 */
	private Integer workyears;
	/**
	 * $column.comments
	 */
	private Integer abroad;
	/**
	 * $column.comments
	 */
	private Integer currentpaytype;
	/**
	 * $column.comments
	 */
	private Integer currentpaycurrency;
	/**
	 * $column.comments
	 */
	private String currentpay;
	/**
	 * $column.comments
	 */
	private Integer wishjobproperty;
	/**
	 * $column.comments
	 */
	private String wishtrade;
	/**
	 * $column.comments
	 */
	private String wishjob;
	/**
	 * $column.comments
	 */
	private String wishjobname;
	/**
	 * $column.comments
	 */
	private String wishworkplace;
	/**
	 * $column.comments
	 */
	private String wishtradename;
	/**
	 * $column.comments
	 */
	private String wishjobtypename;
	/**
	 * $column.comments
	 */
	private String wishworkplacename;
	/**
	 * $column.comments
	 */
	private Integer wishpaytype;
	/**
	 * $column.comments
	 */
	private Integer wishpaycurrency;
	/**
	 * $column.comments
	 */
	private String wishpay;
	/**
	 * $column.comments
	 */
	private Integer wishconsult;
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
	private Integer onjobtype;
	/**
	 * $column.comments
	 */
	private String onjobdate;
	/**
	 * $column.comments
	 */
	private String require;
	/**
	 * $column.comments
	 */
	private Integer statebasic;
	/**
	 * $column.comments
	 */
	private Integer stateeducate;
	/**
	 * $column.comments
	 */
	private Integer stateappraise;
	/**
	 * $column.comments
	 */
	private Integer statewishjob;
	/**
	 * $column.comments
	 */
	private Integer stateprofession;
	/**
	 * $column.comments
	 */
	private Integer statework;
	/**
	 * $column.comments
	 */
	private Integer statelanguage;
	/**
	 * $column.comments
	 */
	private Integer statetrain;
	/**
	 * $column.comments
	 */
	private Integer stateskill;
	/**
	 * $column.comments
	 */
	private Integer stateit;
	/**
	 * $column.comments
	 */
	private Integer stateitem;
	/**
	 * $column.comments
	 */
	private Integer statecert;
	/**
	 * $column.comments
	 */
	private Integer stateaddons;
	/**
	 * $column.comments
	 */
	private Integer resumelevel;
	/**
	 * $column.comments
	 */
	private Integer enresume;
	/**
	 * $column.comments
	 */
	private String enappraise;
	/**
	 * $column.comments
	 */
	private String enworkobject;
	/**
	 * $column.comments
	 */
	private String enskilldesc;
	/**
	 * $column.comments
	 */
	private Integer enskillkeep;
	/**
	 * $column.comments
	 */
	private Integer encurrenttrade;
	/**
	 * $column.comments
	 */
	private Integer encurrentjobtype;
	/**
	 * $column.comments
	 */
	private Integer encurrentjob;
	/**
	 * $column.comments
	 */
	private Integer encurrentjoblevel;
	/**
	 * $column.comments
	 */
	private Integer enworkyears;
	/**
	 * $column.comments
	 */
	private Integer enabroad;
	/**
	 * $column.comments
	 */
	private Integer encurrentpaytype;
	/**
	 * $column.comments
	 */
	private Integer encurrentpaycurrency;
	/**
	 * $column.comments
	 */
	private String encurrentpay;
	/**
	 * $column.comments
	 */
	private Integer enwishjobproperty;
	/**
	 * $column.comments
	 */
	private String enwishtrade;
	/**
	 * $column.comments
	 */
	private String enwishjob;
	/**
	 * $column.comments
	 */
	private String enwishworkplace;
	/**
	 * $column.comments
	 */
	private Integer enwishpaytype;
	/**
	 * $column.comments
	 */
	private Integer enwishpaycurrency;
	/**
	 * $column.comments
	 */
	private String enwishpay;
	/**
	 * $column.comments
	 */
	private Integer enwishconsult;
	/**
	 * $column.comments
	 */
	private Integer enonjobtype;
	/**
	 * $column.comments
	 */
	private String enonjobdate;
	/**
	 * $column.comments
	 */
	private String enrequire;
	/**
	 * $column.comments
	 */
	private Integer enstatebasic;
	/**
	 * $column.comments
	 */
	private Integer enstatewishjob;
	/**
	 * $column.comments
	 */
	private Integer enstateappraise;
	/**
	 * $column.comments
	 */
	private Integer enstateeducate;
	/**
	 * $column.comments
	 */
	private Integer enstatework;
	/**
	 * $column.comments
	 */
	private Integer enstatelanguage;
	/**
	 * $column.comments
	 */
	private Integer enstatetrain;
	/**
	 * $column.comments
	 */
	private Integer enstateskill;
	/**
	 * $column.comments
	 */
	private Integer enstateit;
	/**
	 * $column.comments
	 */
	private Integer enstateitem;
	/**
	 * $column.comments
	 */
	private Integer enstatecert;
	/**
	 * $column.comments
	 */
	private Integer enstateaddons;
	/**
	 * $column.comments
	 */
	private Integer enresumelevel;
	/**
	 * $column.comments
	 */
	private Integer templateid;
	/**
	 * $column.comments
	 */
	private Integer flag;
	/**
	 * $column.comments
	 */
	private Integer resumetype;
	/**
	 * $column.comments
	 */
	private Integer camid;
	/**
	 * $column.comments
	 */
	private Integer camflag;
	/**
	 * $column.comments
	 */
	private String workdesc;
	/**
	 * $column.comments
	 */
	private String wordurl;
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
	private Integer hunid;

}

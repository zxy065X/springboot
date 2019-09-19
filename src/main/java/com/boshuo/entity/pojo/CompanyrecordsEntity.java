package com.boshuo.entity.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 参加会讯的单位
 * 
 * @author zhangxy
 * @email 18086665761@163.com
 * @date 2019-09-12 09:53:29
 */
@Data
@TableName("companyrecords")
public class CompanyrecordsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String id;
	/**
	 * 
	 */
	private String newsid;
	/**
	 * 
	 */
	private String companyid;
	/**
	 * 
	 */
	private Date date;
	/**
	 * 
	 */
	private Date createtime;

}

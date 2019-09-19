package com.boshuo.entity.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 企业签到
 * 
 * @author zhangxy
 * @email 18086665761@163.com
 * @date 2019-09-11 08:48:55
 */
@Data
@TableName("company_tickets")
public class CompanyTicketsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String id;
	/**
	 * 
	 */
	private String openid;
	/**
	 * 娴兼俺顔唅d
	 */
	private String newsid;
	/**
	 * 会讯标题
	 */
	private String title;
	/**
	 * 浼佷笟鎶ュ悕浜烘樀绉?
	 */
	private String nickname;
	/**
	 * 用户姓名
	 */
	private String name;
	/**
	 * 联系电话
	 */
	private String phone;
	/**
	 * 企业名称
	 */
	private String company;
	/**
	 * 企业邮箱
	 */
	private String email;
	/**
	 * 身份证号码
	 */
	private String idcard;
	/**
	 * 
	 */
	private Date time;
	/**
	 * 
	 */
	private Date createtime;

}

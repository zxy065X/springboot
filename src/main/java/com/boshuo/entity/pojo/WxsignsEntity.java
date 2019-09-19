package com.boshuo.entity.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 微信签到
 * 
 * @author zhangxy
 * @email 18086665761@163.com
 * @date 2019-09-11 08:48:55
 */
@Data
@TableName("wxsigns")
public class WxsignsEntity implements Serializable {
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
	 * 姓名
	 */
	private String name;
	/**
	 * 联系电话
	 */
	private String phone;
	/**
	 * 鏄电О
	 */
	private String nickname;
	/**
	 * 性别  
	 */
	private Integer gender;
	/**
	 * 求职意向
	 */
	private String job;
	/**
	 * 学校
	 */
	private String school;
	/**
	 * 专业
	 */
	private String major;
	/**
	 * 毕业时间
	 */
	private String graduated;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 关注职业
	 */
	private String watch;
	/**
	 * 微信号
	 */
	private String wechat;
	/**
	 * 
	 */
	private Integer status;
	/**
	 * 
	 */
	private Date createtime;
	/**
	 * 
	 */
	private Date time;

}

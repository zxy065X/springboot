package com.boshuo.entity.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import lombok.Data;

/**
 * 求职者信息
 * 
 * @author zhangxy
 * @email 18086665761@163.com
 * @date 2019-09-11 17:23:04
 */
@Data
@TableName("qz_grjbxx")
public class QzGrjbxxEntity implements Serializable {
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
	 * 
	 */
	private Integer gender;
	/**
	 * 
	 */
	private Integer age;
	/**
	 * 身份证号
	 */
	private String idcard;
	/**
	 * 地址
	 */
	private String place;
	/**
	 * 联系电话
	 */
	private String telephone;
	/**
	 * 微信号
	 */
	private String wechat;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 工作年限
	 */
	private String workyear;
	/**
	 * 自我评价
	 */
	private String oneword;
	/**
	 * 
	 */
	private Integer deleteflag;

}

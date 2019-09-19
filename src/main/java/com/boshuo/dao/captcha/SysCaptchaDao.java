package com.boshuo.dao.captcha;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boshuo.entity.pojo.SysCaptchaEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统验证码
 * 
 * @author 18086
 * @email ${email}
 * @date 2019-08-26 12:01:23
 */
@Mapper
public interface SysCaptchaDao extends BaseMapper<SysCaptchaEntity> {
	
}

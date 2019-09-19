package com.boshuo.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boshuo.dao.captcha.SysCaptchaDao;
import com.boshuo.entity.pojo.SysCaptchaEntity;
import com.boshuo.service.SysCaptchaService;
import org.springframework.stereotype.Service;


@Service("sysCaptchaService")
public class SysCaptchaServiceImpl extends ServiceImpl<SysCaptchaDao, SysCaptchaEntity> implements SysCaptchaService {


}
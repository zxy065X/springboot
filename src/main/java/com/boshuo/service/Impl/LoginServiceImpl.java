package com.boshuo.service.Impl;

import com.boshuo.service.LoginService;
import com.boshuo.util.dto.CommonResult;
import com.boshuo.util.mail.SendMailServcie;
import com.boshuo.util.sms.SMSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：zhangxy
 * @date ：Created in 2019/8/27 9:33
 * @description：登陆
 * @modified By：
 * @version: 1.0
 */
@Service
public class LoginServiceImpl implements LoginService {


    @Autowired
    SMSService smsService;

    @Autowired
    SendMailServcie sendMailServcie;


    @Override
    public CommonResult<Void> doLogin(String username, String code, String type) {
        return null;
    }
}

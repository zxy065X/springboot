package com.boshuo.service.Impl;

import com.boshuo.service.SendCodeService;
import com.boshuo.util.ConstantUtil;
import com.boshuo.util.ParamCheckUtil;
import com.boshuo.util.dto.CommonResult;
import com.boshuo.util.dto.Ref;
import com.boshuo.util.mail.SendMailServcie;
import com.boshuo.util.sms.SMSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：zhangxy
 * @date ：Created in 2019/8/27 9:57
 * @description：发送验证码（手机/邮箱）
 * @modified By：
 * @version: 1.0
 */
@Service
public class SendCodeServiceImpl implements SendCodeService {

    @Autowired
    SMSService smsService;

    @Autowired
    SendMailServcie sendMailServcie;

    @Override
    public CommonResult<Void> sendCode(String username, String type) {
        try{
            String code = ConstantUtil.gencode(6);
            if (ParamCheckUtil.isEmall(username)){
                sendMailServcie.sendMail(username,code,Integer.valueOf(type));
            }else if(ParamCheckUtil.isMobile(username)){
                smsService.sendCode(username,Integer.valueOf(type));
            }else {
                return Ref.error("手机号或者邮箱不合法！");
            }
        }catch (Exception e){
            e.printStackTrace();
            return Ref.error("发送失败");
        }

        return Ref.ok();
    }
}

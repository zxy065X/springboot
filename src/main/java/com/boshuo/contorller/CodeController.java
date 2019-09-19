package com.boshuo.contorller;

import com.boshuo.annotation.Param;
import com.boshuo.annotation.RmLogin;
import com.boshuo.service.SendCodeService;
import com.boshuo.util.ConstantUtil;
import com.boshuo.util.dto.CommonResult;
import com.boshuo.util.dto.Ref;
import com.boshuo.util.mail.SendMailServcie;
import com.boshuo.util.sms.SMSService;
import com.boshuo.util.verification.AuthCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.RenderedImage;
import java.util.Map;

/**
 * @author ：zhangxy
 * @date ：Created in 2019/8/26 14:50
 * @description：图像验证码
 * @modified By：
 * @version: 1.0
 */
@RestController
public class CodeController {

    @Autowired
    SMSService smsService;

    @Autowired
    SendMailServcie sendMailServcie;

    @Autowired
    SendCodeService sendCodeService;


    /**
     * create by: zhangxy
     * description: TODO
     * create time: 2019/8/26 14:52
     * 
      * @Param: null
     * @return 
     */
    @GetMapping("captcha.jpg")
    @RmLogin
    public void getCodeAndPic(HttpServletResponse response, HttpServletRequest request)throws Exception{
        Map<String ,Object> map = AuthCodeUtils.getCodeAndpic();
        HttpSession session = request.getSession();
        session.setAttribute("code",map.get("code").toString());

        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", -1);
        response.setContentType("image/jpeg");

        ServletOutputStream out = response.getOutputStream();
        ImageIO.write((RenderedImage) map.get("codePic"), "jpeg", out);
        out.close();
    }

    /**检验验证码
     * create by: zhangxy
     * description: TODO
     * create time: 2019/8/26 15:08
     *
      * @Param: null
     * @return
     */
    @PostMapping("checkCode")
    @RmLogin
    public CommonResult<Void> checkCode(HttpServletRequest request, HttpServletResponse response){
        boolean flag = AuthCodeUtils.checkCode(request, response);
        if (flag){
            return Ref.okMsg("验证通过");
        }else {
            return Ref.error("验证不通过");
        }
    }


    @PostMapping("sendCode")
    @RmLogin
    public CommonResult<Void> sendCode(@Param String username,@Param(regulation = "1,2") String type){
        return sendCodeService.sendCode(username, type);
    }


    /**
     * create by: zhangxy
     * description: TODO
     * create time: 2019/8/26 18:38
     *
      * @Param: null
     * @return
     */
    @PostMapping("sendSMS")
    @RmLogin
    public CommonResult<Void> sendSMS(String mobile) throws Exception {
        smsService.sendCode(mobile,1);
        return Ref.ok();
    }

    @PostMapping("checkSMS")
    @RmLogin
    public CommonResult<Void> checkSMS(String mobile,String sms) throws Exception {
        smsService.testCode(mobile,sms,1);
        return Ref.ok();
    }

    @PostMapping("sendMail")
    @RmLogin
    public CommonResult<Void> sendMail(String mail){
        String random = ConstantUtil.gencode(6);
        sendMailServcie.sendMail(mail,random,1);
        return Ref.ok();
    }

}

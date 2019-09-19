package com.boshuo.util.mail;

import com.boshuo.util.DateUtils;
import com.boshuo.util.redis.RedisService;
import com.boshuo.util.sms.CodeInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;

/**
 * @author ：zhangxy
 * @date ：Created in 2019/8/26 10:16
 * @description：发送邮件
 * @modified By：
 * @version: 1.0$
 */
@Service
public class SendMailUtils implements SendMailServcie {

    private static final Logger logger = LoggerFactory.getLogger(SendMailUtils.class);

    @Autowired
    RedisService redisService;

    /**
     * redis中存贮标志
     */
    static final String SIGN="MAIL";

    /**
     * 发送验证码隔离时间
     */
    static final int ISOLATE_TIME=1;

    /**
     * 验证码有效期 5分钟
     */
    static final int PERIOD_VALIDITY=5;

    static String HOST = "";//smtp服务器
    static String FROM = "";//发件人地址
    static String USER = "";//用户名
    static String PWD = "";//授权码
    static String SUBJECT = "验证码";//邮件标题
    static String[] TOS = null;

    static {
        try {
            Properties properties = new Properties();
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("mail.properties"));
            HOST = properties.getProperty("mail.HOST");
            FROM = properties.getProperty("mail.FROM");
            USER = properties.getProperty("mail.USER");
            PWD = properties.getProperty("mail.PWD");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    /**
     * create by: zhangxy
     * description: TODO
     * create time:  
     * 
      * @Param: null
     * @return 
     */
    @Override
    public String sendMail(String to,String code,Integer type){
        String key = SIGN+to;
        try {
            CodeInfo oldCode=redisService.getObject(key, CodeInfo.class);
            if(null!=oldCode&&oldCode.getType()==type){

                boolean isolate=System.currentTimeMillis()-oldCode.getSendtime()<1000L*60*ISOLATE_TIME;
                if(oldCode.getIsUse()==0&&isolate){
                    return "一分钟内请不要重复发送验证码!";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Properties properties = new Properties();
        properties.setProperty("mail.smtp.host",HOST);//设置服务器属性
        properties.put("mail.smtp.auth","true");//授权
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(FROM,PWD);
            }
        });

        try {
            //创建对象
            MimeMessage message = new MimeMessage(session);
            //set FROM:头部字段
            message.setFrom(new InternetAddress(FROM));
            //set TO:头部字段
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            //主题
            message.setSubject(SUBJECT);
            //邮件内容
            message.setText("验证码是："+code +"。无需回复此邮件！！！");
            //发送邮件
            Transport.send(message);

            CodeInfo codeInfo = new CodeInfo();
            codeInfo.setCode(code);
            codeInfo.setIsUse(0);
            codeInfo.setMobile(SIGN+to);
            codeInfo.setSendtime(System.currentTimeMillis());
            codeInfo.setTotal(0);

            //将信息存入缓存
            redisService.setObject(to, code);
            redisService.setOutTime(to, DateUtils.getDayEndDiff()/1000);

            logger.info("发送成功！！");
            return "success";
        } catch (AddressException e) {
            e.printStackTrace();
            return "fail";
        } catch (MessagingException e) {
            e.printStackTrace();
            return "fail";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @Override
    public String testCode(String to, String code, Integer type) {
        String key=SIGN+to;
        try {
            CodeInfo codeinfo=redisService.getObject(key, CodeInfo.class);
            if(null==codeinfo){
                return "短信验证码未发送成功";
            }
            if(type!=codeinfo.getType()){
                return "该验证码不可使用，请从新获取";
            }
            if(codeinfo.getIsUse()==1){
                return "该验证码已过期，请从新获取";
            }
            boolean isolate=System.currentTimeMillis()-codeinfo.getSendtime()>1000L*60*PERIOD_VALIDITY;
            if(isolate){
                return "该验证码已过期，请从新获取";
            }
            if(!code.equals(codeinfo.getCode())){
                return "验证不正确，请从新输入";
            }
            codeinfo.setIsUse(1);
            redisService.setObject(key, codeinfo);
            redisService.setOutTime(key, DateUtils.getDayEndDiff()/1000);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }

    }

}

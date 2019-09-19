package com.boshuo.util.mail;

/**
 * @author ：zhangxy
 * @date ：Created in 2019/8/26 11:33
 * @description：发送邮件接口
 * @modified By：
 * @version: 1.0$
 */
public interface SendMailServcie {

    String sendMail(String to,String code,Integer type);

    String testCode(String to,String code,Integer type);
}

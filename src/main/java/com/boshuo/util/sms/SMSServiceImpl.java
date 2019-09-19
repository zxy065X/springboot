package com.boshuo.util.sms;

import com.boshuo.util.ConstantUtil;
import com.boshuo.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.boshuo.util.redis.RedisService;

@Component
public class SMSServiceImpl implements SMSService{
	
	/**
	 * redis中存贮标志
	 */
	private static final String SIGN="SMS";
	
	/**
	 * 短信验证码一天可以接收的次数
	 */
	private static final int DAY_CODE_MAX=10;
	
	/**
	 * 短信验证码有效期 5分钟
	 */
	private static final int PERIOD_VALIDITY=5;
	
	/**
	 * 发送短信验证码隔离时间
	 */
	private static final int ISOLATE_TIME=1;
	
	
	@Autowired
	RedisService  redisService;


	@Override
	public String sendCode(String mobile, int type) throws Exception {
		String key=SIGN+mobile;
//		CodeInfo oldCode=redisService.getObject(key, CodeInfo.class);
//		if(null!=oldCode&&oldCode.getType()==type){
//
//			boolean isolate=System.currentTimeMillis()-oldCode.getSendtime()<1000L*60*ISOLATE_TIME;
//			if(oldCode.getIsUse()==0&&isolate){
//				return "一分钟内请不要重复发送验证码!";
//			}
//
//			if(oldCode.getTotal()>=DAY_CODE_MAX){
//				return "您今天的手机号验证码使用次数已用完!";
//			}
//		}
		String code= ConstantUtil.gencode(6);
		System.out.println(code);
		SendSMS.ypsendSMS(mobile, code);
//		CodeInfo newCode=new CodeInfo();
//		newCode.setCode(code);
//		newCode.setIsUse(0);
//		newCode.setMobile(mobile);
//		newCode.setSendtime(System.currentTimeMillis());
//		if(oldCode!=null){
//			newCode.setTotal(oldCode.getTotal()+1);
//		}else{
//			newCode.setTotal(1);
//		}
//		newCode.setType(type);
//		redisService.setObject(key, newCode);
//		redisService.setOutTime(key, DateUtils.getDayEndDiff()/1000);
		
		return "success";
	}


	@Override
	public String testCode(String mobile,String code, int type) throws Exception {
		String key=SIGN+mobile;
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
	}
	
	
	

}

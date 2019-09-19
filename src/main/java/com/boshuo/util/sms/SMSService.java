package com.boshuo.util.sms;

public interface SMSService {
	
	String sendCode(String mobile,int type)throws Exception;
	
	String testCode(String mobile,String code,int type)throws Exception;

}

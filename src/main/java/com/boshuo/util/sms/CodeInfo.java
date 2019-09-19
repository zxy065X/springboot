package com.boshuo.util.sms;

public class CodeInfo {
	
	 private String mobile;
	 private String code;
	 
	 /**
	  * 1:登录  2验证
	  */
	 private int type;
	 
	 private int isUse;
	 
	 private long sendtime;
	 
	 private int total;
	
	

	
	public String getMobile() {
		return mobile;
	}




	public void setMobile(String mobile) {
		this.mobile = mobile;
	}




	public String getCode() {
		return code;
	}




	public void setCode(String code) {
		this.code = code;
	}




	public int getType() {
		return type;
	}




	public void setType(int type) {
		this.type = type;
	}




	public int getIsUse() {
		return isUse;
	}




	public void setIsUse(int isUse) {
		this.isUse = isUse;
	}




	public long getSendtime() {
		return sendtime;
	}




	public void setSendtime(long sendtime) {
		this.sendtime = sendtime;
	}



	public int getTotal() {
		return total;
	}



	public void setTotal(int total) {
		this.total = total;
	}



	

	public CodeInfo(String mobile, String code, int type, int isUse, long sendtime, int total) {
		super();
		this.mobile = mobile;
		this.code = code;
		this.type = type;
		this.isUse = isUse;
		this.sendtime = sendtime;
		this.total = total;
	}




	public CodeInfo() {
		super();
	}
	

}

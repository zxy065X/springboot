package com.boshuo.util;

import java.util.Arrays;

import com.boshuo.util.encrypt.MD5;

public class SignatureUtil {

	private  static final String appSecret = "RUnfEngkj20187hehehhePLyf1se12l";
	
	public static boolean checkSignature(String sign, String timestamp, String nonce) {
		
		 String[] arr = new String[] { appSecret, timestamp, nonce };
		 Arrays.sort(arr);
		 StringBuilder content = new StringBuilder();
		 for (String string : arr) {
			 content.append(string);
		 }	
		 
		 String signature=MD5.JM(content.toString()).toUpperCase();
		 return sign.equals(signature);
		 
	}	
}

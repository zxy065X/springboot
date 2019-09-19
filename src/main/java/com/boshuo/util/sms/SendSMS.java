package com.boshuo.util.sms;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.boshuo.util.HttpUtil;

import java.util.HashMap;
import java.util.Map;

public class SendSMS {
	

	//云片API
	static final String URL="https://sms.yunpian.com/v2/sms/single_send.json";

	//云片APIKEY
	static final String APIKEY="e7840647e114be0172cf0a2b48068afb";

	//阿里云accessKeyId
	static final String accessKeyId = "";

	//阿里云accessKeySecret
	static final String accessKeySecret = "";

	static final String product = "Dysmsapi";//短信API产品名称（短信产品名固定，无需修改）

	static final String domain = "dysmsapi.aliyuncs.com";//短信API产品域名（接口地址固定，无需修改）

	/**云片
	 * 手机发送验证码
	 * create by: zhangxy
	 * description: TODO
	 * create time: 2019/8/26 17:46
	 *
	  * @Param: null
	 * @return
	 */
	public static void ypsendSMS(String mobile,String code) throws Exception {
		Map<String,String > param = new HashMap<>();
		param.put("apikey",APIKEY);
		param.put("mobile",mobile);
		String text = "【张小云】您的验证码是"+code+"。如非本人操作，请忽略本短信";
		param.put("text",text);
		HttpUtil.sendPost(URL,param);
	}

	/**阿里云发送短信
	 * create by: zhangxy
	 * description: TODO
	 * create time: 2019/8/26 17:55
	 *
	  * @Param: null
	 * @return
	 */
	public static boolean alisendSMS(String mobile,String code) throws ClientException {
		System.setProperty("sun.net.client.defaultConnectTimeout","10000");
		System.setProperty("sun.net.client.defaultReadTimeout","10000");

		IClientProfile clientProfile = DefaultProfile.getProfile("cn-hangzhou",accessKeyId,accessKeySecret);
		DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);

		IAcsClient client = new DefaultAcsClient(clientProfile);

		SendSmsRequest request = new SendSmsRequest();
		request.setMethod(MethodType.POST);

		//发送号码
		request.setPhoneNumbers(mobile);
		//必填:短信签名-可在短信控制台中找到
		request.setSignName("云通信");
		request.setTemplateCode("SMS_1000000");

		request.setTemplateParam("{\"name\":\"Tom\", \"code\":\"123\"}");
		//可选-上行短信扩展码(扩展码字段控制在7位或以下，无特殊需求用户请忽略此字段)
		request.setSmsUpExtendCode("90997");

		//可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
		request.setOutId("yourOutId");

		//请求失败这里会抛ClientException异常
		SendSmsResponse sendSmsResponse = client.getAcsResponse(request);

		if(sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
			return true;
		}else {
			return false;
		}
	}

}

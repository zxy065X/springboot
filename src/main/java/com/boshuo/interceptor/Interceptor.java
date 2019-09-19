package com.boshuo.interceptor;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.boshuo.util.ConstantUtil;
import com.boshuo.util.DateUtils;

@Component
public class Interceptor implements HandlerInterceptor{
	
	  private static final Logger logger = LoggerFactory.getLogger(Interceptor.class);
	
	
	  public boolean preHandle(HttpServletRequest request,  
	            HttpServletResponse response, Object handler) throws Exception {  
	    	String url = request.getRequestURI();
			String ip =ConstantUtil.getIp(request);
			logger.info(DateUtils.formatSS(new Date())+"-----come in----------");
			logger.info(ip+"....."+url);
			requestparam(request);//打印参数
			
			//前端分离的数据安全验证
			/*if(url.indexOf("appService")!=-1){
				//来自客户端的请求
				String sign = request.getParameter("sign");
				String timestamp = request.getParameter("timestamp");
				String nonce = request.getParameter("nonce");
				boolean flag = SignatureUtil.checkSignature(sign, timestamp, nonce);
				if(!flag){
					ResponseUtil.outWithJson(response, DataResult.build200("签名错误"));
					return false;
				}
			 }*/
	    	
	        return true;  
	    }  
	      
	   
	    public void postHandle(HttpServletRequest request,  HttpServletResponse response, Object handler,  
	            ModelAndView modelAndView) throws Exception {  
	    	logger.info(DateUtils.formatSS(new Date())+"-----come out----------");  
	    	logger.info("");  
	    	
	    }  
	  
	 
	    public void afterCompletion(HttpServletRequest request,  
	            HttpServletResponse response, Object handler, Exception ex)throws Exception {  
	        // TODO Auto-generated method stub  
	          
	    } 
	    
	    
	    private void requestparam(HttpServletRequest req){
			Map map=req.getParameterMap();  
		    Set keSet=map.entrySet();  
		    for(Iterator itr=keSet.iterator();itr.hasNext();){  
		        Map.Entry me=(Map.Entry)itr.next();  
		        Object ok=me.getKey();  
		        Object ov=me.getValue();  
		        String[] value=new String[1];  
		        if(ov instanceof String[]){  
		            value=(String[])ov;  
		        }else{  
		            value[0]=ov.toString();  
		        }  
		  
		        for(int k=0;k<value.length;k++){  
		        	logger.info(ok+"="+value[k]); 
		        }  
		      }  
		}
	    

}

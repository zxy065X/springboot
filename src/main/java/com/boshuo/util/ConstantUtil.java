package com.boshuo.util;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
* @author pl
* @date 2017年9月5日 上午10:09:04
* @describe
*/
public class ConstantUtil {
	
	    
	    
	    /**
	     * 获取请求的ip
	     * @param request
	     * @return
	     */
		public static String getIp(HttpServletRequest request) {  
			
			String ip = request.getHeader("x-forwarded-for"); 
	        if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {  
	            // 多次反向代理后会有多个ip值，第一个ip才是真实ip
	            if( ip.indexOf(",")!=-1 ){
	                ip = ip.split(",")[0];
	            }
	        }  
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	            ip = request.getHeader("Proxy-Client-IP");  
	        }  
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	            ip = request.getHeader("WL-Proxy-Client-IP");  
	        }  
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	            ip = request.getHeader("HTTP_CLIENT_IP");  
	        }  
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	            ip = request.getHeader("HTTP_X_FORWARDED_FOR");  
	        }  
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	            ip = request.getHeader("X-Real-IP");  
	        }  
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	            ip = request.getRemoteAddr();  
	        } 
	        return ip;  
		    
	     }  
		
		
		/**
		 * 将xml文本转化为Map
		 * @param protocolXML
		 * @return
		 */
		public static Map<String,String> parse(String protocolXML) {  
		    
			 Map<String,String> map = new HashMap<String,String>();
		       try {  
		            DocumentBuilderFactory factory = DocumentBuilderFactory  
		                    .newInstance();  
		            DocumentBuilder builder = factory.newDocumentBuilder();  
		            Document doc = builder  
		                    .parse(new InputSource(new StringReader(protocolXML)));  
		
		            Element root = doc.getDocumentElement();  
		            NodeList books = root.getChildNodes();  
		           if (books != null) {  
		               for (int i = 0; i < books.getLength(); i++) {  
		                    Node book = books.item(i);  
		                    map.put(book.getNodeName(), book.getFirstChild().getNodeValue());
		                }  
		            }  
		        } catch (Exception e) {  
		            e.printStackTrace();  
		        }  
		       return map;
		 }   
		
		
		  /**
		   * 生成随机数
		   */
		  public static String gencode(int len){
				StringBuffer code = new StringBuffer();
				Random rd = new Random();
				for (int i = 0; i < len; i++) {
					code.append(rd.nextInt(10));
				}
				return code.toString();
		  }
		
	
}

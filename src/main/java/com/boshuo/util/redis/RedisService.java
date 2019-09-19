package com.boshuo.util.redis;
	
public interface RedisService {
	
	 void set(String key,String value) throws Exception;
	
	 void set(String key,String value,long time) throws Exception;
	
	 String get(String key) throws Exception;
	 
	 boolean remove(String key)throws Exception;
	 
	 void setOutTime(String key,long time)throws Exception;
	
	 void setObject(String key,Object obj) throws Exception;
	 
	 <T> T getObject(String key, Class<T> clazz)throws Exception;
	
}

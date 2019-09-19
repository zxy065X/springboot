package com.boshuo.util.redis;

import java.util.concurrent.TimeUnit;

import com.boshuo.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisServiceImpl implements RedisService {

	@Autowired
    RedisTemplate<String, String> redis;
	
	/**
	 * 存值
	 */
	public void set(String key, String value)  throws Exception{
		// TODO Auto-generated method stub
		redis.opsForValue().set(key, value);
	}

	/**
	 * 取值
	 */
	public String get(String key)  throws Exception{
		// TODO Auto-generated method stub
		return redis.opsForValue().get(key);
	}

	/**
	 * 存值并设置过期时间
	 */
	@Override
	public void set(String key, String value, long time) throws Exception {
		// TODO Auto-generated method stub
		redis.opsForValue().set(key, value, time, TimeUnit.SECONDS);
	}

	@Override
	public boolean remove(String key) throws Exception {
		return redis.delete(key);
		
	}

	@Override
	public void setOutTime(String key, long time) throws Exception {
		redis.expire(key, time, TimeUnit.SECONDS);
		
	}

	@Override
	public void setObject(String key, Object obj) throws Exception {
		String json = JsonUtil.getBeanToJson(obj);
		redis.opsForValue().set(key, json);
	}

	@Override
	public <T> T getObject(String key, Class<T> clazz) throws Exception {
		String json=redis.opsForValue().get(key);
		return JsonUtil.getJsonToBean(json, clazz);
	}



}

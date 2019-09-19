package com.boshuo.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.boshuo.annotation.Login;
import com.boshuo.annotation.RmLogin;
import com.boshuo.config.SystemConfig;
import com.boshuo.util.HttpContextUtil;
import com.boshuo.util.ParamCheckUtil;
import com.boshuo.util.ResponseUtil;
import com.boshuo.util.StringUitl;
import com.boshuo.util.dto.DataResult;
import com.boshuo.util.redis.RedisService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 对于有@Login注解的方法进行登录校验
 * @author pl
 *
 */
//声明这是一个组件
@Component
//声明这是一个切面Bean
@Aspect
@Order(1)  
public class LoginAspect {

	private static final Logger logger = LoggerFactory.getLogger(LoginAspect.class);
	
	@Autowired
    RedisService redisService;
	
	

	//配置切入点,该方法无方法体,主要为方便同类中其他方法使用此处配置的切入点
	@Pointcut("execution(* com.boshuo.contorller..*.*(..))")
	public void packet(){	}
	
	//配置环绕通知
	@Around("packet()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
		
		
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		RmLogin rmLogin=methodSignature.getMethod().getAnnotation(RmLogin.class);
		//如果排除了登录，就不需要检验
		if(null!=rmLogin){
			return joinPoint.proceed();
		}
		Login login=null;
		Login masterlogin = methodSignature.getMethod().getAnnotation(Login.class);
		Login slavelogin=joinPoint.getTarget().getClass().getAnnotation(Login.class);
		//如果都没有login注解，就不需要检验
		if(null==masterlogin&&null==slavelogin){
			return joinPoint.proceed();
		}
		
		//优先采用方法上的注解
		if(null!=masterlogin){
			login=masterlogin;
		}else{
			login=slavelogin;
		}
		//获取request  response对象
		HttpServletRequest request = HttpContextUtil.getHttpServletRequest();
		HttpServletResponse response = HttpContextUtil.getHttpServletResponse();
		
		//从参数中直接获取
		if(login.getType().equals(Login.Type.PARAMID)){
		     String userId=request.getParameter(login.value());
		     
		     if(StringUitl.isEmpty(userId)){
		    	 if(login.required()){
		    		 logger.warn("必须登录后才能调用的接口没有传入userId");
			    	 ResponseUtil.outWithJson(response, DataResult.build300());
			    	 return null;
		    	 }
		    	 
		     }
		     if(!ParamCheckUtil.isPinteger(userId)){
		    	 logger.warn("userId错误");
		    	 ResponseUtil.outWithJson(response, DataResult.build200("userId错误"));
		    	 return null;
		     }
		}
		//从请求头中获取
		else if(login.getType().equals(Login.Type.HEADTOKEN)){
			
			String token=request.getHeader(SystemConfig.HEAD_TOKEN);
			if(StringUitl.isEmpty(token)){
				if(login.required()){
		    		 logger.warn("必须登录后才能调用的接口没有从head头中获取到token");
			    	 ResponseUtil.outWithJson(response, DataResult.build300());
			    	 return null;
		    	}
			}else{
				
				String info=redisService.get(token);
				logger.info("login="+info);
				if(StringUitl.isEmpty(info)){
					if(login.required()){
						 logger.warn("必须登录后才能调用的接口获取到token,但redis中没有");
				    	 ResponseUtil.outWithJson(response, DataResult.build400());
				    	 return null;
					}
		    		
				}else{
					
					redisService.setOutTime(token, 1800);
					//接口权限控制
					if(login.role().length()>0){
						if(login.role().indexOf(info.split(",")[1])==-1){
							 logger.warn("登录用户访问了权限不足的接口");
					    	 ResponseUtil.outWithJson(response, DataResult.build250("权限不足"));
					    	 return null;
						}
					}
					
		            //使用id的话，注入进去
					if(login.isUse()){
						Object[] args=joinPoint.getArgs();
						args[login.paramIndex()]=Long.parseLong(info.split(",")[0]);
						return joinPoint.proceed(args);
					}
				}
			}
		}
		
		else{
			
		}
		
		return joinPoint.proceed();
		
	}
	
	/*
	 * 配置前置通知,使用在方法aspect()上注册的切入点
	 * 同时接受JoinPoint切入点对象,可以没有该参数
	 
	@Before("packet()")
	public void before(JoinPoint joinPoint){
		
	}
	
	//配置后置通知
	@After("packet()")
	public void after(JoinPoint joinPoint){
		
	}
	
	//配置后置返回通知
	@AfterReturning("packet()")
	public void afterReturn(JoinPoint joinPoint){
		
	}
	
	//配置抛出异常后通知
	@AfterThrowing(pointcut="packet()", throwing="ex")
	public void afterThrow(JoinPoint joinPoint, Exception ex){
		ex.printStackTrace();
	}
	
*/
	
	
}

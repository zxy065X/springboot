package com.boshuo.aop;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.boshuo.annotation.ObjectParam;
import com.boshuo.annotation.Param;
import com.boshuo.util.HttpContextUtil;
import com.boshuo.util.ParamCheckUtil;
import com.boshuo.util.ResponseUtil;
import com.boshuo.util.StringUitl;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.boshuo.util.dto.DataResult;


//声明这是一个组件
@Component
//声明这是一个切面Bean
@Aspect
@Order(2)
public class ParamAspect {

	private static final Logger logger = LoggerFactory.getLogger(ParamAspect.class);
	
	//配置切入点,该方法无方法体,主要为方便同类中其他方法使用此处配置的切入点
	@Pointcut("execution(* com.boshuo.contorller..*.*(..))")
	public void packet(){	}
	 
	
	//配置环绕通知
	@Around("packet()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
		
		//获取request  response对象
		HttpServletRequest request = HttpContextUtil.getHttpServletRequest();
		HttpServletResponse response = HttpContextUtil.getHttpServletResponse();
		
		Object[] args =joinPoint.getArgs();
		//获取代理切入点和入参对象
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		Method method = methodSignature.getMethod();
		String[] parameterNames=methodSignature.getParameterNames();
		Parameter[] parameters=method.getParameters();
		for (int i = 0; i < parameters.length; i++) {
			Parameter parameter=parameters[i];
			Param param=parameter.getAnnotation(Param.class);
			if(param!=null){
				String arg=null==args[i]?null:args[i].toString();
				if(!param.required()&& StringUitl.isEmpty(arg)){
					continue;//不是必须传而且前端也没有传，就检验下一个
				}else{
					if(arg==null){//必须传入而没有传
						logger.warn(parameterNames[i]+"缺失");
						if(param.warn().length()==0){
							ResponseUtil.outWithJson(response, DataResult.build200(parameterNames[i]+"缺失"));
						}else{
							ResponseUtil.outWithJson(response, DataResult.build250(param.warn()));
						}
					    return null;
					}
					if(!dataMarry(param, arg)){
						logger.warn(parameterNames[i]+"数据有误");
						if(param.warn().length()==0){
							ResponseUtil.outWithJson(response, DataResult.build200(parameterNames[i]+"数据有误"));
						}else{
							ResponseUtil.outWithJson(response, DataResult.build250(param.warn()));
						}
					    return null;
					}
				}
				continue;//如果有了@Param注解，就不检验@ObjectParam了
			}
			
			ObjectParam oparam=parameter.getAnnotation(ObjectParam.class);
			if(oparam!=null){
				
				Field[] field=parameter.getType().getDeclaredFields();
				for (int j = 0; j < field.length; j++) {
					Param fparam=field[j].getAnnotation(Param.class);
					if(fparam!=null){
						String farg=request.getParameter(field[j].getName());
						if(!fparam.required()&&StringUitl.isEmpty(farg)){
							continue;//不是必须传而且前端也没有传，就检验下一个
						}else{
							if(null==farg){//必须传入而没有传
								logger.warn(field[j].getName()+"缺失");
								if(fparam.warn().length()==0){
									ResponseUtil.outWithJson(response, DataResult.build200(field[j].getName()+"缺失"));
								}else{
									ResponseUtil.outWithJson(response, DataResult.build250(fparam.warn()));
								}
							
							    return null;
							}
							if(!dataMarry(fparam, farg)){
								logger.warn(field[j].getName()+"数据有误");
								if(fparam.warn().length()==0){
									ResponseUtil.outWithJson(response, DataResult.build200(field[j].getName()+"数据有误"));
								}else{
									ResponseUtil.outWithJson(response, DataResult.build250(fparam.warn()));
								}
								
							    return null;
							}
						}
					}
					
				}
				
			}
			
		}
		return joinPoint.proceed();

	}
	
	public static boolean dataMarry(Param param,String arg){
		if(param.type()== Param.ParamType.MOBILE){
			return ParamCheckUtil.isMobile(arg);
		}else if(param.type()== Param.ParamType.PINTEGER){
			return ParamCheckUtil.isPinteger(arg);
		}else if(param.type()== Param.ParamType.DATE){
			String regulation= Param.ParamType.DATE.value();
			if(param.regulation().length()>0){
				regulation=param.regulation();
			}
			return ParamCheckUtil.isFormatDate(arg, regulation);
		}else if(param.type()== Param.ParamType.EMALL){
			return ParamCheckUtil.isEmall(arg);
		}else if(param.type()== Param.ParamType.QUALIFIER){
			return ParamCheckUtil.isInclude(arg, param.regulation());
		}else if(param.type()== Param.ParamType.RANGE){
			return ParamCheckUtil.isRange(arg, param.regulation());
		}else if(param.type()== Param.ParamType.PLAIN){
			if(param.regulation().length()>0){
				return ParamCheckUtil.isMate(arg, param.regulation());
			}
		}
		
		return true;
	}

}

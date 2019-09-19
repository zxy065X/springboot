package com.boshuo.config;

import com.boshuo.interceptor.Interceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {
	
	@Autowired
    Interceptor interceptor;
	
	
	/**
	 * 添加拦截器
	 */
	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor)
                .excludePathPatterns("/static/**")
                .excludePathPatterns("/data/**");//这里可以添加不拦截的url匹配
        super.addInterceptors(registry);
	}
	
	/**
	 * 配置静态资源映射路径
	 */
	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
		registry.addResourceHandler("/favicon.ico")
		        .addResourceLocations("classpath:/static/favicon.ico");
		registry.addResourceHandler("/data/**")
                .addResourceLocations("file:/data/");
        super.addResourceHandlers(registry);
	}
	

}

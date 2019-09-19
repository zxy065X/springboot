package com.boshuo.contorller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boshuo.annotation.Login;
import com.boshuo.annotation.Param;
import com.boshuo.annotation.Param.ParamType;
import com.boshuo.util.dto.DataResult;

@RestController
@RequestMapping("appServiceDemo")
@Login
public class DemoContorller {
	
	private static final Logger logger = LoggerFactory.getLogger(DemoContorller.class);

	
	@GetMapping("test")
	@Login(required=false)
	public DataResult test(Long userId,
			@Param(type=ParamType.QUALIFIER,regulation="-1,0,1,2,3",required=false)
			String status,
			@Param(type=ParamType.RANGE,regulation="value>0&&value<=1000")
			String money){
		try {
			return null;
		} catch (Exception e) {
			logger.error("test", e);
			return DataResult.build500();
		}
		
	}

}

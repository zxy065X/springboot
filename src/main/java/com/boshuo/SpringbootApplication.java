package com.boshuo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan(value = "com.runfkj.dao.**.*")
public class SpringbootApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(SpringbootApplication.class, args);
	}

}


package com.highlight_spring4.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.highlight_spring4.aware.AwareService;
import com.highlight_spring4.config.AwareConfig;

public class AwareMain {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AwareConfig.class);
		
		AwareService as = context.getBean(AwareService.class);
		
		as.outputResult();
		
		context.close();
	}

}

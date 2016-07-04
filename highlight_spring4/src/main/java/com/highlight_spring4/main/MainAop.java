package com.highlight_spring4.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.highlight_spring4.aop.DemoAnnotationService;
import com.highlight_spring4.aop.DemoMethodService;
import com.highlight_spring4.config.AopConfig;

public class MainAop {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
		
		DemoAnnotationService das = context.getBean(DemoAnnotationService.class);
		
		das.add();
		
		DemoMethodService dms = context.getBean(DemoMethodService.class);
		
		dms.add();
		
		context.close();

	}

}

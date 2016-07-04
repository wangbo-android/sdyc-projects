package com.highlight_spring4.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.highlight_spring4.config.DiConfig;
import com.highlight_spring4.service.UseFunctionService2;

public class Main2 {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DiConfig.class);
		
		UseFunctionService2 useFunctionService2 = context.getBean(UseFunctionService2.class);
		
		System.out.println(useFunctionService2.useFunctionService("hello"));
	}

}

package com.highlight_spring4.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.highlight_spring4.config.ELConfig;

public class ELMain {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ELConfig.class);
		
		ELConfig config = context.getBean(ELConfig.class);
		
		config.outputResource();
	}

}

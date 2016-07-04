package com.highlight_spring4.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.highlight_spring4.config.PrePostConfig;
import com.highlight_spring4.pojo.BeanWayService;
import com.highlight_spring4.pojo.JSR250WayService;

public class PrePostMain {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PrePostConfig.class);
		
		BeanWayService bws = context.getBean(BeanWayService.class);
		
		JSR250WayService jws = context.getBean(JSR250WayService.class);
		
		context.close();
	}

}

package com.highlight_spring4.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.highlight_spring4.compnentannotation.DemoComponentAnnotationService;
import com.highlight_spring4.config.ComponentAnnotationConfig;

public class ComponentAnnotationMain {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ComponentAnnotationConfig.class);
		
		DemoComponentAnnotationService ds = context.getBean(DemoComponentAnnotationService.class);
		
		ds.outputResult();
		
		context.close();
	}

}

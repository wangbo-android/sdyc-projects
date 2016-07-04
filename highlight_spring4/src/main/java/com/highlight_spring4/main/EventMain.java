package com.highlight_spring4.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.highlight_spring4.config.EventConfig;
import com.highlight_spring4.event.DemoEventPublisher;

public class EventMain {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EventConfig.class);
		
		DemoEventPublisher dep = context.getBean(DemoEventPublisher.class);
		
		dep.publishEvent("hello");
		
		context.close();
	}

}

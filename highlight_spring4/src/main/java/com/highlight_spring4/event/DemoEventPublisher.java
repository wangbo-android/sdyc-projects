package com.highlight_spring4.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class DemoEventPublisher {

	@Autowired
	private ApplicationContext context;
	
	public void publishEvent(String msg){
		
		context.publishEvent(new DemoEvent(this,msg));
	}
}

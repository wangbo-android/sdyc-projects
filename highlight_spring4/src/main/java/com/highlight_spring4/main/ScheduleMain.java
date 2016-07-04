package com.highlight_spring4.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.highlight_spring4.config.ScheduleTaskConfig;

public class ScheduleMain {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScheduleTaskConfig.class);
		
	}

}

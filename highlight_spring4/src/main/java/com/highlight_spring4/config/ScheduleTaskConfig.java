package com.highlight_spring4.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan("com.highlight_spring4.scheduletask")
@EnableScheduling
public class ScheduleTaskConfig {

	
}

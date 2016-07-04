package com.highlight_spring4.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import com.highlight_spring4.conditional.ListService;
import com.highlight_spring4.conditional.WindowListService;
import com.highlight_spring4.conditional.WindowsCondition;

@Configuration
public class ConditionConfig {

	@Bean
	@Conditional(WindowsCondition.class)
	public ListService windowListService(){
		
		return new WindowListService();
	}
}

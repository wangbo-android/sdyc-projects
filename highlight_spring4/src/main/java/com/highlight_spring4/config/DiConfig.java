package com.highlight_spring4.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.highlight_spring4.service.FunctionService2;
import com.highlight_spring4.service.UseFunctionService2;

@Configuration
public class DiConfig {

	@Bean
	public FunctionService2 functionService2(){
		
		return new FunctionService2();
	}
	
	@Bean
	public UseFunctionService2 useFunctionService2(){
		
		UseFunctionService2 useFunctionService2 = new UseFunctionService2();
		
		useFunctionService2.setFunctionService2(functionService2());
		
		return useFunctionService2;
	}
}

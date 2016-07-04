package com.highlight_spring4.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.highlight_spring4.pojo.BeanWayService;
import com.highlight_spring4.pojo.JSR250WayService;

@Configuration
@ComponentScan("com.highlight_spring4.pojo")
public class PrePostConfig {

	@Bean(initMethod="init",destroyMethod="destoryed")
	public BeanWayService beanWayService(){
		
		return new BeanWayService();
	}
	
	@Bean
	public JSR250WayService jsr250WayService(){
		
		return new JSR250WayService();
	}
}

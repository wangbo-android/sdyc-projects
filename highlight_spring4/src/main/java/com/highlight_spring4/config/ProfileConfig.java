package com.highlight_spring4.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.highlight_spring4.profile.DemoBean;

@Configuration
@ComponentScan("com.highlight_spring4.profile")
public class ProfileConfig {
	
	@Bean
	@Profile("dev")
	public DemoBean devDemoBean(){
		
		return new DemoBean("from development profile");
	}
	
	@Bean
	@Profile("pro")
	public DemoBean proDemoBean(){
		
		return new DemoBean("from production profile");
	}
}

package com.highlight_spring4.aop;

import org.springframework.stereotype.Service;

@Service
public class DemoAnnotationService {

	@Action(name="注解式拦截的add操作")
	public void add(){
		
		System.out.println("注解式拦截的add操作" + this.getClass().getName());
	}
}

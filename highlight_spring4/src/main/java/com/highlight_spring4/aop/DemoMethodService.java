package com.highlight_spring4.aop;

import org.springframework.stereotype.Service;

@Service
public class DemoMethodService {

	public void add(){
		
		System.out.println("方法规则拦截" + this.getClass().getName());
	}
}

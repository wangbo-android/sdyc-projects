package com.highlight_spring4.pojo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class JSR250WayService {

	@PostConstruct
	public void init(){
		
		System.out.println("jsr 250 way service init");
	}
	
	public JSR250WayService(){
		
		System.out.println("jsr 250 构造函数");
	}
	
	@PreDestroy
	public void destoryed(){
		
		System.out.println("jsr 250 way service destory");
	}
}

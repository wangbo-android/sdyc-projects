package com.highlight_spring4.pojo;

public class BeanWayService {

	public void init(){
		
		System.out.println("init by bean way service");
	}
	
	public BeanWayService(){
		
		System.out.println("bean way service 构造函数");
	}
	
	public void destoryed(){
		
		System.out.println("destoryed by bean way service");
	}
}

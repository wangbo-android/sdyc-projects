package com.highlight_spring4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UseFunctionService {

	@Autowired
	private FunctionService functionService;
	
	public String SayHello(String word){
		
		return functionService.sayHello(word);
	}
}

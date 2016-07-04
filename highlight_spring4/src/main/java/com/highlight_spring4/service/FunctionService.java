package com.highlight_spring4.service;

import org.springframework.stereotype.Service;

@Service
public class FunctionService {

	public String sayHello(String word){
		
		return "Hello" + word + "!"; 
	}
}

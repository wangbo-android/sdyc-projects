package com.highlight_spring4.service;

public class UseFunctionService2 {

	private FunctionService2 functionService2;
	
	public String useFunctionService(String word){
		
		return functionService2.sayHello(word);
	}

	public void setFunctionService2(FunctionService2 functionService2) {
		this.functionService2 = functionService2;
	}
}

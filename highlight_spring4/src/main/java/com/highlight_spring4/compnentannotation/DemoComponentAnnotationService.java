package com.highlight_spring4.compnentannotation;

import org.springframework.stereotype.Service;

@Service
public class DemoComponentAnnotationService {

	public void outputResult() {

		System.out.println("从组合注解配置照样获得的Bean");
	}
}

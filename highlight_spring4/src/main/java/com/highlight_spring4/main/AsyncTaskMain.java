package com.highlight_spring4.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.highlight_spring4.taskexecutor.AsyncTaskExecutorConfig;
import com.highlight_spring4.taskexecutor.AsyncTaskService;

public class AsyncTaskMain {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AsyncTaskExecutorConfig.class);
		
		AsyncTaskService ats = context.getBean(AsyncTaskService.class);
		
		for(int i=0;i<10;i++){
			
			ats.executeAsyncTask(i);
			ats.executeAsyncTaskPlus(i);
		}
		
		context.close();
	}

}

package com.highlight_spring4.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.highlight_spring4.config.ProfileConfig;
import com.highlight_spring4.profile.DemoBean;

public class ProfileMain {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.getEnvironment().setActiveProfiles("dev");
		
		context.register(ProfileConfig.class);
		
		context.refresh();
		
		DemoBean db = context.getBean(DemoBean.class);
		
		System.out.println(db.getContent());
		
		context.getEnvironment().setActiveProfiles("pro");
			
		DemoBean d2b = context.getBean(DemoBean.class);
		
		System.out.println(d2b.getContent());
		
		context.close();
		
	}

}

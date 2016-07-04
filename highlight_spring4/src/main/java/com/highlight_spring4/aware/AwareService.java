package com.highlight_spring4.aware;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

@Service
public class AwareService implements BeanNameAware, ResourceLoaderAware {

	private String beanName;
	
	private ResourceLoader loader;
	
	@Override
	public void setBeanName(String beanName) {
		
		this.beanName = beanName;
	}
	
	@Override
	public void setResourceLoader(ResourceLoader loader) {
		
		this.loader = loader;
	}
	
	public void outputResult(){
		
		System.out.println("Bean 的名称为:" + beanName);
		
		Resource resource = loader.getResource("classpath:com/highlight_spring4/el/test.txt");
		
		try {
			
			System.out.println(IOUtils.toString(resource.getInputStream()));
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}

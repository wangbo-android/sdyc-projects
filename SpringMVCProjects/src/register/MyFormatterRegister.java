package register;

import org.springframework.format.FormatterRegistrar;
import org.springframework.format.FormatterRegistry;

import formmater.CustomerFormmater;

public class MyFormatterRegister implements FormatterRegistrar{

	private String datePattern;
	
	public MyFormatterRegister(String datePattern){
		
		this.datePattern = datePattern;
	}
	
	public void registerFormatters(FormatterRegistry registry) {
		
		registry.addFormatter(new CustomerFormmater(datePattern));
	}
}

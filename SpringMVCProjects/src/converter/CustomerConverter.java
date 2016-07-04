package converter;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class CustomerConverter implements Converter<String,Date>{

	private String datePattern;
	
	public CustomerConverter(String datePattern){
		
		this.datePattern = datePattern;
		System.out.println(datePattern);
	}
	
	public Date convert(String s) {
		
		try{
			SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
			sdf.setLenient(false);
			
			return sdf.parse(s);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}

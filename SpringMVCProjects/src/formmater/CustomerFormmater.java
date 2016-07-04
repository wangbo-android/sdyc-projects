package formmater;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.format.Formatter;

public class CustomerFormmater implements Formatter<Date>{

	private String datePattern;
	
	private SimpleDateFormat sdf;
	
	public CustomerFormmater(String datePattern){
		
		this.datePattern = datePattern;
		sdf = new SimpleDateFormat(datePattern);
		sdf.setLenient(false);
	}
	
	public Date parse(String str, Locale locale) throws ParseException {
		
		try{
			return sdf.parse(str);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public String print(Date date, Locale locale) {
		
		return sdf.format(date);
	}
}

package day0316;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PushbackReader;

public class IOStreamPractise {

	private static InputStream is;
	
	private static InputStreamReader isr;
	
	static{
		
		is = IOStreamPractise.class.getResourceAsStream("test.txt");
		
		isr = new InputStreamReader(is);
	}
	
	public static void main(String[] args) {
		
		try {
			
			PushbackReader pr = new PushbackReader(isr);
			
			char[] buf = new char[1024];
			
			char[] sec = new char[1024];
			
			int hasRead = 0;
			
			while((hasRead = pr.read(buf)) > 0){
				
				if(hasRead == 50){
					
					pr.unread(buf);
					
				}
			}
			
			pr.read(sec);
			System.out.println(new String(sec));
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (IOException e){
			
			e.printStackTrace();
		}
	}

}

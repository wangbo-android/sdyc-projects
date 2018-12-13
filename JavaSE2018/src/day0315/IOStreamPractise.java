package day0315;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class IOStreamPractise {

	public static void main(String[] args) {
		
		InputStream is = IOStreamPractise.class.getResourceAsStream("test.txt");
		
		InputStreamReader irs = new InputStreamReader(is);
		
		BufferedReader br = new BufferedReader(irs);
		
		String str = null;
		
		try {
			
			while((str = br.readLine()) != null){
				
				System.out.println(str);
				
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

}

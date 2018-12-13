package day0305;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPractise {

	public static void main(String[] args) {
		
		Pattern p = Pattern.compile("a*b");
		
		Matcher m = p.matcher("aaaaaaaaaaab");
		
		boolean b = m.matches();
		
		System.out.println(b);
		
		m = p.matcher("bbbbbbb");
		
		System.out.println(m.matches());
		
		System.out.println(Pattern.matches("a*b", "aaaaaaaaaaaaaaaac"));
		
		String str = "������һ�����Java������飬�ҵĵ绰��13582369062�������ѵ绰15633594635";
		
		p = Pattern.compile("((13\\d)|(15\\d))\\d{8}");
		
		m = p.matcher(str);
		
		while(m.find()){
			
			System.out.println(m.group());
		}
	}
}

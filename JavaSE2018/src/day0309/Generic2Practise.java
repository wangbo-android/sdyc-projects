package day0309;

import java.util.ArrayList;
import java.util.List;

public class Generic2Practise {

	private static void test(List<? extends Fruit<String>> list){
		
		
	}
	
	public static void main(String[] args) {
		
		List<Orange> oranges  = new ArrayList<Orange>();
		test(oranges);
	}

}

package day0308;

import java.util.ArrayList;
import java.util.List;

public class GenericPractise {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		List list = new ArrayList();
		
		list.add("����");
		list.add("����2");
		list.add(2);
		
		list.forEach(obj -> System.out.println(obj));
		
		Apple<String> apple = new Apple<String>("�츻ʿ");
		
		System.out.println(apple.getInfo());
	}

}

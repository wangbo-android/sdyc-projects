package day0308;

import java.util.ArrayList;
import java.util.List;

public class GenericPractise {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		List list = new ArrayList();
		
		list.add("泛型");
		list.add("泛型2");
		list.add(2);
		
		list.forEach(obj -> System.out.println(obj));
		
		Apple<String> apple = new Apple<String>("红富士");
		
		System.out.println(apple.getInfo());
	}

}

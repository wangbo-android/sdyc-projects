package day0307;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;

public class CollectionPractise {

	public static void main(String[] args) {
		
		LinkedHashSet<String> lhs = new LinkedHashSet<String>();
		
		lhs.add("1");
		lhs.add("2");
		lhs.add("3");
		
		System.out.println(lhs);
		
		List<String> list = new ArrayList<String>();
		
		list.add("你好");
		list.add("好的");
		list.add("你好");
		
		ListIterator<String> li = list.listIterator();
		
		while(li.hasNext()){
			
			System.out.println(li.next());
			li.add("王博");
		}
		
		System.out.println("-------------------");
		
		while(li.hasPrevious()){
			
			System.out.println(li.previous());
		}
	}

}

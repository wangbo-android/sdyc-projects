package day0312;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GenericPracise {

	public static void main(String[] args) {
		
		Apple<Integer> apple = new Apple<Integer>(123);
		
		System.out.println(apple.getInfos());
		
		List<String> strs = new ArrayList<String>();
		
		List<Integer> nums = new ArrayList<Integer>();
		
		System.out.println(strs.getClass() == nums.getClass());
		
		List<Banana> bananas = new ArrayList<>();
		
		Banana b = new Banana("Ïã½¶");
		
		bananas.add(b);
		
		test(bananas);
		
		String[] s = {"gajkgla","ajglkajlg","gajkgjlak"};
		
		List<String> strList = new ArrayList<String>();
		
		test2(s,strList);
		
		Orange<String> o = new<Integer> Orange<String>(90,"éÙ×Ó");
		
		System.out.println(o.getDesc());
	}
	
	public static void test(List<? extends Fruit<String>> list){
		
		for(Fruit<String> f : list){
			
			System.out.println(f.getInfos());
		}
	}

	public static <T> void test2(T[] o,Collection<T> c){
		
		for(T t : o){
			
			c.add(t);
		}
		
		System.out.println(c);
	}
	
	public static <T,S extends T> void test3(List<T> list,Collection<S> c){
		
		
	}
}

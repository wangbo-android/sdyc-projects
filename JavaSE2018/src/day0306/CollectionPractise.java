package day0306;

import java.util.Collection;
import java.util.HashSet;

public class CollectionPractise {

	public static void main(String[] args) {
		
		Collection<String> books = new HashSet<String>();
		
		books.add("健康了噶极乐空间过来看");
		books.add("寄过来卡进口国既然考垃圾赶快来然而科技");
		books.add("贾郭卡率较高家里看估计快了");
		
		books.forEach(obj -> System.out.println(obj));
	}

}

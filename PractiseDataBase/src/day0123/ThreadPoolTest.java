package day0123;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {

	public static void main(String[] args) {
		
		ExecutorService es = Executors.newFixedThreadPool(6);
		
		Runnable target = () -> {
			
			for(int i=0;i<100;i++){
				
				System.out.println("当前线程名字" + Thread.currentThread());
				
			}
		};
		
		es.submit(target);
		
		es.submit(target);
		
		es.shutdown();
	}

}

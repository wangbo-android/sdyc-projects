package day0318;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadPractise {

	public static void main(String[] args) {
		
		Callable<Integer> cb = (Callable<Integer>)() ->{
			
			int i =0;
			
			for(;i<100;i++){
				
				System.out.println("当前线程" + i);
			}
			
			return i;
			
		};
		
		FutureTask<Integer> ft = new FutureTask<Integer>(cb);
		
		Thread thread = new Thread(ft);
		
		thread.start();
		
		try {
			
			System.out.println("子线程返回这" + ft.get());
			
		} catch (InterruptedException | ExecutionException e) {
			
			e.printStackTrace();
		}
	}

}

class subClass implements Callable<Integer>{
	
	@Override
	public Integer call() throws Exception {
		
		return 1;
	}
}

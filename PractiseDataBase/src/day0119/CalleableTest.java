package day0119;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CalleableTest {

	public static void main(String[] args) {
		
		//Thread thread = new Thread();
		
		FutureTask<Integer> task = new FutureTask<Integer>((Callable<Integer>)() -> {
			
			int i = 0;
			
			for(;i < 10;i++){
				
				System.out.println(Thread.currentThread().getName() + i);
			}
			
			return i;
		});
		
		for(int i=0;i<100;i++){
			
			if(i == 20){
				
				new Thread(task,"�з���ֵ���߳�").start();
			}
		}
		
		try {
			
			System.out.println("���̷߳���ֵ�ǣ�" + task.get());
			
		} catch (InterruptedException | ExecutionException e) {
			
			e.printStackTrace();
		}
	}

}

package day0123;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class TestJoinForkPool {

	public static void main(String[] args) throws InterruptedException {
		
		ForkJoinPool pool = new ForkJoinPool();
		
		pool.submit(new PrintTask(0,500));
		
		pool.awaitTermination(2, TimeUnit.SECONDS);
		
		pool.shutdown();
	}

}

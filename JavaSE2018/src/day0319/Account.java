package day0319;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
	
	private final ReentrantLock lock = new ReentrantLock();
	
	private final Condition cond = lock.newCondition();
	
	private double draw;
	
	public void dropDraw(){
		
		lock.lock();
		
		System.out.println(this.getClass().getName());
		
		try {
			
			if(draw<20.000){
				
			}
			
			cond.await();
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		} finally{
			
			lock.unlock();
		}
	}
}

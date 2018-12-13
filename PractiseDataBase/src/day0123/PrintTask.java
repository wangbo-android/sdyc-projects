package day0123;

import java.util.concurrent.RecursiveAction;

public class PrintTask extends RecursiveAction {
	
	private static final int THREADSTORE = 50;
	
	private int start;
	
	private int end;
	
	public PrintTask(int start,int end) {
		
		this.start = start;
		
		this.end = end;
	}
	
	@Override
	protected void compute() {
		
		if(end - start < THREADSTORE){
			
			for(int i=start;i<end;i++){
				
				System.out.println("当前线程名称" + Thread.currentThread().getName() + "---i的值" + i);
				
			}
			
		}else{
			
			int middle = (start + end) / 2;
			
			PrintTask pt1 = new PrintTask(start,middle);
			PrintTask pt2 = new PrintTask(middle, end);
			
			pt1.fork();
			pt2.fork();
		}
	}
}

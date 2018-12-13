package day0407;

public class MyThread extends Thread {

	private int count = 5;
	
	@Override
	synchronized public void run() {
		
		super.run();
		count--;
		System.out.println("count="+ count);
	}
}

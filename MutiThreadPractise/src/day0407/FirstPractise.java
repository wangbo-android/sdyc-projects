package day0407;

public class FirstPractise {

	public static void main(String[] args) {
		
		//System.out.println(Thread.currentThread().getName());
		MyThread myThread = new MyThread();
		
		Thread thread = new Thread(myThread,"A");
		Thread thread2 = new Thread(myThread,"B");
		Thread thread3 = new Thread(myThread,"C");
		Thread thread4 = new Thread(myThread,"D");
		
		thread.start();
		thread2.start();
		thread3.start();
		thread4.start();
	}

}

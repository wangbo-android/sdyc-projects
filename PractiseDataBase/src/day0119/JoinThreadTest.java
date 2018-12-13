package day0119;

public class JoinThreadTest {

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("主线程开始执行");
		
		JoinThread jt = new JoinThread();
		
		jt.start();
		
		jt.join();
		
		System.out.println("主线程恢复执行");
		
	}

}

class JoinThread extends Thread{
	
	@Override
	public void run() {
		
		System.out.println("另一个线程开始执行");
	}
}

package day0119;

public class JoinThreadTest {

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("���߳̿�ʼִ��");
		
		JoinThread jt = new JoinThread();
		
		jt.start();
		
		jt.join();
		
		System.out.println("���ָ̻߳�ִ��");
		
	}

}

class JoinThread extends Thread{
	
	@Override
	public void run() {
		
		System.out.println("��һ���߳̿�ʼִ��");
	}
}

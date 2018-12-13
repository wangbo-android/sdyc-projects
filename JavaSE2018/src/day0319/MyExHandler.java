package day0319;

public class MyExHandler {

	public static void main(String[] args) {
		
		Thread.currentThread().setUncaughtExceptionHandler(new MyUncaughchException());
		
		int a = 5 / 0;
		
		System.out.println("程序正常结束");
	}

}

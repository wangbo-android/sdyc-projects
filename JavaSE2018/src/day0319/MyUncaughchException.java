package day0319;

import java.lang.Thread.UncaughtExceptionHandler;

public class MyUncaughchException implements UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread th, Throwable e) {
		
		System.out.println(th + "�̳߳������쳣" + e);
	}
}

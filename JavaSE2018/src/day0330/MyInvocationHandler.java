package day0330;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {

	private Object target;
	
	public void setTarget(Object target){
		
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		
		FooUtill fu = new FooUtill();
		
		fu.method1();
		
		Object result = method.invoke(target, args);
		
		fu.method2();
		
		return result;
	}
}

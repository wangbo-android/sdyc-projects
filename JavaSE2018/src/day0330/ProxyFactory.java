package day0330;

import java.lang.reflect.Proxy;

public class ProxyFactory{

	public static Object getProxy(Object obj){
		
		MyInvocationHandler ih = new MyInvocationHandler();
		
		ih.setTarget(obj);
		
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), ih);
	}
	
	public static <T> T getInstance(Class<T> clzz) throws InstantiationException, IllegalAccessException{
		
		return (T)clzz.newInstance();
	}
}

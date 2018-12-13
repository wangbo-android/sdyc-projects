package day0330;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import day0328.InfosHandler;

public class ReflectionCLassPractise {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Class<InfosHandler> clzz = InfosHandler.class;
		
		Constructor<InfosHandler> cst = clzz.getConstructor(String.class);
		
		InfosHandler ih = cst.newInstance("wangbo");
		
		System.out.println(ih.getName());
		
		//Method method = clzz.getMethod("test", String.class);
		
		Method method = clzz.getDeclaredMethod("test", String.class);
		
		method.setAccessible(true);
		
		method.invoke(ih, "ÀîËÄ");
		
		//Foo foo = (Foo)Proxy.newProxyInstance(Foo.class.getClassLoader(), new Class[]{Foo.class}, new MyInvocationHandler());
		
		//foo.sayHello("ÄãºÃ");
		
		Foo foo = new SubFoo();
		
		Foo fo = (Foo)ProxyFactory.getProxy(foo);
		
		fo.sayHello("°¡");
		
		fo.walk();
	}

}

class SubFoo implements Foo{
	
	@Override
	public void sayHello(String words) {
		
		System.out.println(words);
	}
	
	@Override
	public void walk() {
		
		System.out.println("walk");
	}
}
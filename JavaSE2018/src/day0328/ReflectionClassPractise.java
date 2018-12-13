package day0328;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionClassPractise {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		
		Class<InfosHandler> clss = InfosHandler.class;
		
		Constructor<InfosHandler> con = clss.getConstructor(String.class);
		
		InfosHandler handle = (InfosHandler)con.newInstance("Íõ²©");
		
		Method method = clss.getMethod("infos", String.class);
		
		method.invoke(handle, "ÀîËÄ");
		
		System.out.println(clss.isInstance(handle));
		
		Field age = clss.getDeclaredField("age");
		
		System.out.println(age.getModifiers());
		
		System.out.println(Modifier.toString(age.getModifiers()));
	}

}

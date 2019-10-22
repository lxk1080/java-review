package com.etc.reflects;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Ref04_Methods {
	public static void main(String[] args) throws Exception {
		// 获取字节码文件对象
		Class c = Class.forName("com.etc.reflects.Entity_Person");

		// 01_获取所有的方法
		// Method[] methods = c.getMethods(); // 获取自己的包括父亲的公共方法
		// Method[] methods = c.getDeclaredMethods(); // 获取自己的所有的方法
		// for (Method method : methods) {
		// System.out.println(method);
		// }
		
		Constructor con = c.getConstructor();
		Object obj = con.newInstance();

		// 02_获取单个方法并使用
		// public void show()
		// public Method getMethod(String name,Class<?>... parameterTypes)
		// 第一个参数表示的方法名，第二个参数表示的是方法的参数的class类型
		Method m1 = c.getMethod("show");
		// public Object invoke(Object obj,Object... args)
		// 返回值是Object接收,第一个参数表示对象是谁，第二参数表示调用该方法的实际参数
		m1.invoke(obj); // 调用obj对象的m1方法

		System.out.println("----------");
		Method m2 = c.getMethod("method", String.class);
		m2.invoke(obj, "hello");
		System.out.println("----------");

		// public String getString(String s, int i)
		Method m3 = c.getMethod("getString", String.class, int.class);
		Object objString = m3.invoke(obj, "hello", 100);
		System.out.println(objString);
		// String s = (String)m3.invoke(obj, "hello",100);
		// System.out.println(s);
		System.out.println("----------");
		
		// 03_获取私有方法
		// private void function()
		Method m4 = c.getDeclaredMethod("function"); //获取私有方法
		m4.setAccessible(true); //设置为忽略访问权限
		m4.invoke(obj);
	}
}

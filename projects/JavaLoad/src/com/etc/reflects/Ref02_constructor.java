package com.etc.reflects;

import java.lang.reflect.Constructor;

/*
 * 通过反射获取构造方法并使用。
 */
public class Ref02_constructor {
	public static void main(String[] args) throws Exception {
		// 获取字节码文件对象
		Class c = Class.forName("com.etc.reflects.Person");

		// 01_获取构造方法
		// public Constructor[] getConstructors():所有公共构造方法
		// public Constructor[] getDeclaredConstructors():所有构造方法
		// Constructor[] cons = c.getDeclaredConstructors();
		// for (Constructor con : cons) {
		// System.out.println(con);
		// }

		// 02_获取单个构造方法
		// public Constructor<T> getConstructor(Class<?>... parameterTypes)
		// 参数表示的是：你要获取的构造方法的构造参数个数及数据类型的class字节码文件对象
		Constructor con = c.getConstructor();// 返回的是构造方法对象

		// Person p = new Person();
		// System.out.println(p);
		// public T newInstance(Object... initargs)
		// 使用此 Constructor 对象表示的构造方法来创建该构造方法的声明类的新实例，并用指定的初始化参数初始化该实例。
		Object obj = con.newInstance();
		System.out.println(obj);

		// Person p = (Person)obj;
		// p.show();

		// 03_获取带参构造方法对象
		// public Constructor<T> getConstructor(Class<?>... parameterTypes)
		Constructor con2 = c.getConstructor(String.class, int.class,String.class);

		// 通过带参构造方法对象创建对象
		// public T newInstance(Object... initargs)
		Object obj2 = con2.newInstance("林青霞", 27, "北京");

		System.out.println(obj2);

		
		// 04_获取私有构造方法对象
		// NoSuchMethodException：每个这个方法异常
		// 原因是一开始我们使用的方法只能获取公共的，下面这种方式就可以了。
		Constructor con3 = c.getDeclaredConstructor(String.class);

		// 用该私有构造方法创建对象
		// IllegalAccessException:非法的访问异常。
		// 暴力访问
		con3.setAccessible(true);// 值为true则指示反射的对象在使用时应该取消Java语言访问检查。
		Object obj3 = con3.newInstance("风清扬");

		System.out.println(obj3);
	}
}

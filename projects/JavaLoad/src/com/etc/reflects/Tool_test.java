package com.etc.reflects;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class Tool_test {
	public static void main(String[] args) throws Exception {
		Person p = new Person();
		Tool t = new Tool();
		t.setProperty(p, "name", "林青霞");
		t.setProperty(p, "age", 27);
		System.out.println(p);
		System.out.println("-----------");

		Dog d = new Dog();

		t.setProperty(d, "sex", '男');
		t.setProperty(d, "price", 12.34F);

		System.out.println(d);
	}
}

// 狗类
class Dog {
	char sex;
	float price;

	@Override
	public String toString() {
		return sex + "---" + price;
	}
}

// 人类
class Person {
	private String name;
	public int age;

	@Override
	public String toString() {
		return name + "---" + age;
	}
}

// 给对象的成员变量赋值 的 工具
class Tool {
	public void setProperty(Object obj, String propertyName, Object value) throws Exception {
		// 根据对象获取字节码文件对象
		Class c = obj.getClass();
		// 获取该对象的propertyName成员变量
		Field field = c.getDeclaredField(propertyName);
		// 取消访问检查
		field.setAccessible(true);
		// 给对象的成员变量赋值为指定的值
		field.set(obj, value);
	}
}

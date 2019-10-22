package com.etc.object;
/*
  public final Class getClass():返回此 Object 的运行时类
		Class类的方法：
			public String getName()：以 String 的形式返回此 Class 对象所表示的实体
*/
public class GetClass {
	public static void main(String[] args) {
		Student s = new Student();
		Class c = s.getClass();
		String str = c.getName();
		System.out.println(str);
		
		String str2 = s.getClass().getName();
		System.out.println(str2);
		
	}
}

package com.etc.innerClass;
/*
成员内部类的修饰符：
	private 为了保证数据的安全性
	static 为了方便访问数据
		注意：静态内部类访问的外部类数据必须用静态修饰。
*/
class Outer2 {
	private int num = 10;
	private static int num2 = 100;
	
	//内部类用静态修饰是因为内部类可以看出是外部类的成员
	public static class Inner {
		public void show() {
			//System.out.println(num);
			System.out.println(num2);
		}

		public static void show2() {
			//System.out.println(num);
			System.out.println(num2);
		}		
	}
}

public class StaticInnerClass {
	public static void main(String[] args) {
		//使用内部类
		// 限定的新静态类
		//Outer.Inner oi = new Outer().new Inner();
		//oi.show();
		//oi.show2();
		
		//成员内部类被静态修饰后的访问方式是:
		//格式：外部类名.内部类名 对象名 = new 外部类名.内部类名();
		Outer2.Inner oi = new Outer2.Inner();
		oi.show();
		oi.show2();
		
		//show2()的另一种调用方式
		Outer2.Inner.show2();
	}
}
package com.etc.innerClass;
/*
匿名内部类（局部内部类的一种形式，本质是一个对象）
	就是内部类的简化写法。

前提：存在一个类或者接口
	这里的类可以是具体类也可以是抽象类。

格式：
	new 类名或者接口名(){
		重写方法;
	}
	
本质是什么呢?
	是一个继承了该类或者实现了该接口的匿名子类对象。
	
*/
interface Inter {
	public abstract void show();
	public abstract void show2();
}

class Outer4 {
	public void method() {
		//一个方法的时候
		/*
		new Inter() {
			public void show() {
				System.out.println("show");
			}
		}.show();
		*/
		
		//二个方法的时候
		/*
		new Inter() {
			public void show() {
				System.out.println("show");
			}
			
			public void show2() {
				System.out.println("show2");
			}
		}.show();
		
		new Inter() {
			public void show() {
				System.out.println("show");
			}
			
			public void show2() {
				System.out.println("show2");
			}
		}.show2();
		*/
		
		//如果我是很多个方法，就很麻烦了
		//那么，我们有没有改进的方案呢?
		Inter i = new Inter() { //多态
			public void show() {
				System.out.println("show");
			}
			
			public void show2() {
				System.out.println("show2");
			}
		};
		
		i.show();
		i.show2();
	}
}

public class NoNameInnerClass {
	public static void main(String[] args) {
		Outer4 o = new Outer4();
		o.method();
	}
}

package com.etc.abstracts;
/*
一个类如果没有抽象方法，可不可以定义为抽象类?如果可以，有什么意义?
	A:可以。
	B:不让创建对象。

abstract不能和哪些关键字共存?
	private	冲突
	final	冲突	
	static	无意义（静态方法可以直接被调用，但抽象方法没有方法体，调用无意义）
*/
abstract class Fu {
	public abstract void show();
	
	//非法的修饰符组合: abstract和private
	//private abstract void show();
	
	//非法的修饰符组合
	//final abstract void show();	
	
	//非法的修饰符组合
	//static abstract void show();
	
	public static void method() {
		System.out.println("method");
	}
}

class Zi extends Fu {
	@Override
	public void show() {}
}

public class AbsQuestion {
	public static void main(String[] args) {
		Fu.method();
	}
}
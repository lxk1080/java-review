package com.etc.interfaces;
/*
类与类：
	继承关系,只能单继承,可以多层继承。
类与接口：
	实现关系,可以单实现,也可以多实现。
	并且还可以在继承一个类的同时实现多个接口。
接口与接口：
	继承关系,可以单继承,也可以多继承。
*/
interface Father {
	public abstract void show();
}

interface Mother {
	public abstract void show2();
}

interface Sister extends Father,Mother {  //接口多继承

}

//class Son implements Father,Mother //一个类实现多个接口
class Son extends Object implements Father,Mother {
	public void show() {
		System.out.println("show son");
	}
	
	public void show2() {
		System.out.println("show2 son");
	}
}

public class InterRelation {
	public static void main(String[] args) {
		//创建对象
		Father f = new Son();
		f.show();
		//f.show2(); //报错，左编译，右运行
	
		Mother m = new Son();
		//m.show(); //报错，左编译，右运行
		m.show2();
	}
}

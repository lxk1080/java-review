package com.etc.keyword;

public final class Static { //不可被继承
	final int a=0; //常量
	public final void add(){
		//不可被重写
	}
	private int a1 = 4;
	
	static String name = "your_username"; //静态变量是全局变量，int类型初始化是0,String类型初始化是null
	
	public static void cc(){ 
		int b=4; //不管是静态的还是非静态的方法都不可定义静态变量
		System.out.println(name); //静态方法只能访问静态变量
	}

	public static void main(String[] args) {
		Static.cc();	//静态方法，【类名.方法名】调用
		Static.name="qwer";	//静态属性，【类名.方法名】调用
	}
}

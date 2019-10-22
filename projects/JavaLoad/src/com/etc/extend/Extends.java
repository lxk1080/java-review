package com.etc.extend;
/*		
this和super的区别?
	分别是什么呢?
		this代表本类对应的引用。
		super代表父类存储空间的标识(可以理解为父类引用,可以操作父类的成员)

		A:调用成员变量
			this.成员变量 调用本类的成员变量
			super.成员变量 调用父类的成员变量
		B:调用构造方法
			this(参数)	调用本类的构造方法
			super(参数)	调用父类的构造方法
		C:调用成员方法
			this.成员方法 调用本类的成员方法
			super.成员方法 调用父类的成员方法
*/
class Father{
	public int num = 10;
}

public class Extends extends Father {
	public int num = 20;
	
	public void show(){
		int num = 30;
		System.out.println(num);
		System.out.println(this.num);  //this代表着这个类
		System.out.println(super.num); //调用父类的num
	}
	
	public static void main(String[] args) {
		Extends e = new Extends();
		e.show();
	}
}

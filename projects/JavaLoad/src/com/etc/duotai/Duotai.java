package com.etc.duotai;
/*
多态：同一个对象(父类对象)，在不同时刻(引用不同的子类对象)体现出来的不同状态，调用同一个方法可能会有不同的效果

多态的前提：
	A:要有继承关系。
	B:要有方法重写。
		其实没有也是可以的，但是如果没有这个就没有意义。
			动物 d = new 猫();
			d.show();
			动物 d = new 狗();
			d.show();
	C:要有父类引用指向子类对象。
		父 f =  new 子();

多态中的成员访问特点：
	B:构造方法
		创建子类对象的时候，访问父类的构造方法，对父类的数据进行初始化。
	A:成员变量
		编译看左边，运行看左边。
	C:成员方法
		编译看左边，运行看右边。
	D:静态方法
		编译看左边，运行看左边。
		(静态和类相关，算不上重写，所以，访问还是左边的)
		
	结论：由于成员方法存在方法重写，所以它运行看右边。
*/
class Fu {
	public int num = 100;

	public void show() {
		System.out.println("show Fu");
	}
	
	public static void function() {
		System.out.println("function Fu");
	}
}

class Zi extends Fu {
	public int num = 1000;  //变量是不存在重写的
	public int num2 = 200;

	public void show() {
		System.out.println("show Zi");
	}
	
	public void method() {
		System.out.println("method zi");
	}
	
	public static void function() {
		System.out.println("function Zi");
	}
}

public class Duotai {
	public static void main(String[] args) {
		//要有父类引用指向子类对象。
		//父 f =  new 子();
		Fu f = new Zi();
		System.out.println(f.num);
		//找不到符号
		//System.out.println(f.num2);
		
		f.show();
		//找不到符号
		//f.method();
		f.function();
	}
}

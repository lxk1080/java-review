package com.etc.duixiang;
/*
static的特点：(它可以修饰成员变量，还可以修饰成员方法)
		A:随着类的加载而加载（静态变量随着类的创建而创建，而成员变量是随着对象的创建而创建）
			回想main方法。
		B:优先于对象存在（先有类，后有对象实例）
		C:被类的所有对象共享（..最大的特点..）
			局部变量：栈
			成员变量：堆
			静态变量：方法区的静态区
		D:可以通过类名调用（类变量，类方法是属于类的，不可以在方法中定义）
			其实它本身也可以通过对象名调用。
			推荐使用类名调用。
			
			静态修饰的内容一般我们称其为：与类相关的，类成员（类变量，类方法）
static关键字注意事项
	A:在静态方法中是没有this关键字的
		如何理解呢?
			静态是随着类的加载而加载，this是随着对象的创建而存在。
			静态比对象先存在。
	B:静态方法只能访问静态的成员变量和静态的成员方法
			静态方法：
				成员变量：只能访问静态变量
				成员方法：只能访问静态成员方法
			非静态方法：
				成员变量：可以是静态的，也可以是非静态的
				成员方法：可是是静态的成员方法，也可以是非静态的成员方法。
		简单记：
			静态只能访问静态。
*/
public class StaticKey {
	public int num = 10;
	public static int num2 = 20;
	
	public void function() {
		
	}
	
	public static void function2() {
	
	}
	public void show() {
		System.out.println(num); //隐含的告诉你访问的是成员变量
		System.out.println(this.num); //明确的告诉你访问的是成员变量
		System.out.println(num2);  //静态变量
		
		function();  //成员方法
		function2();  //静态方法
	}
	
	public static void method() {
		//无法从静态上下文中引用非静态 变量 num
		//System.out.println(num);
		System.out.println(num2);
		
		//无法从静态上下文中引用非静态 方法 function()
		//function();
		function2();
	}

	public static void main(String[] args) {
		StaticKey t = new StaticKey();
		t.show();
		System.out.println("------------");
		t.method();
	}
}

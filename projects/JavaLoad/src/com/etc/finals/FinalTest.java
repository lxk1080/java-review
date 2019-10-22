package com.etc.finals;

/*
final可以修饰类，方法，变量
特点：
	final可以修饰类，该类不能被继承。
	final可以修饰方法，该方法不能被重写。(覆盖，复写)
	final可以修饰变量，该变量不能被重新赋值。因为这个变量其实常量。	
常量：
	A:字面值常量
		"hello",10,true
	B:自定义常量
		final int x = 10;
		
final修饰局部变量的问题
		基本类型：基本类型的值不能发生改变。
		引用类型：引用类型的地址值不能发生改变，但是，该对象的堆内存的值是可以改变的。
final修饰变量的初始化时机
		A:被final修饰的变量只能赋值一次。
		B:在构造方法完毕前。(非静态的常量，因为静态的是随着类加载的，那个时候是不调用构造方法的)
*/
class Student {
	
	int age = 10;
	
	static final int f = 0;  //静态常量直接初始化
	
	final int s;
	
	public Student(){
		s = 10;  //非静态常量在构造方法完毕前初始化即可
	}
}

public class FinalTest {
	public static void main(String[] args) {
		//局部变量是基本数据类型
		int x = 10;
		x = 100;
		System.out.println(x);
		final int y = 10;
		//无法为最终变量y分配值
		//y = 100;
		System.out.println(y);
		System.out.println("--------------");
		
		//局部变量是引用数据类型
		Student s1 = new Student();
		System.out.println(s1.age);
		s1.age = 100;
		System.out.println(s1.age);
		System.out.println("--------------");
		
		final Student s2 = new Student();
		System.out.println(s2.age);
		s2.age = 100;
		System.out.println(s2.age);
		
		//重新分配内存空间
		//无法为最终变量ss分配值
		//ss = new Student();
	}
}

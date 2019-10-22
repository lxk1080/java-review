package com.etc.interfaces;
/*
多态开发中的三种形式：
	A:具体类多态(几乎没有)
	B:抽象类多态(常用)
	C:接口多态(最常用)

接口成员特点
		成员变量：只能是常量，并且是静态的。
				默认修饰符：public static final
				建议：自己手动给出。
		构造方法：接口没有构造方法。
		成员方法：只能是抽象方法。
				默认修饰符：public abstract
				建议：自己手动给出。
		
	所有的类都默认继承自一个类：Object。
	类 Object 是类层次结构的根类。每个类都使用 Object 作为超类。
*/
interface InterSup {
	public int num = 10;
	public final int num2 = 20;
	public static final int num3 = 30;  //接口默认格式
	
	//错误: 需要<标识符>
	//public Inter() {}  //无构造方法
	
	//接口方法不能带有主体
	//public void show() {}  //只能是抽象方法，抽象方法不带主体

	//abstract void show(); //默认public
	//public void show(); //默认abstract
	public abstract void show();
}

//接口名+Impl这种格式是接口的实现类格式

class InterImpl implements InterSup {
	public InterImpl() {
		super();
	}
	public void show() {}
}

/*
class InterImpl extends Object implements InterSup {
	public InterImpl() {
		super();  //父类为Object
	}
	
	public void show() {}
}*/

//测试类
public class Inter {
	public static void main(String[] args) {
		//创建对象
		InterSup i = new InterImpl();
		System.out.println(i.num);
		System.out.println(i.num2);
		//i.num = 100;
		//i.num2 = 200;
		//System.out.println(i.num); //无法为最终变量num分配值
		//System.out.println(i.num2);//无法为最终变量num2分配值
		System.out.println(InterSup.num);
		System.out.println(InterSup.num2);
		
	}
}

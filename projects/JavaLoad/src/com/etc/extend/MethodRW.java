package com.etc.extend;
/*
方法重写：子类中出现了和父类中方法声明一模一样的方法。

方法重载：
	本类中出现的方法名一样，参数列表不同的方法。与返回值无关。

方法重写的注意事项
		A:父类中私有方法不能被重写
			因为父类私有方法子类根本就无法继承
		B:子类重写父类方法时，访问权限不能更低
			最好就一致
		C:父类静态方法，子类也必须通过静态方法进行重写 （事实上是隐藏）
			
		子类重写父类方法的时候，最好声明一模一样。
*/
abstract class Phone {
	public void call(String name) {
		System.out.println("给"+name+"打电话");
	}
	public static void show(){
		System.out.println("father");
	}
}

class NewPhone extends Phone {
	public void call(String name) {
		//System.out.println("给"+name+"打电话");
		super.call(name);
		System.out.println("可以听天气预报了");
	}
	public static void show() {
		System.out.println("son");
	}
}

public class MethodRW {
	public static void main(String[] args) {
		NewPhone np = new NewPhone();
		np.call("水电费");
		Phone p = new NewPhone();
		p.show();

	}
}

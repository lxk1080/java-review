package com.etc.abstracts;
/*
返回值类型
	基本类型:(基本类型太简单)
	引用类型：
		类:返回的是该类的对象
		抽象类:返回的是该抽象类的子类对象
		接口:返回的是该接口的实现类的对象
*/

interface Love {
	public abstract void love();
}

class Teacher implements Love {
	public void love() {
		System.out.println("老师爱学生,爱Java,爱林青霞");
	}
}

class LoveDemo {
	public void method(Love l) { //l; l = new Teacher();  Love l = new Teacher(); 多态
		l.love();
	}
}

public class AsReturn {
	public static void main(String[] args) {
		LoveDemo ld = new LoveDemo();
		Love l = new Teacher();
		ld.method(l);
	}
}
package com.etc.innerClass;
/*
匿名内部类面试题：
	按照要求，补齐代码
		interface Inter { void show(); }
		class Outer { //补齐代码 }
		class OuterDemo {
			public static void main(String[] args) {
				  Outer.method().show();
			  }
		}
		要求在控制台输出”HelloWorld”
*/
interface Inters { void show(); }
/*class IntersImpl implements Inters {
	public void show(){
		System.out.println("hello world");
	}
}*/
class Outers {
	public static Inters method(){
		Inters i = new Inters(){
			public void show(){
				System.out.println("hello world");
			}
		};
		return i;
	}
}	

public class NoNameInnerTest {
	public static void main(String[] args) {
		Outers.method().show();
	}
}

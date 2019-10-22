package com.etc.col_lists;

public class Gen_genMethod {
	public static void main(String[] args) {
		ObjectTool2 ot = new ObjectTool2();
		ot.show("hello");
		ot.show(100);
		ot.show(true);
	}
}

/*
 * 泛型方法：把泛型定义在方法上
 */
class ObjectTool2 {
	public <T> void show(T t) {
		System.out.println(t);
	}
}
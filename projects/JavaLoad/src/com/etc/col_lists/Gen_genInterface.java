package com.etc.col_lists;

/*
 * 泛型接口：把泛型定义在接口上
 */
interface Inter<T>{
	public abstract void show(T t);
}

/*
 * 泛型类实现泛型接口
 */
//第一种情况：已经知道该是什么类型的了
/*class InterImpl implements Inter<String> {

	@Override
	public void show(String t) {
		System.out.println(t);
	}
}*/

//第二种情况：还不知道是什么类型的
class InterImpl<T> implements Inter<T>{
	@Override
	public void show(T t) {
		System.out.println(t);
	}
}

// 使用泛型接口
public class Gen_genInterface {
	public static void main(String[] args) {
		// 第一种情况的测试
		// Inter<String> i = new InterImpl();
		// i.show("hello");

		Inter<String> i = new InterImpl<String>();
		i.show("hello");
		Inter<Integer> ii = new InterImpl<Integer>();
		ii.show(100);
	}
}

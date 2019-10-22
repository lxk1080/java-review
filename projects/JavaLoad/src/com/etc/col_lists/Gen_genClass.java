package com.etc.col_lists;
/*
 * 早期的时候，我们使用Object来代表任意的类型。
 * 向上转型是没有任何问题的，但是在向下转型的时候其实隐含了类型转换的问题。
 * 也就是说这样的程序其实并不是安全的。所以Java在JDK5后引入了泛型，提高程序的安全性。
 */
public class Gen_genClass {
	public static void main(String[] args) {
		ObjectTool<String> ot = new ObjectTool<String>();
		// ot.setObj(new Integer(27)); //这个时候编译期间就过不去
		ot.setObj(new String("林青霞"));
		String s = ot.getObj();
		System.out.println("姓名是：" + s);

		ObjectTool<Integer> ot2 = new ObjectTool<Integer>();
		// ot2.setObj(new String("风清扬"));//这个时候编译期间就过不去
		ot2.setObj(new Integer(27));
		Integer i = ot2.getObj();
		System.out.println("年龄是：" + i);
	}
}

/*
 * 泛型类：把泛型定义在类上 （是一个代表数据类型的参数）
 */
class ObjectTool<T> {  
	private T obj;

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}
}

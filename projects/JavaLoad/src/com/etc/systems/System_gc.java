package com.etc.systems;

/*
 * System类包含一些有用的类字段和方法。它不能被实例化。 
 * 
 * 方法：
 * 		public static void gc()：运行垃圾回收器。 
 *		
 */
public class System_gc {
	public static void main(String[] args) {
		Person p = new Person("赵雅芝", 60);
		System.out.println(p);

		p = null; // 让p不再指定堆内存
		System.gc();
	}
}

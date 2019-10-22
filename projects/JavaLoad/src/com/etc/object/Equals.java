package com.etc.object;
/*
 * public boolean equals(Object obj):指示其他某个对象是否与此对象“相等”。 
 * 这个方法，默认情况下比较的是地址值。比较地址值一般来说意义不大，所以我们要重写该方法。
 * 怎么重写呢?
 * 		一般都是用来比较对象的成员变量值是否相同。
 * 重写的代码优化：提高效率，提高程序的健壮性。
 * 最终版：
 * 		其实还是自动生成。
 * 
 * 看源码：
 * 		public boolean equals(Object obj) {
 * 			//this - s1
 * 			//obj - s2
 *       	return (this == obj);
 *   	}
 * 
 * ==:
 * 		基本类型：比较的就是值是否相同
 * 		引用类型：比较的就是地址值是否相同
 * equals:
 * 		只能比较引用类型：默认情况下，比较的是地址值。
 * 		不过，我们可以根据情况自己重写该方法。一般重写都是自动生成，比较对象的成员变量值是否相同
 * 		在String中，equals已经被重写过了，比较的是两个字符串的值是否相同
 * 
 */

class Demo {}

public class Equals {
	public static void main(String[] args) {
		Student s1 = new Student("林青霞", 27);
		Student s2 = new Student("林青霞", 27);
		System.out.println(s1 == s2); //false
  
		System.out.println(s1.equals(s2));  //true  equals方法已经被重写
		System.out.println(s1.equals(s1));  //true
		Student s4 = new Student("风清扬",30);
		System.out.println(s1.equals(s4)); //false
		
		Demo d = new Demo();
		System.out.println(s1.equals(d)); //false
		
	}
}

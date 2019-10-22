package com.etc.object;
/*
 * Object:类 Object 是类层次结构的根类。每个类都使用 Object 作为超类。
 * 每个类都直接或者间接的继承自Object类。
 * 
 * Object类的方法：
 * 		public int hashCode():返回该对象的哈希码值。
 * 			注意：哈希值是根据哈希算法计算出来的一个值，这个值和地址值有关，但是不是实际地址值。
 * 			           你可以理解为地址值。
 */
public class HashCode {
	public static void main(String[] args) {
		Student s = new Student();
		System.out.println(s.hashCode()); 
		
		Student s2 = new Student();
		System.out.println(s2.hashCode());
		
		Student s3 = s;  
		System.out.println(s3.hashCode());
	}
}

package com.etc.integer;

/**
* 十进制到其他进制
* public static String toString(int i,int radix)
* 由这个我们也看到了进制的范围：2-36
* 为什么呢?0,...9,a...z
* 
* 其他进制到十进制
* public static int parseInt(String s,int radix)
* 
*/
	
public class SysConvertion {
	public static void main(String[] args) {
		// 十进制到其他进制
		System.out.println(Integer.toString(100, 10));
		System.out.println(Integer.toString(100, 2));
		System.out.println(Integer.toString(100, 8));
		System.out.println(Integer.toString(100, 16));
		System.out.println(Integer.toString(100, 5));
		System.out.println(Integer.toString(100, 7));
		

		//其他进制到十进制
		System.out.println(Integer.parseInt("100", 10));  //十进制
		System.out.println(Integer.parseInt("100", 2));  //二进制
		System.out.println(Integer.parseInt("100", 8));  //八进制的100
	}
}

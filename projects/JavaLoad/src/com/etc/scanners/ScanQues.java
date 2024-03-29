package com.etc.scanners;

import java.util.Scanner;

/*
 * 常用的两个方法：
 * 		public int nextInt():获取一个int类型的值
 * 		public String nextLine():获取一个String类型的值
 * 
 * 出现问题了：
 * 		先获取一个数值，在获取一个字符串，会出现问题。
 * 		主要原因：就是那个换行符号（/r/n）的问题。
 * 如何解决呢?
 * 		A:先获取一个数值后，在创建一个新的键盘录入对象获取字符串。
 * 		B:把所有的数据都先按照字符串获取，然后要什么，你就对应的转换为什么。
 */
public class ScanQues {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 先获取一个int值，在获取一个字符串
		// int a = sc.nextInt();
		// String s2 = sc.nextLine();
		// System.out.println("a:" + a + ",s2:" + s2);
		// System.out.println("-------------------");
		
		int a = sc.nextInt();
		Scanner sc2 = new Scanner(System.in);
		String s = sc2.nextLine();
		System.out.println("a:" + a + ",s:" + s);
	}
}

package com.etc.scanners;

import java.util.Scanner;
/*
 * Scanner:用于接收键盘录入数据。
 * 
 * System类下有一个静态的字段：
 * 		public static final InputStream in; 标准的输入流，对应着键盘录入。
 * 
 * 		InputStream is = System.in;  //System类调用成员变量in
 * 
 * class Demo {
 * 		public static final int x = 10;
 * 		public static final Student s = new Student();
 * }
 * int y = Demo.x;
 * Student s = Demo.s;
 * 
 * 构造方法：
 * 		Scanner(InputStream source)
 */
public class Scan {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		
		System.out.println("x:" + x);
	}	
}

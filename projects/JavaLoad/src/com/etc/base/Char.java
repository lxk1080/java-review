package com.etc.base;
/*
通过字符和一个整数相加，我们给出一张表：ASCII码表。
	通过看完这张表以后，我们要记住三个值：
		'a'		97
		'A'		65
		'0'		48
*/
public class Char {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//直接输出一个字符
		System.out.println('a'); //a
		//输出一个字符和一个整数做加法
		System.out.println('a'+1); //98
		
		System.out.println("hello"+'a'+1); //helloa1
		System.out.println('a'+1+"hello"); //98hello
		
		System.out.println("5+5="+5+5); //5+5=55
		System.out.println(5+5+"=5+5"); //10=5+5
	}

}

package com.etc.stringBuffer;

public class StringReverse {
	// 反转字符串
	// 用StringBuffer的reverse()功能
	public static String myReverse(String s) {
		return new StringBuffer(s).reverse().toString();
	}
	
	// 判断是否是对称字符串
	public static boolean myduichen(String s) {
		return new StringBuffer(s).reverse().toString().equals(s);
	}
	
	public static void main(String[] args) {
		String s = "abc";
		s = myReverse(s);
		System.out.println(s);
		
		String s2 = "abcba";
		Boolean b = myduichen(s2);
		System.out.println(b);
	}
}

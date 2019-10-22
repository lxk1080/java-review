package com.etc.strings;

/*
 * String类的判断功能：
 * boolean equals(Object obj):
 * 				比较字符串的内容是否相同,区分大小写
 * boolean equalsIgnoreCase(String str):
 * 				比较字符串的内容是否相同,忽略大小写
 * boolean contains(String str):
 * 				判断大字符串中是否包含小字符串
 * boolean startsWith(String str):
 * 				判断字符串是否以某个指定的字符串开头
 * boolean endsWith(String str):
 * 				判断字符串是否以某个指定的字符串结尾
 * boolean isEmpty():
 * 				判断字符串是否为空（不是对象为空）。
 * 
 * 注意：
 * 		字符串内容为空和字符串对象为空。
 * 		String s = "";
 * 		String s = null;
 */
public class StringPanDuan {
	public static void main(String[] args) {
		// boolean isEmpty():判断字符串是否为空。
		String s4 = "";
		String s5 = null;
		System.out.println("isEmpty:" + s4.isEmpty());
		// NullPointerException
		// s5对象都不存在，所以不能调用方法，空指针异常
		System.out.println("isEmpty:" + s5.isEmpty());
	}
}

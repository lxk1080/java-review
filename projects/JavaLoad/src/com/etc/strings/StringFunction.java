package com.etc.strings;
/*
 * String类的获取功能:
 * 
 * int length():	
 * 			获取字符串的长度。
 * char charAt(int index):	
 * 			获取指定索引位置的字符
 * int indexOf(int ch):	
 * 			返回指定字符在此字符串中第一次出现处的索引。
 * 				为什么这里是int类型，而不是char类型?
 * 				原因是：'a'和97其实都可以代表'a'，int类型的范围比char类型的范围大，输入char类型的值int能接收，反之不然
 * int indexOf(String str):	
 * 			返回指定字符串在此字符串中第一次出现处的索引。
 * int indexOf(int ch,int fromIndex):	
 * 			返回指定字符在此字符串中从指定位置后第一次出现处的索引。
 * int indexOf(String str,int fromIndex):	
 * 			返回指定字符串在此字符串中从指定位置后第一次出现处的索引。
 * String substring(int start):	
 * 			从指定位置开始截取字符串,默认到末尾。
 * String substring(int start,int end):	
 * 			从指定位置开始到指定位置之前一位结束截取字符串。（左闭右开）
 * 
 * String的转换功能：
 * 
 * byte[] getBytes():
 * 			把字符串转换为字节数组。
 * char[] toCharArray():
 * 			把字符串转换为字符数组。
 * static String valueOf(char[] chs):
 * 			把字符数组转成字符串。
 * static String valueOf(int i):
 * 			把int类型的数据转成字符串。
 * 				注意：String类的valueOf方法可以把任意类型的数据转成字符串。
 * String toLowerCase():
 * 			把字符串转成小写。
 * String toUpperCase():
 * 			把字符串转成大写。
 * String concat(String str):
 * 			把字符串拼接。
 */

public class StringFunction {
	public static void main(String[] args) {

	}
}

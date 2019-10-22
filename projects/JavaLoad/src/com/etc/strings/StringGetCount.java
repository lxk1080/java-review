package com.etc.strings;

/*
 * 统计大串中小串出现的次数
 * 
 * 分析：
 * 		前提：是已经知道了大串和小串。
 * 
 * 		A:定义一个统计变量，初始化值是0
 * 		B:先在大串中查找一次小串第一次出现的位置
 * 			a:索引是-1，说明不存在了，就返回统计变量
 * 			b:索引不是-1，说明存在，统计变量++
 * 		C:把刚才的索引+小串的长度作为开始位置截取上一次的大串，返回一个新的字符串，并把该字符串的值重新赋值给大串
 * 		D:回到B
 */
public class StringGetCount {
	public static int getCount(String maxString, String minString) {
		// 定义一个统计变量，初始化值是0
		int count = 0;
		int index;
		//先查，赋值，判断
		while((index=maxString.indexOf(minString))!=-1){  //在大串中查找第一个
			count++;
			maxString = maxString.substring(index + minString.length());  //截取后面的字符串为大串
		}
		return count;
	}
	
	public static void main(String[] args) {
		String a = "dfajavagddjavadfgdgdgjava";
		String b = "java";
		
		int c = getCount(a, b);
		System.out.println(c);
	}
}

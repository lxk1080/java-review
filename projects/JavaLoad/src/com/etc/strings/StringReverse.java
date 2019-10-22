package com.etc.strings;
/**
 * 遍历字符串
 * A: charAt()
 * B: toCharArray()
 *
 */
public class StringReverse {
	//反转数组
	public static String myReverse(String str){
		char[] chs = str.toCharArray();
		String result = "";
		for(int i = chs.length-1; i >= 0 ; i-- ){
			result += chs[i];
		}
		return result;
	}
	
	public static void main(String[] args) {
		String str = "abcde";
		String res = myReverse(str);
		System.out.println(res);
	}
}

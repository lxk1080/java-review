package com.etc.marray;

import java.util.Arrays;

public class ArrayTool {
	public static void main(String[] args) {
		int[] a = {25,32,75,15,63};
		Arrays.sort(a);  //排序
		String s = Arrays.toString(a); //转为字符串
		System.out.println(s);  
		
		System.out.println("index:"+Arrays.binarySearch(a, 25)); //二分查找
	}
}

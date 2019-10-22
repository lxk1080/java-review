package com.etc.systems;

import java.util.Arrays;

/*
 * System类包含一些有用的类字段和方法。它不能被实例化。 
 * 
 * 方法：
 *		public static void arraycopy(Object src,int srcPos,Object dest,int destPos,int length)
 *			从指定源数组中复制一个数组，复制从指定的位置开始，到目标数组的指定位置结束。
 */
public class System_arraycopy {
	public static void main(String[] args) {
		// 定义数组
		int[] arr = { 11, 22, 33, 44, 55 };
		int[] arr2 = { 6, 7, 8, 9, 10 };

		// 请大家看这个代码的意思
		System.arraycopy(arr, 1, arr2, 2, 2);

		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(arr2));
	}
}

package com.etc.marray;

public class ArrayTwo {
	public static void main(String[] args) {
		int[][] arr1 = new int[3][2];  //固定长度
		
		int[][] arr2 = new int[3][];
		arr2[0] = new int[2];
		arr2[1] = new int[3];
		arr2[2] = new int[5];
		
		int[][] arr3 = {{1,2},{4,3},{3,5}};
	}
}

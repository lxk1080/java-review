package com.etc.marray;

public class ArrayTwoBianLi {
	//遍历二维数组
	public static void bianli(int[][] arr){
		for(int x = 0; x < arr.length; x++){
			for(int y = 0; y < arr[x].length; y++){
				System.out.print(arr[x][y]+" ");
			}
		}
	}
	//杨辉三角
	public static void getYanghui(int num){
		int[][] arr = new int[num][num];
		//每一行第一列和最后一列都是1
		for(int x = 0; x < arr.length; x++){
			arr[x][0] = 1;
			arr[x][x] = 1;
		}
		//从第三行开始，每一行的第二个元素和倒数第二个元素符合一个规律
		for(int x = 2; x < arr.length; x++){
			for(int y = 1; y <= x-1; y++){
				arr[x][y] = arr[x-1][y-1] + arr[x-1][y];
			 }
		}
		//输出这个数组
		for(int x = 0; x < arr.length; x++){
			for(int y = 0; y <= x; y++){
				System.out.print(arr[x][y]+"\t");  // "\t"等宽
			}
			System.out.println();
		}
		
	}
	public static void main(String[] args) {
		
		int[][] arr = {{1,2,3},{4,5,6}};
		bianli(arr);
		System.out.println();
		
		getYanghui(6);
	}
}

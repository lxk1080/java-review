package com.etc.marray;

public class ArrayMax {
	//获取数组最大
	public static int getMaxValue(int[] arr){
		int max = arr[0];
		for(int i = 0; i < arr.length; i++){
			if(arr[i] > max){
				max = arr[i];
			}
		}
		return max;
	}
	//获取数组最小
	public static int getMinValue(int[] arr){
		int min = arr[0];
		for(int i = 0; i < arr.length; i++){
			if(arr[i] < min){
				min = arr[i];
			}
		}
		return min;
	}
	//获取逆序数组b
	public static int[] reverse(int[] arr){
		for(int start = 0,end = arr.length-1; start <= end; start++,end--){
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
		}
		return arr;
	}
	//查找数字在数组中的位置
	public static int getIndex(int[] arr,int value){
		for(int i = 0; i < arr.length; i++){
			if(arr[i] == value){
				return i;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] num = {12,63,53,14,32};
		
		int max = getMaxValue(num);
		System.out.println(max);
		
		int[] rev = reverse(num);
		for(int x = 0; x < rev.length; x++){
			System.out.print(rev[x]+" ");
		}
		
		System.out.println("");
		
		int index = getIndex(num,53);
		System.out.println(index);
	}
}

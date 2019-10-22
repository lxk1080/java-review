package com.etc.marray;

public class Sort {
	//冒泡排序 （相邻元素两两比较，大的往后放，第一次完毕，最大值出现在了最大索引处）
	private static void bubbleSort(int[] arr) {
		for(int x = 0; x < arr.length-1; x++){
			for(int y = 0; y < arr.length-x-1; y++){
				if(arr[y] > arr[y+1]){
					int tmp = arr[y+1];
					arr[y+1] = arr[y];
					arr[y] = tmp;
				}
			}
		}
	}
	
	//选择排序（从0索引开始，依次和后面元素比较，小的往前放，第一次完毕，最小值出现在了最小索引处）
	private static void selectSort(int[] arr) {
		for(int x = 0; x < arr.length-1; x++){
			for(int y = x+1; y < arr.length; y++){
				if(arr[y] < arr[x]){
					int tmp = arr[x];
					arr[x] = arr[y];
					arr[y] = tmp;
				} 
			}
		}
	}
	
	//二分查找（数组元素有序）
	public static int getIndex(int[] arr,int value){
		//定义最大索引，最小索引
		int max = arr.length -1;
		int min = 0;
		//计算出中间索引
		int mid = (max +min)/2;
		//拿中间索引的值和要查找的值进行比较
		while(arr[mid] != value){
			if(arr[mid]>value){
				max = mid - 1;
			}else if(arr[mid]<value){
				min = mid + 1;
			}
			if(min > max){  //如果找不到
				return -1;
			}
			mid = (max +min)/2;
		}
		return mid;
	}
	
	
	public static void main(String[] args) {
		int[] a = {1,8,31,6,9,58,14,3,60};
		//bubbleSort(a);
		selectSort(a);
		for(int x = 0; x < a.length; x++){
			System.out.print(a[x]+" ");
		}
		
		int n = getIndex(a,31);
		System.out.println("index:"+n); //这里是排序后的索引
	}
}

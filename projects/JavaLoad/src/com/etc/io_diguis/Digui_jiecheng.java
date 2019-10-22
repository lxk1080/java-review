package com.etc.io_diguis;
/*
 * 需求：请用代码实现求5的阶乘。
 * 下面的知识要知道：
 * 		5! = 1*2*3*4*5
 * 		5! = 5*4!
 * 
 * 有几种方案实现呢?
 * 		A:循环实现
 * 		B:递归实现
 * 			a:做递归要写一个方法
 * 			b:出口条件
 * 			c:规律
 */
public class Digui_jiecheng {
	//循环
	private static int xunhuan(int n) {
		int sum = 1;
		for(int x = 2; x <= n; x++){
			sum = sum * x;
		}
		return sum;
	}

	/*
	 * 做递归要写一个方法:
	 * 		返回值类型：int
	 * 		参数列表：int n
	 * 出口条件:
	 * 		if(n == 1) {return 1;}
	 * 规律:
	 * 		if(n != 1) {return n*方法名(n-1);}
	 */
	//递归
	private static int getJiecheng(int n) {
		if(n == 1){
			return 1;
		} else {
			return n * getJiecheng(--n);
		}
	}
	
	public static void main(String[] args) {
		int s1 = xunhuan(5);
		System.out.println("循环："+s1);
		int s2 = getJiecheng(5);
		System.out.println("递归："+s2);	
	}
}

package com.etc.maths;

// 获取随机范围之间的随机数
// Math.random(): [0.0 , 1.0)

public class MathTest {
	public static int getRandom(int start, int end){
		if(start > end){
			return -1;
		}
		int sub = end - start + 1;
		int res = (int)(Math.random()*sub+start);
		return res;
	}
	
	public static void main(String[] args) {
		for(int i = 0; i < 50; i++){
			int ii = MathTest.getRandom(25, 48);
			System.out.println(ii);
		}
	}
}

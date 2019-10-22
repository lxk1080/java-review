package com.etc.base;
/*
<<:左移	左边最高位丢弃，右边补齐0
>>:右移	最高位是0，左边补齐0；最高为是1，左边补齐1
>>>:无符号右移 无论最高位是0还是1，左边补齐0

面试题：
	请用最有效率的方式写出计算2乘以8的结果?
		2 * 8
		
		2 << 3

*/
public class OperatorBit2 {
	public static void main(String[] args) {
		//<< 把<<左边的数据乘以2的移动次幂
				System.out.println(3 << 2); //3*2^2 = 3*4 = 12;
			
				//>> 把>>左边的数据除以2的移动次幂
				System.out.println(24 >> 2); //24 / 2^2 = 24 / 4 = 6
	}
}

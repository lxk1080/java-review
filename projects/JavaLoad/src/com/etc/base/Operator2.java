package com.etc.base;
/*
面试题：
	short s=1;s = s+1; 
	short s=1;s+=1;
	上面两个代码有没有问题，如果有，那里有问题。
	
	为什么第二个木有问题呢?
		扩展的赋值运算符其实隐含了一个强制类型转换。
		
		s += 1;
		不是等价于 s = s + 1;
		而是等价于 s = (s的数据类型)(s + 1);
*/
public class Operator2 {
		public static void main(String[] args) {
			//short s = 1;
			//s = s + 1;
			//System.out.println(s);
			
			short s = 1;
			s += 1; //好像是 s = s + 1; 事实上是  s = (short)(s+1);
			System.out.println(s);
		}
}

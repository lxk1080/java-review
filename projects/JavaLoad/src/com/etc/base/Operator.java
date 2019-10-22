package com.etc.base;
/*	
分类：算术运算符，赋值运算符，比较运算符，逻辑运算符，位运算符，三目运算符

算术运算符：
	+,-,*,/,%,++,--
	
注意事项：
	A:整数相除只能得到整数。如果想得到小数，必须把数据变化为浮点数类型
	B:/获取的是除法操作的商，%获取的是除法操作的余数
*/
public class Operator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 3;  
		int y = 4;
		
		System.out.println(x/y);  //0
		System.out.println(x*1.0/y);  //0.75
		System.out.println(x%y); //3
	}

}

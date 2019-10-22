package com.etc.base;
/*
在运算的时候，要求参与运算的数据类型必须一致。

注意：
	boolean类型不能转换为其他的数据类型

默认转换(从小到大的转换)
	A:byte,short,char—int—long—float—double
	B:byte,short,char相互之间不转换，他们参与运算首先转换为int类型
*/
public class DataTypeConvert {

	public static void main(String[] args) {
		byte x = 3;
		int y = 4;
		
	//	byte c = x + y;  //可能会损失精度
		
		byte c1 = (byte) (x + y);
		int c2 = x + y;
	}

}

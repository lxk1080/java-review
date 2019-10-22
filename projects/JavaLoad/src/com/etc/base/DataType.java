package com.etc.base;
		/*
		基本数据类型:4类8种
		A:整数			占用字节数
			byte			1
			short			2
			int				4
			long			8
			
		B:浮点数
			float 			4
			double 			8
			
		C:字符
			char			2
		D:布尔
			boolean			1
		
		注意：
			整数默认是int类型
			浮点数默认是double类型。
			
			长整型后缀用L或者l标记。建议使用L。
			单精度浮点数用F或者f标记。建议使用F。
		*/
public class DataType {
	public static void main(String[] args) {
		
		long j = 1000000000000L;
		
		float f = 12.345F;
		
		char ch = 'a';
		
		boolean flag = true;
		
	}
}

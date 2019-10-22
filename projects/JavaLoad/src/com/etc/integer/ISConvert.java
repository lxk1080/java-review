package com.etc.integer;
/*
 * int类型和String类型的相互转换
 * 
 * int -- String
 * 		String.valueOf(number)
 * 
 * String -- int
 * 		Integer.parseInt(s)
 */
public class ISConvert {
	public static void main(String[] args) {
		// int -- String
				int number = 100;
				// 方式1
				String s1 = "" + number;

				// 方式2
				String s2 = String.valueOf(number);

				// 方式3
				// int -- Integer -- String
				Integer i = new Integer(number);
				String s3 = i.toString();

				// 方式4
				// public static String toString(int i)
				String s4 = Integer.toString(number);

				System.out.println("-----------------");

				// String -- int
				String s = "100";
				// 方式1
				Integer ii = new Integer(s);
				int x = ii.intValue();

				//方式2
				int y = Integer.parseInt(s);

	}
}

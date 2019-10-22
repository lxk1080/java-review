package com.etc.integer;

import java.math.BigInteger;

/*
 * BigInteger:可以让超过Integer范围内的数据进行运算
 * 
 * 构造方法：
 * BigInteger(String val) 
 * 
 * public BigInteger add(BigInteger val):加
 * public BigInteger subtract(BigInteger val):减
 * public BigInteger multiply(BigInteger val):乘
 * public BigInteger divide(BigInteger val):除
 * public BigInteger[] divideAndRemainder(BigInteger val):返回商和余数的数组
 * 
 */
public class BigIntegerD {
	public static void main(String[] args) {
		// 这几个测试，是为了简单测试超过int范围内，Integer就不能再表示，所以就更谈不上计算了。
		// System.out.println(Integer.MAX_VALUE);  //2147483647
		// Integer i = new Integer("2147483648");  //超出范围
		
		// 通过大整数来创建对象
		BigInteger bi = new BigInteger("2147483648");
		System.out.println("bi:" + bi);
		
		BigInteger bi1 = new BigInteger("100");
		BigInteger bi2 = new BigInteger("50");


		System.out.println("add:" + bi1.add(bi2));
		System.out.println("subtract:" + bi1.subtract(bi2));
		System.out.println("multiply:" + bi1.multiply(bi2));
		System.out.println("divide:" + bi1.divide(bi2));

		// public BigInteger[] divideAndRemainder(BigInteger val):返回商和余数的数组
		BigInteger[] bis = bi1.divideAndRemainder(bi2);
		System.out.println("商：" + bis[0]);
		System.out.println("余数：" + bis[1]);
	}
}
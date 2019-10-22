package com.etc.base;

import java.util.Scanner;

/*	
格式的解释：
	switch:表示这是switch选择结构
	表达式:这个地方的取值是有限定的
		byte,short,int,char
		JDK5以后可以是枚举
		JDK7以后可以是字符串

面试题：
	byte可以作为switch的表达式吗?  可以
	long可以作为switch的表达式吗?  不可以
	String可以作为switch的表达式吗?  JDK7以后可以

switch语句的注意事项：
		A:case后面只能是常量，不能是变量，而且，多个case后面的值不能出现相同的
		B:default可以省略吗?
			可以省略，但是不建议，因为它的作用是对不正确的情况给出提示。
			特殊情况：
				case就可以把值固定。
				A,B,C,D
		C:break可以省略吗?
			可以省略，但是结果可能不是我们想要的。
			会出现一个现象：case穿透。
			最终我们建议不要省略
		D:default一定要在最后吗?
			不是，可以在任意位置。但是建议在最后。
		E:switch语句的结束条件
			a:遇到break就结束了
			b:执行到末尾就结束了
		
*/
public class Switch {
	public static void main(String[] args) {
		//创建键盘录入对象
		Scanner sc = new Scanner(System.in);
		
		//录入数据
		System.out.println("请输入月份(1-12)：");
		int month = sc.nextInt();
		//String s = sc.nextLine();
		
		switch(month) {
			case 1:
			case 2:
			case 12:
				System.out.println("冬季");
				break;
			case 3:
			case 4:
			case 5:
				System.out.println("春季");
				break;
			case 6:
			case 7:
			case 8:
				System.out.println("夏季");
				break;
			case 9:
			case 10:
			case 11:
				System.out.println("秋季");
				break;
			default:
				System.out.println("你输入的月份有误");
		}
	}
}

package com.etc.duixiang;

import java.util.Scanner;

/*
变量什么时候定义为成员变量：
	如果这个变量是用来描述这个类的信息的，那么，该变量就应该定义为成员变量。
	
变量到底定义在哪里好呢?
	变量的范围是越小越好。因为能及时的被回收。
	
定义一个长方形类,定义 求周长和面积的方法，

长方形的类：
	成员变量：
		长，宽
	成员方法：
		求周长：(长+宽)*2;
		求面积：长*宽		
注意：
	import必须出现在所有的class前面。
*/
public class ChangFangXing {
	//长方形的长
	private int width;
	//长方形的宽
	private int height;
	
	//无参构造还函数
	public ChangFangXing(){}
	
	//仅仅提供setXxx()即可
	public void setLength(int length) {
		this.width = length;
	}
	public void setWidth(int width) {
		this.height = width;
	}
	
	//求周长
	public int getZhouChang() {
		return (width + height) * 2;
	}
	//求面积
	public int getArea() {
		return width * height;
	}
	
	public static void main(String[] args) {
		//创建键盘录入对象
		Scanner sc = new Scanner(System.in);
		
		System.out.println("请输入长方形的宽：");
		int width = sc.nextInt();
		System.out.println("请输入长方形的高：");
		int height = sc.nextInt();
		
		//创建对象
		ChangFangXing cfx = new ChangFangXing();
		//先给成员变量赋值
		cfx.setLength(width);
		cfx.setWidth(height);
		
		System.out.println("周长是："+cfx.getZhouChang());
		System.out.println("面积是："+cfx.getArea());
		
	}

}

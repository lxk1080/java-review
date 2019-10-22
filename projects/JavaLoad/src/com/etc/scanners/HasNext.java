package com.etc.scanners;

import java.util.Scanner;

public class HasNext {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		if(sc.hasNextInt()){  //如果下一个输入项是int类型的
			int i = sc.nextInt();  //则用 i 来接收此值
			System.out.println("I:" + i );
		} else {
			System.out.println("输入的代码有误");
		}
	}
}

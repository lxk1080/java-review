package com.etc.io_exceptions;

import java.util.Scanner;

public class Student {
	public void check(int score) throws MyException{ //2.方法抛出异常给调用者
		if (score > 100 || score < 0) {
			throw new MyException("分数必须在0-100之间");  //1.抛出自定义异常到方法中
		} else {
			System.out.println("分数没有问题");
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入学生成绩：");
		int score = sc.nextInt();

		Student t = new Student();
		try {
			t.check(score);  //3.调用者处理异常
		} catch (MyException e) {
			e.printStackTrace();
		}
	}
}

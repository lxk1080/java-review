package com.etc.threads2;
/*
 * 最终版代码中：
 * 		把Student的成员变量给私有的了。
 * 		把设置和获取的操作给封装成了功能，并加了同步。
 * 		设置或者获取的线程里面只需要调用方法即可。
 */
public class Th_SetAndGetImprove {
	public static void main(String[] args) {
		//创建资源
		Student2 s = new Student2(); //操作同一个资源
		
		//设置和获取的类
		SetThread2 st = new SetThread2(s);
		GetThread2 gt = new GetThread2(s);

		//线程类
		Thread t1 = new Thread(st);
		Thread t2 = new Thread(gt);

		//启动线程
		t1.start();
		t2.start();
	}
}

class SetThread2 implements Runnable {

	private Student2 s;
	private int x = 0;

	public SetThread2(Student2 s) {
		this.s = s;
	}

	@Override
	public void run() {
		while (true) {
			if (x % 2 == 0) {
				s.set("林青霞", 27);
			} else {
				s.set("刘意", 30);
			}
			x++;
		}
	}
}

class GetThread2 implements Runnable {
	private Student2 s;

	public GetThread2(Student2 s) {
		this.s = s;
	}

	@Override
	public void run() {
		while (true) {
			s.get();
		}
	}
}

class Student2 {
	private String name;
	private int age;
	private boolean flag; // 默认情况是没有数据，如果是true，说明有数据

	public synchronized void set(String name, int age) {
		// 如果有数据，就等待
		if (this.flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// 设置数据
		this.name = name;
		this.age = age;

		// 修改标记
		this.flag = true;
		this.notify();
	}

	public synchronized void get() {
		// 如果没有数据，就等待
		if (!this.flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// 获取数据
		System.out.println(this.name + "---" + this.age);

		// 修改标记
		this.flag = false;
		this.notify();
	}
}


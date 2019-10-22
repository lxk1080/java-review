package com.etc.threads;
/*
 * 某电影院目前正在上映贺岁大片(红高粱,少林寺传奇藏经阁)，共有100张票，而它有3个售票窗口售票，请设计一个程序模拟该电影院售票。
 * 继承Thread类来实现。
 */
public class SellTickets {
	public static void main(String[] args) {
		// 创建三个线程对象
		SellTicket st1 = new SellTicket();
		SellTicket st2 = new SellTicket();
		SellTicket st3 = new SellTicket();

		// 给线程对象起名字
		st1.setName("窗口1");
		st2.setName("窗口2");
		st3.setName("窗口3");

		// 启动线程
		st1.start();
		st2.start();
		st3.start();
	}
}

class SellTicket extends Thread {

	// 定义100张票
	// private int tickets = 100;
	// 为了让多个线程对象共享这100张票，我们其实应该用静态修饰
	private static int tickets = 100;

	@Override
	public void run() {
		// 定义100张票
		// 每个线程进来都会走这里，这样的话，每个线程对象相当于买的是自己的那100张票，这不合理，所以应该定义到外面
		// int tickets = 100;

		// 是为了模拟一直有票
		while (true) {
			if (tickets > 0) {
				System.out.println(getName() + "正在出售第" + (tickets--) + "张票");
			}
		}
	}
}


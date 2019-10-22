package com.etc.threads;
/*
 * 实现Runnable接口的方式实现
 */
public class SellTickets2 {
	public static void main(String[] args) {
		// 创建资源对象
		SellTicket2 st = new SellTicket2();

		// 创建三个线程对象
		Thread t1 = new Thread(st, "窗口1");
		Thread t2 = new Thread(st, "窗口2");
		Thread t3 = new Thread(st, "窗口3");

		// 启动线程
		t1.start();
		t2.start();
		t3.start();
	}
}

class SellTicket2 implements Runnable {
	// 定义100张票
	private int tickets = 100;

	@Override
	public void run() {
		while (true) {
			if (tickets > 0) {
				System.out.println(Thread.currentThread().getName() + "正在出售第" + (tickets--) + "张票");
			}
		}
	}
}
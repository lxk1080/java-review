package com.etc.threads;

import java.util.Date;

/*
 * 线程休眠
 *		public static void sleep(long millis)
 */
public class Thread_sleep {
	public static void main(String[] args) {
		ThreadSleep ts1 = new ThreadSleep();
		ThreadSleep ts2 = new ThreadSleep();
		ThreadSleep ts3 = new ThreadSleep();

		ts1.setName("林青霞");
		ts2.setName("林志玲");
		ts3.setName("林志颖");

		ts1.start();
		ts2.start();
		ts3.start();
	}
}

class ThreadSleep extends Thread {
	@Override
	public void run() {
		for (int x = 0; x < 100; x++) {
			System.out.println(getName() + ":" + x + ",日期：" + new Date());
			// 睡眠
			// 困了，我稍微休息1秒钟
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

package com.etc.threads;
/*
 * 如何解决线程安全问题呢?
 * 
 * 要想解决问题，就要知道哪些原因会导致出问题:(而且这些原因也是以后我们判断一个程序是否会有线程安全问题的标准)
 * A:是否是多线程环境
 * B:是否有共享数据
 * C:是否有多条语句操作共享数据
 * 
 * 我们来回想一下我们的程序有没有上面的问题呢?
 * A:是否是多线程环境	是
 * B:是否有共享数据	是
 * C:是否有多条语句操作共享数据	是
 * 
 * 由此可见我们的程序出现问题是正常的，因为它满足出问题的条件。
 * 接下来才是我们要想想如何解决问题呢?
 * A和B的问题我们改变不了，我们只能想办法去把C改变一下。
 * 思想：
 * 		把多条语句操作共享数据的代码给包成一个整体，让某个线程在执行的时候，别人不能来执行。
 * 问题是我们不知道怎么包啊?其实我也不知道，但是Java给我们提供了：同步机制。
 * 
 * 同步代码块：
 * 		synchronized(对象){
 * 			需要同步的代码;
 * 		}
 * 
 * 		A:对象是什么呢?
 * 			我们可以随便创建一个对象试试。
 * 		B:需要同步的代码是哪些呢?
 * 			把多条语句操作共享数据的代码的部分给包起来
 * 
 * 		注意：
 * 			同步可以解决安全问题的根本原因就在那个对象上。该对象如同锁的功能。
 * 			多个线程必须是同一把锁。
 * 
 * 
 * 举例：
 * 		寝室卫生间。
 * 
 * 同步的特点：
 * 		前提：
 * 			多个线程
 *		解决问题的时候要注意：
 *			多个线程使用的是同一个锁对象
 * 同步的好处 
 *		同步的出现解决了多线程的安全问题。
 * 同步的弊端
 *		当线程相当多时，因为每个线程都会去判断同步上的锁，这是很耗费资源的，无形中会降低程序的运行效率。
 */
public class SellTickets4_synchronized {
	public static void main(String[] args) {
		// 创建资源对象
		SellTicket4 st = new SellTicket4();

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

class SellTicket4 implements Runnable {

	// 定义100张票
	private int tickets = 100;

	// 定义同一把锁
	private Object obj = new Object();

	@Override
	public void run() {
		while (true) {
			// t1,t2,t3都能走到这里
			// 假设t1抢到CPU的执行权，t1就要进来
			// 假设t2抢到CPU的执行权，t2就要进来,发现门是关着的，进不去。所以就等着。
			// 门(开,关)
			synchronized (obj) { // 发现这里的代码将来是会被锁上的，所以t1进来后，就锁了。(关)
				if (tickets > 0) {
					try {
						Thread.sleep(100); // t1就睡眠了
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()
							+ "正在出售第" + (tickets--) + "张票 ");
					//窗口1正在出售第100张票
				}
			} //t1就出来可，然后就开门。(开)
		}
	}
}



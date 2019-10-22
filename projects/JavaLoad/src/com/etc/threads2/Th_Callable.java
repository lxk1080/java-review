package com.etc.threads2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
 * 多线程实现的方式3： （必须配合线程池使用）
 *  	A:创建一个线程池对象，控制要创建几个线程对象。
 * 			public static ExecutorService newFixedThreadPool(int nThreads)
 * 		B:这种线程池的线程可以执行：
 * 			可以执行Runnable对象或者Callable对象代表的线程
 * 			做一个类实现Runnable接口。
 * 		C:调用如下方法即可
 * 			Future<?> submit(Runnable task)
 *			<T> Future<T> submit(Callable<T> task)
 *		D:我就要结束，可以吗?
 *			可以。
 */
public class Th_Callable {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// 创建线程池对象
		ExecutorService pool = Executors.newFixedThreadPool(2);

		// 可以执行Runnable对象或者Callable对象代表的线程
		Future<Integer> f1 = pool.submit(new MyCallable(100));
		Future<Integer> f2 = pool.submit(new MyCallable(200));

		// V get()
		Integer i1 = f1.get();
		Integer i2 = f2.get();

		System.out.println(i1);
		System.out.println(i2);

		// 结束
		pool.shutdown();
	}
}

//Callable:是带泛型的接口。
//这里指定的泛型其实是call()方法的返回值类型。
class MyCallable implements Callable<Integer> {

	private int number;

	public MyCallable(int number) {
		this.number = number;
	}

	@Override
	public Integer call() throws Exception {
		int sum = 0;
		for (int x = 1; x <= number; x++) {
			sum += x;
		}
		return sum;
	}

}



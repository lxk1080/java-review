package com.etc.threads2;

import java.util.Timer;
import java.util.TimerTask;
/*
 * 定时器：可以让我们在指定的时间做某件事情，还可以重复的做某件事情。
 * 依赖Timer和TimerTask这两个类：
 * Timer:定时
 * 		public Timer()
 * 		public void schedule(TimerTask task,long delay)
 * 		public void schedule(TimerTask task,long delay,long period)
 * 		public void cancel()
 * TimerTask:任务
 */
public class Th_Timer {
	public static void main(String[] args) {
		Timer t = new Timer();
		t.schedule(new Task(t), 3000, 2000); //定时器调度任务，3s后开始，以后每隔2s执行一次
	}
}

class Task extends TimerTask {
	private Timer t;

	public Task() {

	}

	public Task(Timer t) {
		this.t = t;
	}

	@Override
	public void run() {
		System.out.println("sss");
		//t.cancel(); // 关闭定时器，由于TimerTask是一个单独的线程，所以要在这个线程里停止
	}

}

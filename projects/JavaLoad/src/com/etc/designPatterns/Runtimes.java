package com.etc.designPatterns;

import java.io.IOException;

/*
 * Runtime:每个 Java 应用程序都有一个 Runtime 类实例，使应用程序能够与其运行的环境相连接。
 * exec(String command) 可以调用Dos命令
 */
public class Runtimes {
	public static void main(String[] args) throws IOException {
		Runtime r = Runtime.getRuntime();
		r.exec("notepad");
//		r.exec("calc");
//		r.exec("shutdown -s -t 10000"); //10000毫秒后关机
//		r.exec("shutdown -a"); //取消关机
	}
}

/*
 * class Runtime {  //Runtime类就是单例模式的体现
 * 		private Runtime() {}
 * 		private static Runtime currentRuntime = new Runtime();
 * 		public static Runtime getRuntime() {
 *       	return currentRuntime;
 *   	}
 * }
 */
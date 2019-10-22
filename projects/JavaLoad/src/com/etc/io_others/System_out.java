package com.etc.io_others;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/*
 * 标准输入输出流
 * System类中的两个成员变量：
 *		public static final InputStream in “标准”输入流。
 * 		public static final PrintStream out “标准”输出流。
 * 
 * 		InputStream is = System.in;
 * 		PrintStream ps = System.out;
 */
public class System_out {
	public static void main(String[] args) throws IOException {
		// 获取标准输入流
		// // PrintStream ps = System.out;
		// // OutputStream os = ps;
		// OutputStream os = System.out; // 多态
		// // 我能不能按照刚才使用标准输入流的方式一样把数据输出到控制台呢?
		// OutputStreamWriter osw = new OutputStreamWriter(os);
		// BufferedWriter bw = new BufferedWriter(osw);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		bw.write("hello");
		bw.newLine();
		bw.write("world");
		bw.newLine();
		bw.write("java");
		bw.newLine();
		bw.flush();
		
		bw.close();
	}
}

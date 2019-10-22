package com.etc.io_others;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


/*
 * 打印流
 * 字节流打印流	PrintStream
 * 字符打印流	PrintWriter
 * 
 * 打印流的特点：
 * 		A:只有写数据的，没有读取数据。只能操作目的地，不能操作数据源。
 * 		B:可以操作任意类型的数据。
 * 				print()
 * 				println()
 * 		C:如果启动了自动刷新，能够自动刷新。
 * 				PrintWriter pw = new PrintWriter(new FileWriter("pw2.txt"), true);
 *		 		还是应该调用println()的方法才可以
 *				这个时候不仅仅自动刷新了，还实现了数据的换行。
 *		 		println()
 *		 		其实等价于于：
 *		 		bw.write();
 *		 		bw.newLine();		
 *		 		bw.flush();
 * 		D:该流是可以直接操作文本文件的。
 * 			哪些流对象是可以直接操作文本文件的呢?
 * 			FileInputStream
 * 			FileOutputStream
 * 			FileReader
 * 			FileWriter
 * 			PrintStream
 * 			PrintWriter
 * 			看API,查流对象的构造方法，如果同时有File类型和String类型的参数，一般来说就是可以直接操作文件的。
 * 
 * 			流：
 * 				基本流：就是能够直接读写文件的
 * 				高级流：在基本流基础上提供了一些其他的功能
 * 				打印流既是基本流，也是高级流
 */
public class PrintWriterStream {
	public static void main(String[] args) throws IOException {
		// 以前的版本
		// 封装数据源
		// BufferedReader br = new BufferedReader(new FileReader("DataStreamDemo.java"));
		// 封装目的地
		// BufferedWriter bw = new BufferedWriter(new FileWriter("Copy.java"));
		//
		// String line = null;
		// while ((line = br.readLine()) != null) {
		// bw.write(line);
		// bw.newLine();
		// bw.flush();
		// }
		//
		// bw.close();
		// br.close();

		// 打印流的改进版
		// 封装数据源
		BufferedReader br = new BufferedReader(new FileReader("DataStreamDemo.java"));
		// 封装目的地
		// 内部包装了高效缓冲流（BufferedWriter）和转换流（所以第一个参数可以为字节流）
		PrintWriter pw = new PrintWriter(new FileWriter("Copy.java"), true); //自动刷新
		
		String line = null;
		while((line=br.readLine())!=null){
			pw.println(line);  //一句顶上面的三句
		}
		
		pw.close();
		br.close();
	}
}

package com.etc.io_CharStreams;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * 字符缓冲流的特殊方法：
 * BufferedWriter:
 * 		public void newLine():根据系统来决定换行符
 * BufferedReader:
 * 		public String readLine()：一次读取一行数据
 * 		包含该行内容的字符串，不包含任何行终止符，如果已到达流末尾，则返回 null
 */
public class Buf_Methods {
	public static void main(String[] args) throws IOException {
		//write();
		read();
	}

	private static void read() throws IOException {
		// 创建字符缓冲输入流对象
		BufferedReader br = new BufferedReader(new FileReader("bw2.txt"));

		String line = null;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}

		br.close();
	}

	private static void write() throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("bw2.txt"));
		for (int x = 0; x < 10; x++) {
			bw.write("hello" + x);
			// bw.write("\r\n");
			bw.newLine();
			bw.flush();
		}
		bw.close();
	}
}

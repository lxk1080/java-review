package com.etc.io_CharStreams;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * InputStreamReader的方法：
 * int read(): 一次读取一个字符
 * int read(char[] chs):一次读取一个字符数组
 */
public class CS_read {
	public static void main(String[] args) throws IOException {
		// 创建对象
		InputStreamReader isr = new InputStreamReader(new FileInputStream("osw.txt"),"UTF-8");

		// 一次读取一个字符
		// int ch = 0;
		// while ((ch = isr.read()) != -1) {
		// System.out.print((char) ch);  //字符流读取中文字符只要读取的编码正确就不存在中文乱码
		// }

		// 一次读取一个字符数组
		char[] chs = new char[1024];
		int len = 0;
		while ((len = isr.read(chs)) != -1) {
			System.out.print(new String(chs, 0, len));
		}

		// 释放资源
		isr.close();
	}
}

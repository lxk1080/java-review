package com.etc.io_byteStreams;

import java.io.FileInputStream;
import java.io.IOException;

/*
 * 字节输入流操作步骤：
 * A:创建字节输入流对象
 * B:调用read()方法读取数据，并把数据显示在控制台
 * C:释放资源
 * 
 * 读取数据的方式：
 * A:int read():一次读取一个字节
 * B:int read(byte[] b):一次读取一个字节数组
 */
public class Fis_read_byte {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("fis.txt");

		// 最终版代码
		int by = 0;
		// 读取，赋值，判断
		while ((by = fis.read()) != -1) {
			System.out.print((char)by);  //print不要ln
			//用字节流读取中文字符会出现乱码，因为一个gbk中文字符占两个字节（第一个字节肯定是负数，utf-8占3个字节），而这里是读一个字节输出一个字符，便会乱码
		}

		// 释放资源
		fis.close();
	}
}

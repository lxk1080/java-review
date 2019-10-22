package com.etc.io_byteStreams;

import java.io.FileOutputStream;
import java.io.IOException;

/*
 * IO流的分类：
 * 		流向：
 * 			输入流	读取数据
 * 			输出流 写出数据
 * 		数据类型：
 * 			字节流
 * 				字节输入流	读取数据	InputStream
 * 				字节输出流	写出数据	OutputStream
 * 			字符流
 * 				字符输入流	读取数据	Reader
 * 				字符输出流	写出数据	Writer
 * 
 * 		注意：一般我们在探讨IO流的时候，如果没有明确说明按哪种分类来说，默认情况下是按照数据类型来分的。
 * 
 * 需求：我要往一个文本文件中输入一句话："hello,io"
 * 
 * FileOutputStream
 * 注意：每种基类的子类都是以父类名作为后缀名。
 * 		XxxOutputStream
 * 		XxxInputStream
 * 		XxxReader
 * 		XxxWriter
 * 查看FileOutputStream的构造方法：
 * 		FileOutputStream(File file) 
 *		FileOutputStream(String name)
 *
 * 字节输出流操作步骤：
 * 		A:创建字节输出流对象
 * 		B:写数据
 * 		C:释放资源
 */
public class Fos_desc {
	public static void main(String[] args) throws IOException {
		// 创建字节输出流对象
		// File file = new File("fos.txt");
		// FileOutputStream fos = new FileOutputStream(file);
		FileOutputStream fos = new FileOutputStream("fos.txt");
		
		//写数据
		fos.write("hello,IO".getBytes());
		fos.write("java".getBytes());
		
		//释放资源
		//关闭此文件输出流并释放与此流有关的所有系统资源。
		fos.close();
		/*
		 * 为什么一定要close()呢?
		 * A:让流对象变成垃圾，这样就可以被垃圾回收器回收了
		 * B:通知系统去释放跟该文件相关的资源
		 */
		//java.io.IOException: Stream Closed
		//fos.write("java".getBytes());
	}
}

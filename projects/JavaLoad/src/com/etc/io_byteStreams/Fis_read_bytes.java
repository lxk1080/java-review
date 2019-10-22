package com.etc.io_byteStreams;

import java.io.FileInputStream;
import java.io.IOException;

/*
 * 一次读取一个字节数组：int read(byte[] b)
 * 返回值其实是实际读取的字节个数。
 * 
 * A:除了第一次读取，每次读取都是修改数组的值，如果最后一次读取不够数组的长度，那么数组剩下空间元素的值仍然是上一次的
 * B:为了解决最后一次读取的元素个数不够数组的长度的问题（有可能第一次读取也是最后一次读取），所以只输出取到的元素的个数的字节
 * 
 */
public class Fis_read_bytes {
	public static void main(String[] args) throws IOException {
		// 创建字节输入流对象
		// FileInputStream fis = new FileInputStream("fis2.txt");
		FileInputStream fis = new FileInputStream("fis.txt");

		// 最终版代码
		// 数组的长度一般是1024或者1024的整数倍
		byte[] bys = new byte[1024]; //如果在读取第1024个字节的时候，出现中文字符，也会出现乱码
		int len = 0;
		while ((len = fis.read(bys)) != -1) {  //len为读取一次读到的字节长度，当什么都没读到时，长度为-1
			System.out.print(new String(bys, 0, len));
		}

		// 释放资源
		fis.close();
	}
}

package com.etc.io_byteStreams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 复制文本文件。
 * 
 * 数据源：从哪里来
 * a.txt	--	读取数据	--	FileInputStream	
 * 
 * 目的地：到哪里去
 * b.txt	--	写数据		--	FileOutputStream
 * 
 * java.io.FileNotFoundException: a.txt (系统找不到指定的文件。)
 * 
 * 这一次复制中文没有出现任何问题，为什么呢?
 * 上一次我们出现问题的原因在于我们每次获取到一个字节数据，就把该字节数据转换为了字符数据，然后输出到控制台。
 * 而这一次呢?确实通过IO流读取数据，写到文本文件，你读取一个字节，我就写入一个字节，你没有做任何的转换。
 * 它会自己做转换。
 */
public class Fis_copy {
	public static void main(String[] args) throws IOException {
		// 封装数据源
		FileInputStream fis = new FileInputStream("a.txt");
		// 封装目的地
		FileOutputStream fos = new FileOutputStream("b.txt");
		
		//复制图片
		//FileInputStream fis1 = new FileInputStream("f:\\图片\\02.jpg");
		//FileOutputStream fos1 = new FileOutputStream("e:\\photo.jpg");
		
		//复制视频
		//FileInputStream fis = new FileInputStream("e:\\01.mp4");
		//FileOutputStream fos = new FileOutputStream("video.mp4");
		
		// 一次读一个字节
		int by = 0;
		while ((by = fis.read()) != -1) {
			fos.write(by); 
			//这里读一个字节，写一个字节，在遇到中文字符时（第一个字符肯定时负数），负数字节自动会与后面的一个字符拼接，这样就能合成一个中文字符，不会乱码
		}
		
		// 一次读一个数组
		/*byte[] bys = new byte[1024];
		int len = 0;
		while ((len = fis.read(bys)) != -1) {
			fos.write(bys, 0, len);
		}*/
		
		// 释放资源(先关谁都行)
		fos.close();
		fis.close();
	}
}

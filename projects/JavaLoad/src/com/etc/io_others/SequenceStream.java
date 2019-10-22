package com.etc.io_others;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;

/*
 * 以前的操作：
 * a.txt -- b.txt
 * c.txt -- d.txt
 * 
 * 现在想要：
 * a.txt+b.txt -- c.txt  采用合并流 （合并两个）
 */
public class SequenceStream {
	public static void main(String[] args) throws IOException {
		// SequenceInputStream(InputStream s1, InputStream s2)
		// 需求：把a.txt和b.txt的内容复制到Copy.txt中
		InputStream s1 = new FileInputStream("a.txt");
		InputStream s2 = new FileInputStream("b.txt");
		// 数据源
		SequenceInputStream sis = new SequenceInputStream(s1, s2);
		// 目的地
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("Copy.txt"));

		// 如何写读写呢，其实很简单，你就按照以前怎么读写，现在还是怎么读写
		byte[] bys = new byte[1024];
		int len = 0;
		while ((len = sis.read(bys)) != -1) {
			bos.write(bys, 0, len);
		}

		bos.close();
		sis.close();
	}
}

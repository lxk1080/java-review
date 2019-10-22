package com.etc.io_CharStreams;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * 字符流为了高效读写，也提供了对应的字符缓冲流。
 * BufferedWriter:字符缓冲输出流
 * BufferedReader:字符缓冲输入流
 * 
 * BufferedWriter:字符缓冲输出流
 * 将文本写入字符输出流，缓冲各个字符，从而提供单个字符、数组和字符串的高效写入。 
 * 可以指定缓冲区的大小，或者接受默认的大小。在大多数情况下，默认值就足够大了。 
 */
public class Buf_copy {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("a.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("c.txt"));
		
		//一次读一个字符
		int ch = 0;
		while((ch=br.read()) != -1){
			bw.write(ch);
		}
		
		//一次读一个字符数组
		char[] chs = new char[1024];
		int len = 0;
		while((len=br.read(chs)) != -1){
			bw.write(chs,0,len);
			bw.flush();
		}
		
		//一次读一行 （字符缓冲流的独有功能）
		String line = null;
		while ((line = br.readLine()) != null) {  //读出的数据不包含换行符，所以写数据的时候手动换行
			bw.write(line);
			bw.newLine();
			bw.flush();
		}

		bw.close();
		br.close();
	}
}

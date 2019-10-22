package com.etc.nets;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class TCP05_client_thread {
	public static void main(String[] args) throws IOException {
		// 创建客户端Socket对象
		Socket s = new Socket("192.168.18.36", 19191);

		// 封装图片文件
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("Z:\\图片\\a.jpg"));
		// 封装通道内的流
		BufferedOutputStream bos = new BufferedOutputStream(s.getOutputStream());

		byte[] bys = new byte[1024];
		int len = 0;
		while ((len = bis.read(bys)) != -1) {
			bos.write(bys, 0, len);
			bos.flush();  //刷新此输出流并强制写出所有缓冲的输出字节（解决最后一次写出不完整的问题）
		}
		
		s.shutdownOutput();  //告诉服务器传输完了

		// 读取反馈
		InputStream is = s.getInputStream();
		byte[] bys2 = new byte[1024];
		int len2 = is.read(bys2);
		String client = new String(bys2, 0, len2);
		System.out.println(client);

		// 释放资源
		bis.close();
		s.close();
	}
}

package com.etc.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyTomcat {
	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(80); 
		System.out.println("等待连接...");

		while (true) {
			Socket s = ss.accept();
			System.out.println("连接成功！");

			OutputStream os = s.getOutputStream();

			os.write("<h1>hello world</h1>".getBytes()); //如果是浏览器默认端口80，则会识别html标签
			
			s.close();
		}
	}
}

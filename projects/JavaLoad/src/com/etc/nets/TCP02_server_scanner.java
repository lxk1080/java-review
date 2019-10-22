package com.etc.nets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCP02_server_scanner {
	public static void main(String[] args) throws IOException {
		// 创建服务器Socket对象
		ServerSocket ss = new ServerSocket(22222);

		// 监听客户端连接
		Socket s = ss.accept();

		// 包装通道内容的流
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String line = null;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}

		// br.close(); // 包装s的，s关了，这里不用再关了
		s.close();
		// ss.close(); //服务器不关闭
	}
}


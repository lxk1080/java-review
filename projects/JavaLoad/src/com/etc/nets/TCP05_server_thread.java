package com.etc.nets;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCP05_server_thread {
	public static void main(String[] args) throws IOException {
		// 创建服务器Socket对象
		ServerSocket ss = new ServerSocket(19191);
		
		while(true){
			// 每个客户端都有一个自己的通道
			Socket s = ss.accept();
			new Thread(new TCP05_UserThread(s)).start();
		}
	}
}

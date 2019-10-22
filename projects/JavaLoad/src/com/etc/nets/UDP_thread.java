package com.etc.nets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
 * 通过多线程改进刚才的聊天程序，这样我就可以实现在一个窗口发送和接收数据了
 */
public class UDP_thread {
	public static void main(String[] args) throws IOException {
		DatagramSocket dsSend = new DatagramSocket();
		DatagramSocket dsReceive = new DatagramSocket(12306); //指定端口接收数据

		SendThread st = new SendThread(dsSend);
		ReceiveThread rt = new ReceiveThread(dsReceive);

		Thread t1 = new Thread(st);
		Thread t2 = new Thread(rt);

		t1.start();
		t2.start();
	}
}

// 接收数据线程
class ReceiveThread implements Runnable {
	private DatagramSocket ds;

	public ReceiveThread(DatagramSocket ds) {
		this.ds = ds;
	}

	@Override
	public void run() {
		try {
			while (true) {
				// 创建一个包裹
				byte[] bys = new byte[1024];
				DatagramPacket dp = new DatagramPacket(bys, bys.length);

				// 接收数据
				ds.receive(dp);

				// 解析数据
				String ip = dp.getAddress().getHostAddress();
				String s = new String(dp.getData(), 0, dp.getLength());
				System.out.println("from " + ip + " data is : " + s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

// 发送数据线程
class SendThread implements Runnable {

	private DatagramSocket ds;

	public SendThread(DatagramSocket ds) {
		this.ds = ds;
	}

	@Override
	public void run() {
		try {
			// 封装键盘录入数据
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String line = null;
			while ((line = br.readLine()) != null) {
				if ("886".equals(line)) {
					break;
				}

				// 创建数据并打包
				byte[] bys = line.getBytes();
				// DatagramPacket dp = new DatagramPacket(bys, bys.length,
				// InetAddress.getByName("192.168.12.92"), 12345);
				DatagramPacket dp = new DatagramPacket(bys, bys.length,InetAddress.getByName("192.168.18.54"), 12306);

				// 发送数据
				ds.send(dp);
			}

			// 释放资源
			ds.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}



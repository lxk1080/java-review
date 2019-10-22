package com.etc.nets;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class TCP05_UserThread implements Runnable {
	Socket s = new Socket();

	public TCP05_UserThread(Socket s) {
		this.s = s;
	}

	@Override
	public void run() {
		try {
			// 封装通道内流
			BufferedInputStream bis = new BufferedInputStream(s.getInputStream());
			// 封装图片文件
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("x:\\a.jpg"));

			byte[] bys = new byte[1024];
			int len = 0;
			while ((len = bis.read(bys)) != -1) {
				bos.write(bys, 0, len);
				bos.flush(); // 刷新此输出流并强制写出所有缓冲的输出字节
			}

			// 给一个反馈
			OutputStream os = s.getOutputStream();
			os.write("图片上传成功".getBytes());

			bos.close();
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

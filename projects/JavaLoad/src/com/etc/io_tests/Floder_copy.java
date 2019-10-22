package com.etc.io_tests;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 *复制单极文件夹：将F盘的文本文件夹复制到E盘
 * 
 * 分析：
 * 		A:封装目录
 * 		B:获取该目录下的所有文本的File数组
 * 		C:遍历该File数组，得到每一个File对象
 * 		D:把该File进行复制
 */
public class Floder_copy {
	public static void main(String[] args) throws IOException {
		// 封装目录
		File srcFolder = new File("f:\\图片\\游戏\\文本");  //用的字节流，可以复制各种文件或单级文件夹
		// 封装目的地
		File destFolder = new File("e:\\");
		
		copyFolder(srcFolder,destFolder);	
	}

	private static void copyFolder(File srcFolder,File destFolder) throws IOException {
		if(srcFolder.isDirectory()){
			// 如果目的地文件夹不存在，就创建
			File newDestFolder = new File(destFolder,srcFolder.getName());
			if (!newDestFolder.exists()) {
				newDestFolder.mkdirs();
			}
			
			// 获取该目录下的所有文本的File数组
			File[] fileArray = srcFolder.listFiles();
	
			// 遍历该File数组，得到每一个File对象
			for (File file : fileArray) {
				// 数据源：e:\\demo\\e.mp3
				// 目的地：e:\\test\\e.mp3
				String name = file.getName(); // e.mp3
				File newFile = new File(newDestFolder, name); // e:\\test\\e.mp3
	
				copyFile(file, newFile);
			}
		} else {
			File newDestFile = new File(destFolder,srcFolder.getName());
			copyFile(srcFolder, newDestFile);
		}
	}

	private static void copyFile(File file, File newFile) throws IOException {
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(newFile));

		byte[] bys = new byte[1024];
		int len = 0;
		while ((len = bis.read(bys)) != -1) {
			bos.write(bys, 0, len);
		}

		bos.close();
		bis.close();
	}
	
}

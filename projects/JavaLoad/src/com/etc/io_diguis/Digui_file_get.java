package com.etc.io_diguis;

import java.io.File;

/*
 * 需求：请大家把E:\JavaSE目录下所有的java结尾的文件的绝对路径给输出在控制台。
 * 
 * 分析：
 * 		A:封装目录
 * 		B:获取该目录下所有的文件或者文件夹的File数组
 * 		C:遍历该File数组，得到每一个File对象
 * 		D:判断该File对象是否是文件夹
 * 			是：回到B
 * 			否：继续判断是否以.jpg结尾
 * 				是：就输出该文件的绝对路径
 * 				否：不搭理它
 */
public class Digui_file_get {
	public static void main(String[] args) {
		// 封装目录
		File srcFolder = new File("F:\\图片\\风景");
		// 递归功能实现
		getFile(srcFolder);
	}

	private static void getFile(File f) {
		File[] fileArray = f.listFiles(); // 获取该目录下所有的文件或者文件夹的File数组
		for(File file : fileArray){ // 遍历该File数组，得到每一个File对象
			if(file.isDirectory()){  // 判断该File对象是否是文件夹
				getFile(file);
			} else {
				if(file.getName().endsWith(".jpg")){  // 继续判断是否以.jpg结尾
					System.out.println(file.getAbsolutePath());
				}
			}
		}
	}
}

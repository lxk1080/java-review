package com.etc.io_diguis;

import java.io.File;

/*
 * 需求：递归删除带内容的目录
 * 
 * 目录我已经给定：demo
 * 
 * 分析：
 * 		A:封装目录
 * 		B:获取该目录下的所有文件或者文件夹的File数组
 * 		C:遍历该File数组，得到每一个File对象
 * 		D:判断该File对象是否是文件夹
 * 			是：回到B
 * 			否：就删除
 */
public class Digui_deleteFloder {
	public static void main(String[] args) {
		File srcFloder = new File("demo"); //封装目录
		deleteFloder(srcFloder);
	}

	private static void deleteFloder(File srcFloder) {
		File[] fileArray = srcFloder.listFiles(); //得到目录下的文件数组
		if(fileArray!=null){  //防止空文件夹的存在，增强for不能遍历为空的对象
			for(File file : fileArray){
				if(file.isDirectory()){  //得到每个file对象，如果是文件夹就递归调用
					deleteFloder(file); 
				} else {
					System.out.println(file+"---"+file.delete()); //不是文件夹就删除
				}
			}
			// 文件删除之后，再删除这个文件的上级文件夹
			System.out.println(srcFloder+"---"+srcFloder.delete());
		}
	}
}

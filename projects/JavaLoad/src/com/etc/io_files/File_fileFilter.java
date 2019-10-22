package com.etc.io_files;

import java.io.File;
import java.io.FilenameFilter;

/*
 * 判断E盘目录下是否有后缀名为.jpg的文件，如果有，就输出此文件名称
 * A:先获取所有的，然后遍历的时候，依次判断，如果满足条件就输出。
 * B:获取的时候就已经是满足条件的了，然后输出即可。
 * 
 * 要想实现这个效果，就必须学习一个接口：文件名称过滤器
 * public String[] list(FilenameFilter filter)
 * public File[] listFiles(FilenameFilter filter)
 */
public class File_fileFilter {
	public static void main(String[] args) {
		// 封装e判断目录
		File file = new File("f:\\图片\\游戏");

		// 获取该目录下所有文件或者文件夹的String数组
		// public String[] list(FilenameFilter filter)
		String[] strArray = file.list(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return new File(dir, name).isFile() && name.endsWith(".jpg");  //返回后缀名为.jpg的文件名
			}
		});
		// 遍历
		for (String s : strArray) {
			System.out.println(s);
		}
		
		System.out.println("-------------");
		
		// 获取该目录下所有文件或者文件夹的String数组
		// public File[] listFiles(FilenameFilter filter)
		File[] fileArray = file.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return new File(dir, name).isFile() && name.endsWith(".jpg");  //返回后缀名为.jpg的文件名
			}
		});
		
		for (File f : fileArray) {
			System.out.println(f.getName());
		}
		
	}
}

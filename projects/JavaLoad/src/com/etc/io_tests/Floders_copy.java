package com.etc.io_tests;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
/*
 * 复制一个多级文件夹：将F盘的"游戏"文件夹复制到E盘
 */
public class Floders_copy {
	public static void main(String[] args) throws IOException {
		File src = new File("f:\\图片\\游戏");  //用的是字节流，可以复制各种文件、单级文件夹或多级文件夹
		File dest = new File("e:\\");
		
		copyFile(src,dest);
	}

	private static void copyFile(File src,File dest) throws IOException {
			if(src.isDirectory()){
				File newDest = new File(dest,src.getName());
				newDest.mkdir();
				File[] file = src.listFiles();
				for(File newSrc : file){
					copyFile(newSrc,newDest);
				}			
			} else {
				File newDest = new File(dest,src.getName());
				BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(newDest));
				
				byte[] bys = new byte[1024];
				int len = 0;
				while((len=bis.read(bys)) != -1){
					bos.write(bys,0,len);
					bos.flush();
				}
				
				bos.close();
				bis.close();
			}
	}
}

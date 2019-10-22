package com.etc.threads2;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/*
 * 需求：在指定的时间删除我们的指定目录
 */
public class Th_TimerTest {
	public static void main(String[] args) throws ParseException {
		TimerTask myTask = new TimerTask() {
			@Override
			public void run() {
				File srcFolder = new File("demo");
				deleteFolder(srcFolder);
			}
		};
		
		Timer t = new Timer();
		/*String s = "2017-06-26 11:35:00";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d = sdf.parse(s);
		t.schedule(myTask, d);*/ //固定时间删除
		t.schedule(myTask, 3000); //延迟删除
	}
	
	private static void deleteFolder(File srcFolder) {
		if(srcFolder.isDirectory()){
			File[] FileArray = srcFolder.listFiles();
			for(File file : FileArray){
				if(file.isDirectory()){
					deleteFolder(file);
				} else {
					System.out.println(file.getName() + "--" + file.delete());
				}
			} 
			srcFolder.delete();
		} else {
			srcFolder.delete();
		}
		System.out.println("删除成功！");
	}
	
}

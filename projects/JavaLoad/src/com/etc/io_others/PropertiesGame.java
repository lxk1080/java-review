package com.etc.io_others;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Properties;
import java.util.Set;

public class PropertiesGame {
	public static void main(String[] args) throws IOException {
		playGame();
	}

	private static void playGame() throws IOException {
		//创建一个游戏计数文件，并初始化为count=0
		File file = new File("data.txt");
		if(!file.exists()){
			file.createNewFile();
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write("count=0");
			bw.flush();
			bw.close();
		}
	
		//载入文件到集合
		Properties prop = new Properties();
		Reader r = new FileReader("data.txt");
		prop.load(r);
		r.close();
		
		//遍历集合找到计数键count的值
		Set<String> set = prop.stringPropertyNames();
		for(String key : set){
			if(key.equals("count")){
				String value = prop.getProperty(key);
				if(Integer.parseInt(value) < 5){
					//改变统计数并保存
					int i = Integer.parseInt(value) + 1;
					prop.setProperty(key, String.valueOf(i));
					Writer w = new FileWriter("data.txt");
					prop.store(w, "count change");
					w.close();
					
					GuessNumber.start();	
				} else {
					System.out.println("免费次数已用完！");
					System.exit(0);
				}
			}
		}
	}
}

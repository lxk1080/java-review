package com.etc.io_others;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Properties;
import java.util.Set;
/*
 * 我有一个文本文件(prop.txt)，我知道数据是键值对形式的，但是不知道内容是什么。
 * 请写一个程序判断是否有“zhangsan”这样的键存在，如果有就改变其值为”100”
 * 
 * 分析：
 * 		A:把文件中的数据加载到集合中
 * 		B:遍历集合，获取得到每一个键
 * 		C:判断键是否有为"zhangsan"的，如果有就修改其值为"100"
 * 		D:把集合中的数据重新存储到文件中
 */
public class PropertiesTest {
	public static void main(String[] args) throws IOException {
		// 把文件中的数据加载到集合中
		Properties prop = new Properties();
		Reader r = new FileReader("prop.txt");
		prop.load(r); 
		r.close();
		
		// 遍历集合，获取得到每一个键
		Set<String> set = prop.stringPropertyNames();
		for(String key : set){
			if(key.equals("zhangsan")){
				prop.setProperty(key, "100"); //参数都是字符串
				break;
			}
		}
		
		// 把集合中的数据重新存储到文件中
		Writer w = new FileWriter("prop.txt");
		prop.store(w, "the change file"); //保存文件，对文件的描述
		w.close();
	}
}

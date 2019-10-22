package iostream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Buffer {
	public static void main(String[] args) throws IOException {
		File file = new File("d:/xxxxxxxxxxx123"); //创建文件
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));  //输出这个文件，创建输入对象
		bw.write("what are are"); //写入的文本内容
		bw.flush();  //写入缓存
		bw.close();  //关闭流
		BufferedReader br = new BufferedReader(new FileReader(file)); //创建读取对象
		System.out.println(br.readLine());  
	}
}

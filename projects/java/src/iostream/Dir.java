package iostream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Dir {
	public static void main(String[] args) throws IOException {
		File dir = new File("d:/xxxDDD"); //新建文件类对象，目录名
		dir.mkdir();  //创建目录
		File file = new File("d:/xxxDDD/2.txt");  //文件名
		BufferedWriter bw = new BufferedWriter(new FileWriter(file)); //缓冲输入流对象
		bw.write("Helloword\r\n");   //写入内容
		bw.write("dont worry about that!");
		bw.flush();
		bw.close();
		BufferedReader br = new BufferedReader(new FileReader(file));  //缓冲输出流
		System.out.println(br.readLine()); 
	}
}

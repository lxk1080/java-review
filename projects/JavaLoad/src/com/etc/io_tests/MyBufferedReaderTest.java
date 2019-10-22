package com.etc.io_tests;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class MyBufferedReaderTest {
	public static void main(String[] args) throws IOException {
		MyBufferedReader mbr = new MyBufferedReader(new FileReader("a.txt"));
		String line = null;
		while((line=mbr.readLine())!=null){
			System.out.println(line);
		}
		mbr.close();
		
		//System.out.println('\r'+0);  13
		//System.out.println('\n'+0);  10
	}
}

// 自定义MyBufferedReader类，模拟BufferedReader的ReadLine()功能
class MyBufferedReader{
	private Reader r;
	public MyBufferedReader(Reader r){  
		this.r  = r;  //Reader r = new FileReader();
	}
	
	public String readLine() throws IOException{
		StringBuilder sb = new StringBuilder();
		int ch = 0;
		while((ch=this.r.read())!=-1){
			if(ch == '\r'){
				continue;
			}
			
			if(ch == '\n'){ // '\n'说明一行读取完毕
				return sb.toString();
			} else {
				sb.append((char)ch);
			}
		}
		
		//如果最后一行有数据但没有换行符
		if(sb.toString().length() > 0){
			return sb.toString();
		}
		
		return null;
	}
	
	public void close() throws IOException{
		this.r.close();  //fr.close()
	}
}



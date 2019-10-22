package com.etc.io_tests;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
/*
 * BufferedReader
 * 		|--LineNumberReader
 * 			public int getLineNumber() 获得当前行号。 
 * 			public void setLineNumber(int lineNumber) 设置行号
 * 
 */
public class MyLineNumberReaderTest{
	public static void main(String[] args) throws IOException {
		MyLineNumberReader mlr = new MyLineNumberReader(new FileReader("a.txt"));
		
		System.out.println(mlr.getLineNumber());
		System.out.println(mlr.getLineNumber());
		System.out.println(mlr.getLineNumber());
		
		String line = null;
		while((line=mlr.readLine())!=null){
			System.out.println(mlr.getLineNumber()+":"+line);
		}
	}	
}

// 模拟lineNumberReader的获取行号功能 
class MyLineNumberReader extends MyBufferedReader{
	public MyLineNumberReader(Reader r) {
		super(r);  //继承构造方法
	}
	
	private int lineNumber = 0;
	
	public int getLineNumber() {
		return lineNumber;
	}
	
	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}
	
	@Override
	public String readLine() throws IOException{  //每次读取一行的时候行数+1
		lineNumber++;
		return super.readLine();
	}
}
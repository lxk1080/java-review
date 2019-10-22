package com.etc.entity;

import java.util.HashMap;

public class BS {
	
	private static HashMap<Integer, Book> bookStack = new HashMap<Integer, Book>();
	
	// 创建三本书
	private static Book java = BookFactory.getBook("java");
	private static Book oracle = BookFactory.getBook("oracle");
	private static Book python = BookFactory.getBook("python");
	
	public static HashMap<Integer, Book> getBookStack(){
		
		// 把书加入到图书库
		bookStack.put(java.getId(), java);
		bookStack.put(oracle.getId(), oracle);
		bookStack.put(python.getId(), python);
		
		return BS.bookStack; 
	}
	
}

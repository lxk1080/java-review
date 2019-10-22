package com.etc.entity;

public class BookFactory {
	
	// 制书工厂
	
	public static Book getBook(String s){
		if("java".equals(s)){
			return new Book(1, "java", 1, 10);
		} else if("oracle".equals(s)){
			return new Book(2, "oracle", 1, 20);
		} else if("python".equals(s)){
			return new Book(3, "python", 1, 30);
		} else {
			return null;
		}
	}
	
}

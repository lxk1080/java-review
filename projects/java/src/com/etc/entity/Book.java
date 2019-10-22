package com.etc.entity;

public class Book {
	private String sid;
	private String name;
	
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Book [sid=" + sid + ", name=" + name + "]";
	}
	
	public Book(String sid, String name) {
		super();
		this.sid = sid;
		this.name = name;
	}
	
	
}

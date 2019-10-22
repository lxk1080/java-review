package com.book.domain;

public class Book {
	private int id;
	private String name;
	private String author;
	private String publish;
	private float price;
	private int nums; //库存
	
	public Book() {
		super();
	}
	public Book(int id, String name, String author, String publish,
			float price, int nums) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.publish = publish;
		this.price = price;
		this.nums = nums;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublish() {
		return publish;
	}
	public void setPublish(String publish) {
		this.publish = publish;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getNums() {
		return nums;
	}
	public void setNums(int nums) {
		this.nums = nums;
	}
	
}

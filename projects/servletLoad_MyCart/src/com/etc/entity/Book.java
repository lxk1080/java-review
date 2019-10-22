package com.etc.entity;

public class Book {
	private int id;
	private String name;
	private int number;
	private int price;
	
	public Book(int id, String name, int number, int price) {
		super();
		this.id = id;
		this.name = name;
		this.number = number;
		this.price = price;
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

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}

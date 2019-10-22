package com.book.domain;

public class OrderForm {
	private int ord_id;
	private int user_id;
	private float ord_allprice;
	private String ord_time;
	
	
	public int getOrd_id() {
		return ord_id;
	}
	public void setOrd_id(int ord_id) {
		this.ord_id = ord_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public float getOrd_allprice() {
		return ord_allprice;
	}
	public void setOrd_allprice(float ord_allprice) {
		this.ord_allprice = ord_allprice;
	}
	public String getOrd_time() {
		return ord_time;
	}
	public void setOrd_time(String ord_time) {
		this.ord_time = ord_time;
	}
	
}

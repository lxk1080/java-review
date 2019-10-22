package com.book.domain;

public class OrderDetail {
	private int id;
	private int ord_id;
	private int goods_id;
	private String goods_name;
	private int goods_num;
	private float goods_allprice;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrd_id() {
		return ord_id;
	}
	public void setOrd_id(int order) {
		this.ord_id = order;
	}
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public int getGoods_num() {
		return goods_num;
	}
	public void setGoods_num(int goods_num) {
		this.goods_num = goods_num;
	}
	public float getGoods_allprice() {
		return goods_allprice;
	}
	public void setGoods_allprice(float goods_allprice) {
		this.goods_allprice = goods_allprice;
	}
	
}

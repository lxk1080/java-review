package com.vote.domain;

public class User {
	private String name;
	private String idcard;
	private String phone;
	
	public User() {
		super();
	}
	public User(String name, String idcard, String phone) {
		super();
		this.name = name;
		this.idcard = idcard;
		this.phone = phone;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}

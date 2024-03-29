package com.etc.entity;

public class UserList {
	private int id;
	private String username;
	private int password;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "UserList [id=" + id + ", username=" + username + ", password="
				+ password + "]";
	}
	
	public UserList(int id, String username, int password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	
	public UserList(String username, int password) {
		super();
		this.username = username;
		this.password = password;
	}
}

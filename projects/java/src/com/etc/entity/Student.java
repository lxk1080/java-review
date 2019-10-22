package com.etc.entity;

public class Student {
		//属性私有化
		private int num;
		private String name;
		private double price;  
		
		//set和get
		public int getNum() {  
			return num;
		}
		public void setNum(int num) {
			this.num = num;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		
		//构造函数
		public Student(int num, String name, double price) {  
			super();
			this.num = num;
			this.name = name;
			this.price = price;
		}
		
		//输出格式
		@Override
		public String toString() {   
			return "Student [num=" + num + ", name=" + name + ", price="
					+ price + "]";
		}
}

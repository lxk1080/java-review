package com.etc.reflects;

public class Entity_Person {
	private String name;
	int age;
	public String address;

	public Entity_Person() {
	}

	private Entity_Person(String name) {
		this.name = name;
	}

	Entity_Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Entity_Person(String name, int age, String address) {
		this.name = name;
		this.age = age;
		this.address = address;
	}

	public void show() {
		System.out.println("show");
	}

	public void method(String s) {
		System.out.println("method " + s);
	}

	public String getString(String s, int i) {
		return s + "---" + i;
	}

	private void function() {
		System.out.println("function");
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", address=" + address
				+ "]";
	}

}

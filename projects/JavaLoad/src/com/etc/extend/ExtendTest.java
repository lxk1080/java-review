package com.etc.extend;

class Person{
	private String name;
	private int age;
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}	
}

class Student extends Person{
	public Student(){}
	
	public Student(String name,int age){
		//super();  //默认
		super(name,age);
	}
}

public class ExtendTest {
	public static void main(String[] args) {
		//创建学生对象并测试
				//方式1
				Student s1 = new Student();
				s1.setName("古尔丹");
				s1.setAge(27);
				System.out.println(s1.getName()+"---"+s1.getAge());
				
				//方式2
				Student s2 = new Student("古尔丹",27);
				System.out.println(s2.getName()+"---"+s2.getAge());
	}
}

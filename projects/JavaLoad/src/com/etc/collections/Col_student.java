package com.etc.collections;

import java.util.ArrayList;
import java.util.Collection;

public class Col_student {
	public static void main(String[] args) {
		// 创建集合对象
		Collection c = new ArrayList();
	
		// 创建学生对象
		Student s1 = new Student("林青霞", 27);
		Student s2 = new Student("风清扬", 30);
		Student s3 = new Student("令狐冲", 33);
		Student s4 = new Student("武鑫", 25);
		Student s5 = new Student("刘晓曲", 22);
	
		// 把学生添加到集合
		c.add(s1);  //默认向上转型
		c.add(s2);
		c.add(s3);
		c.add(s4);
		c.add(s5);
	
		// 把集合转成数组
		Object[] objs = c.toArray();
		// 遍历数组
		for (int x = 0; x < objs.length; x++) {
			// System.out.println(objs[x]);
	
			Student s = (Student) objs[x];  //向下转型
			System.out.println(s.getName() + "---" + s.getAge());
		}
	}
}

// 创建一个学生类
class Student {
	// 成员变量
	private String name;
	private int age;

	// 构造方法
	public Student() {
		super();
	}

	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	// 成员方法
	// getXxx()/setXxx()
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

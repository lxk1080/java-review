package com.etc.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class List_student {
	public static void main(String[] args) {
		// 创建集合对象
		List list = new ArrayList();  //List是有序的，所以可以重复，有索引

		// 创建学生对象
		Student s1 = new Student("林黛玉", 18);
		Student s2 = new Student("刘姥姥", 88);
		Student s3 = new Student("王熙凤", 38);

		// 把学生添加到集合中
		list.add(s1);
		list.add(s2);
		list.add(s3);

		// 遍历
		// 迭代器遍历
		Iterator it = list.iterator();
		while (it.hasNext()) {
			Student s = (Student) it.next();  //集合默认存储Object类型，这里向下转型
			System.out.println(s.getName() + "---" + s.getAge());
		}
		System.out.println("--------");

		// 普通for循环
		for (int x = 0; x < list.size(); x++) {
			Student s = (Student) list.get(x);
			System.out.println(s.getName() + "---" + s.getAge());
		}
	}
}

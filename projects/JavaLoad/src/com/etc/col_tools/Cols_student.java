package com.etc.col_tools;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Cols_student {
	public static void main(String[] args) {
		// 创建集合对象
		List<Student> list = new ArrayList<Student>();

		// 创建学生对象
		Student s1 = new Student("林青霞", 27);
		Student s2 = new Student("风清扬", 30);
		Student s3 = new Student("刘晓曲", 28);
		Student s4 = new Student("武鑫", 29);
		Student s5 = new Student("林青霞", 27);

		// 添加元素对象
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);
		list.add(s5);

		// 排序
		// 自然排序
		// Collections.sort(list);
		// 比较器排序
		// 如果同时有自然排序和比较器排序，以比较器排序为主
		Collections.sort(list, new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				int num = s1.getAge() - s2.getAge();
				//list集合是存在重复元素的，所以即使返回0，也会加入到集合
				//int num2 = num == 0 ? s1.getName().compareTo(s2.getName()) : num; 
				return -num;  //年龄倒序排序
			}
		});

		// 遍历集合
		for (Student s : list) {
			System.out.println(s.getName() + "---" + s.getAge());
		}
	}
}

package com.etc.col_sets;

import java.util.TreeSet;

/*
 * TreeSet存储自定义对象并保证排序和唯一。
 * 
 * A:你没有告诉我们怎么排序
 * 		自然排序，按照年龄从小到大排序和按名字的长度排序 （实体类重写Comparable接口的compareTo方法）
 * B:元素什么情况算唯一你也没告诉我
 * 		成员变量值都相同即为同一个元素
 */
public class Set_treeSet_01 {
	public static void main(String[] args) {
		// 创建集合对象
		TreeSet<Student> ts = new TreeSet<Student>();  //无参构造，自然排序

		// 创建元素
		Student s1 = new Student("linqingxia", 27);
		Student s2 = new Student("zhangguorong", 29);
		Student s3 = new Student("wanglihong", 23);
		Student s4 = new Student("linqingxia", 27);
		Student s5 = new Student("linqingxia", 30);
		Student s6 = new Student("liushishi", 22);
		Student s7 = new Student("wuqilong", 40);
		Student s8 = new Student("fengqingy", 22);

		// 添加元素
		ts.add(s1);
		ts.add(s2);
		ts.add(s3);
		ts.add(s4);
		ts.add(s5);
		ts.add(s6);
		ts.add(s7);
		ts.add(s8);

		// 遍历
		for (Student s : ts) {
			System.out.println(s.getName() + "---" + s.getAge());
		}
	}
}

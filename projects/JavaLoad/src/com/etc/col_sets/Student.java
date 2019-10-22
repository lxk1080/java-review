package com.etc.col_sets;

public class Student implements Comparable<Student> {
	private String name;
	private int age;

	public Student() {
		super();
	}

	public Student(String name, int age) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	 /*@Override
	 public int hashCode() {
		 // return 0;
		 // 因为成员变量值影响了哈希值，所以我们把成员变量值相加即可
		 // return this.name.hashCode() + this.age;
		 // 看下面，如果出现以下情况
		 // s1:name.hashCode()=40,age=30
		 // s2:name.hashCode()=20,age=50
		 // 尽可能的区分,我们可以把它们乘以一些整数
		 return this.name.hashCode() + this.age * 15;
	 }*/
	
	 /*@Override
	 public boolean equals(Object obj) {
		 // System.out.println(this + "---" + obj);
		 if (this == obj) {
		 return true;
		 }
		
		 if (!(obj instanceof Student)) {
		 return false;
		 }
		
		 Student s = (Student) obj;
		 return this.name.equals(s.name) && this.age == s.age;
	 }*/
	
	 @Override
	 public String toString() {
		 return "Student [name=" + name + ", age=" + age + "]";
	 }
	 
	//按年龄排序 （自然排序）
	/*@Override
	public int compareTo(Student s) {
		// 这里返回什么，其实应该根据我的排序规则来做
		// 按照年龄排序,主要条件
		int num = this.age - s.age;  //按照名字大小排序（compareTo返回1 0 -1）
		// 次要条件
		// 年龄相同的时候，还得去看姓名是否也相同
		// 如果年龄和姓名都相同，才是同一个元素
		int num2 = num == 0 ? this.name.compareTo(s.name) : num;
		return num2;
	}*/
	 
	//按名字的长度排序 （自然排序）
	@Override
	public int compareTo(Student s) {
		//this代表新加的一个元素，而s为从根节点开始的依次得到的父节点
		int num1 = this.name.length() - s.name.length(); // 按名字长度排序（如果名字长度相同，还要判断名字内容和年龄是否相同）
		
		int num2 = num1 == 0?this.name.compareTo(s.name) : num1; //名字长度相同，判断内容是否不同
		
		int num3 =  num2 == 0?this.age - s.age : num2; //名字长度相同，内容相同，判断年龄大小是否相同
		
		return num3;  //小于0在二叉树的左边，等于0不添加，大于0在二叉树的右边
	}

}

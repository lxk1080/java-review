package com.etc.abstracts;
/*
抽象类的概述：
	动物不应该定义为具体的东西，而且动物中的吃，睡等也不应该是具体的。
	我们把一个不是具体的功能称为抽象的功能，而一个类中如果有抽象的功能，该类必须是抽象类。
	
抽象类的特点：
	A:抽象类和抽象方法必须用abstract关键字修饰
	B:抽象类中不一定有抽象方法,但是有抽象方法的类必须定义为抽象类
	C:抽象类不能实例化
		因为它不是具体的。
		抽象类有构造方法，但是不能实例化?构造方法的作用是什么呢?
		用于子类访问父类数据的初始化
	D:抽象的子类
		a:如果不想重写抽象方法，该子类是一个抽象类。
		b:重写所有的抽象方法，这个时候子类是一个具体的类。
		
	抽象类的实例化其实是靠具体的子类实现的。是多态的方式。
		Animal a = new Cat();
*/
/*
抽象类的成员特点：
	成员变量：既可以是变量，也可以是常量。
	构造方法：有。
				用于子类访问父类数据的初始化。
	成员方法：既可以是抽象的，也可以是非抽象的。
	
抽象类的成员方法特性：
	A:抽象方法（没有方法体）： 强制要求非抽象子类做的事情。
	B:非抽象方法 ：子类继承的事情，提高代码复用性。
*/


/*
假如我们在开发一个系统时需要对员工类进行设计，员工包含3个属性：姓名、工号以及工资。
经理也是员工，除了含有员工的属性外，另为还有一个奖金属性。
请使用继承的思想设计出员工类和经理类。要求类中提供必要的方法进行属性访问。

分析：
	普通员工类
		成员变量：姓名、工号以及工资。
		成员方法：工作
	经理类：
		成员变量：姓名、工号以及工资，奖金属性
		成员方法：工作
		
实现：
	员工类：
	普通员工类：
	经理类：
*/
//员工类
abstract class Employee{
	private String name;
	private String id;
	private int salary;
	
	public Employee() {
		super();
	}
	public Employee(String name, String id, int salary) {
		super();
		this.name = name;
		this.id = id;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public abstract void work();
}
//普通员工
class Programmer extends Employee{

	public Programmer() {
		super();
	}

	public Programmer(String name, String id, int salary) {
		super(name, id, salary);
	}
	
	public void work(){
		System.out.println("普通员工的工作生涯");
	}
}

//项目经理
class Manager extends Employee{
	
	private int money;
	
	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Manager(String name, String id, int salary,int money) {
		super(name, id, salary);
		this.money = money;
	}
	
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	public void work(){
		System.out.println("项目经理的工作人生");
	}
}

public class Abs {
	public static void main(String[] args) {
		//测试普通员工
		Employee emp = new Programmer();
		emp.setName("林青霞");
		emp.setId("czbk001");
		emp.setSalary(18000);
		System.out.println(emp.getName()+"---"+emp.getId()+"---"+emp.getSalary());
		emp.work();
		
		emp = new Programmer("林青霞","czbk001",18000);
		System.out.println(emp.getName()+"---"+emp.getId()+"---"+emp.getSalary());
		emp.work();
		
		/*
		emp = new Manager();
		emp.setName("刘意");
		emp.setId("czbk002");
		emp.setSalary(8000);
		emp.setMoney(2000);  //编译看左边，编译报错
		*/
		//由于子类有特有的内容，所以我们用子类来测试
		Manager m = new Manager();
		m.setName("刘意");
		m.setId("czbk002");
		m.setSalary(8000);
		m.setMoney(2000);
		System.out.println(m.getName()+"---"+m.getId()+"---"+m.getSalary()+"---"+m.getMoney());
		m.work();
		
		//通过构造方法赋值
		m = new Manager("刘意","czbk002",8000,2000);
		System.out.println(m.getName()+"---"+m.getId()+"---"+m.getSalary()+"---"+m.getMoney());
		m.work();
	}
}


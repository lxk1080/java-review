package com.etc.duotai;
/*
多态的好处：
	A:提高了代码的维护性(继承保证)
	B:提高了代码的扩展性(由多态保证)
	
猫狗案例代码
*/
class Animal {
	public void eat(){
		System.out.println("eat");
	}
	
	public void sleep(){
		System.out.println("sleep");
	}
}

class Dog extends Animal {
	public void eat(){
		System.out.println("狗吃肉");
	}
	
	public void sleep(){
		System.out.println("狗站着睡觉");
	}
}

class Cat extends Animal {
	public void eat() {
		System.out.println("猫吃鱼");
	}
	
	public void sleep() {
		System.out.println("猫趴着睡觉");
	}
}
//针对动物操作的工具类
class AnimalTool {
	private AnimalTool(){}
	public static void useAnimal(Animal a) {
		a.eat();
		a.sleep();
	}
}

public class DuotaiDenefit {
	public static void main(String[] args) {

		Cat c = new Cat();	
		Cat c2 = new Cat();
		Cat c3 = new Cat();
		AnimalTool.useAnimal(c);
		AnimalTool.useAnimal(c2);
		AnimalTool.useAnimal(c3);
		System.out.println("--------------");
		
		//我喜欢狗
		Dog d = new Dog();
		Dog d2 = new Dog();
		Dog d3 = new Dog();
		AnimalTool.useAnimal(d);
		AnimalTool.useAnimal(d2);
		AnimalTool.useAnimal(d3);
		System.out.println("--------------");
	}
}
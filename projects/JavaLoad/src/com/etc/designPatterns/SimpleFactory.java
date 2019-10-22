package com.etc.designPatterns;

// 买家或卖家
public class SimpleFactory {
	public static void main(String[] args) {
		Animal a = AnimalFactory.createAnimal("Dog");
		a.eat();
		a = AnimalFactory.createAnimal("Cat");
		a.eat();
		
		a = AnimalFactory.createAnimal("pig");
		if(a != null){
			a.eat();
		} else {
			System.out.println("no this animal maked!");
		}
	}
}

// 动物抽象类
abstract class Animal{
	public abstract void eat();
}

// 狗类
class Dog extends Animal{
	@Override
	public void eat() {
		System.out.println("狗吃肉");
	}
}
// 猫类
class Cat extends Animal{
	@Override
	public void eat() {
		System.out.println("猫吃鱼");
	}
}

// 动物制造工厂
class AnimalFactory{
	private AnimalFactory(){
		
	}
	
	public static Animal createAnimal(String s){
		if(s.equals("Dog")){
			return new Dog();
		} else if(s.equals("Cat")){
			return new Cat();
		} else {
			return null;
		}	
	}
}
package com.etc.designPatterns;

public class InterfaceFactory {
	public static void main(String[] args) {
		AnimalFactory2 a1 = new DogFactory();
		Animal d = a1.createAnimal2();
		d.eat();
		
		AnimalFactory2 a2 = new CatFactory();
		Animal c = a2.createAnimal2();
		c.eat();
	}
}

//动物抽象类
abstract class Animal2{
	public abstract void eat();
}

//狗类
class Dog2 extends Animal{
	@Override
	public void eat() {
		System.out.println("狗吃肉");
	}
}
//猫类
class Cat2 extends Animal{
	@Override
	public void eat() {
		System.out.println("猫吃鱼");
	}
}

// 动物制造工厂
abstract class AnimalFactory2{
	public abstract Animal createAnimal2(); 
}

// 狗工厂
class DogFactory extends AnimalFactory2{
	@Override
	public Animal createAnimal2() {
		return new Dog();
	}
}

// 猫工厂
class CatFactory extends AnimalFactory2{
	@Override
	public Animal createAnimal2() {
		return new Cat();
	}
}
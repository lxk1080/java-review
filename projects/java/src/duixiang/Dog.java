package duixiang;

public class Dog extends Animal{
	public void eat(){
			System.out.println("eat eat eat~~~");
		}
	public static void main(String[] args) {
		Dog dog=new Dog();
		dog.jiao();
		dog.eat();
	}
}

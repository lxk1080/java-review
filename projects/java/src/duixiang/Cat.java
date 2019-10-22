package duixiang;

public class Cat extends Animal {
	public void carry(){
		System.out.println("老鼠什么的，最好吃了");
	}
	public static void main(String[] args) {
		Cat cat=new Cat();
		cat.jiao();
		cat.carry();
	}
	
}

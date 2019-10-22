package helloWorld;
import java.util.Scanner;

public class scanner {
	public int get(){	
		Scanner s=new Scanner(System.in);		
		System.out.print("输入一个数字：");
		String str = s.next();
		int i=Integer.parseInt(str);
		return i;
	}
	public static void main(String[] args){
		scanner a=new scanner();
		int n=a.get();
		switch(n){
		case 1:System.out.println("星期一");main(args);break;
		case 2:System.out.println("星期二");main(args);break;
		case 3:System.out.println("星期三");main(args);break;
		case 4:System.out.println("星期四");main(args);break;
		case 5:System.out.println("星期五");main(args);break;
		default:System.out.println("错误");
		}
	}
}

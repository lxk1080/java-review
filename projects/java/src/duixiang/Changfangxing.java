package duixiang;

import java.util.Scanner;

public class Changfangxing {
		public int zhouchang(int m,int n){
			int sum;
			sum=2*(m+n);
			return sum;
		}
		public int mianji(int i,int j){
			int s;
			s=i*j;
			return s;
		}
	public static void main(String[] args) {
		Changfangxing c=new Changfangxing();
		Scanner scan=new Scanner(System.in);
		System.out.print("输入长:");
		int i=scan.nextInt();
		System.out.print("输入宽:");
		int j=scan.nextInt();
		System.out.println("长方形的周长是："+c.zhouchang(i,j));
		System.out.println("长方形的面积是："+c.mianji(i,j));
	}
}

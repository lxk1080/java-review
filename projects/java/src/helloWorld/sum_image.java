package helloWorld;

public class sum_image {
	public static void main(String[] args) {
		for(int i=1;i<5;i++){
			for(int m=0;m<5-i;m++){
				System.out.print(" ");
			}
			for(int j=0;j<2*i-1;j++){
				System.out.print("*");
				}
			System.out.print("\r\n");
		}
	}
}

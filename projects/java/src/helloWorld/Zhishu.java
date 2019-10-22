package helloWorld;

public class Zhishu {
	public static void main(String[] args) {
		for(int i=101;i<200;i++){
			int n=0;
			for(int j=2;j<i;j++){
				int sum;
				sum=i%j;
				if(sum==0)n=1;
			}
			if(n==0)System.out.println(i);
		}
	}
}

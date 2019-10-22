package helloWorld;

public class type_convert {
	public static void main(String[] args) {
		//int-->string
		int i=12345;
		String j=Integer.toString(i);
		String k=String.valueOf(i);
		String l=i+"";
		
		//String-->int
		String m="555";
		int n=Integer.parseInt(m);
		int p=Integer.valueOf(m);
		
		//float-->int
		float f=2.1f;
		int fi=(int)f;
		
		//int-->float,小的转大的会自动转换
		int ii=22;
		float ff=ii;
		
		//double-->float,大的转小的，需要强制转换
		double d=2.5;
		float fd=(float)d;
		
		int a = 10;
		float b = 10.1F;
		float c = (a+b);
		System.out.println(c);
	}
}

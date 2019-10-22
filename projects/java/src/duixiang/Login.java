package duixiang;

public class Login {
	public boolean login(String name,String password){
		if(name=="小白"&&password=="1234"){
			System.out.println("登录成功");
			return true;
		}else{
			System.out.println("登录失败");
			return false;
		}
	}
	public static void main(String[] args) {
		Login l=new Login();
		boolean b=l.login("小","1234");
		System.out.println(b);
	}
}

package duixiang;

public class Game{
	public String yingqing="rage";  //同一个工程
	protected String guangying;  //子类
	String xuanran;  //同一个包
	private String jianmo; //本类
		
	public void play(){
		System.out.println("dont worry,be happy!");
	}
	
	public static void main(String[] args) {
		Game game=new Game();
		game.yingqing="寒霜";
		System.out.println(game.yingqing);
		game.play();
	}
}

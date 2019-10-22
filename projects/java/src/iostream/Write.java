package iostream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

public class Write {
	public static void main(String[] args){
		try {
			FileWriter fw = new FileWriter("d:/test.txt");
			fw.write("小白好白");
			fw.flush();
			fw.close();
			FileReader fr = new FileReader("d:/test.txt");
			BufferedReader bw= new BufferedReader(fr);
			String con="",line;
			while((line=bw.readLine())!=null){
				con+=line;
			}
			System.out.println(con);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

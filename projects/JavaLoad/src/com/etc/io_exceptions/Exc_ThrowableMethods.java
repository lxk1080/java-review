package com.etc.io_exceptions;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/*
 * 在try里面发现问题后，jvm会帮我们生成一个异常对象，然后把这个对象抛出，和catch里面的类进行匹配。
 * 如果该对象是某个类型的，就会执行该catch里面的处理信息。
 * 
 * 异常中要了解的几个方法：
 * public String getMessage():异常的消息字符串		
 * public String toString():返回异常的简单信息描述
 * 		此对象的类的 name(全路径名)
 * 		": "（冒号和一个空格） 
 * 		调用此对象 getLocalizedMessage()方法的结果 (默认返回的是getMessage()的内容)
 * printStackTrace()：获取异常类名和异常信息，以及异常出现在程序中的位置。返回值void。把信息输出在控制台。程序继续向下执行
 */
public class Exc_ThrowableMethods {
	public static void main(String[] args) {
		String s = "2014-11-20";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date d = sdf.parse(s); // 创建了一个ParseException对象，然后抛出去，和catch里面进行匹配
			System.out.println(d);
		} catch (ParseException e) { // ParseException e = new ParseException();
			// getMessage()
			// System.out.println(e.getMessage());
			// Unparseable date: "2014-11-20"

			// toString()
			// System.out.println(e.toString());
			// java.text.ParseException: Unparseable date: "2014-11-20"
			
			e.printStackTrace();  //和jvm的默认处理类似，都是输出错误信息，区别在于程序输出异常后能够继续向下执行
		}
		
		System.out.println("over");
	}
}

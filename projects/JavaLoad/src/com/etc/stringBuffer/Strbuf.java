package com.etc.stringBuffer;
/**
 * StringBuffer:
 * 		线程安全的可变字符串
 * 			线程安全 -- 同步 -- 效率低
 * 			线程不安全 -- 不同步 -- 效率高
 * 
 * StringBuffer和String的区别?
 * 前者长度和内容可变，后者不可变。
 * 如果使用前者做字符串的拼接，不会浪费太多的资源。
 * 
 * StringBuffer的添加功能：
 * public StringBuffer append(String str):可以把任意类型数据添加到字符串缓冲区里面,并返回字符串缓冲区本身
 * public StringBuffer insert(int offset,String str):在指定位置把任意类型的数据插入到字符串缓冲区里面,并返回字符串缓冲区本身
 * 
 * StringBuffer的删除功能
 * public StringBuffer deleteCharAt(int index):删除指定位置的字符，并返回本身
 * public StringBuffer delete(int start,int end):删除从指定位置开始指定位置结束的内容，并返回本身
 * 
 * StringBuffer的替换功能：
 * public StringBuffer replace(int start,int end,String str):从start开始到end用str替换
 * 
 * StringBuffer的反转功能：
 * public StringBuffer reverse()
 * 
 * StringBuffer的截取功能:注意返回值类型不再是StringBuffer本身了
 * public String substring(int start)
 * public String substring(int start,int end)
 * 
 */
public class Strbuf {
	public static void main(String[] args) {
		// 创建字符串缓冲区对象
		StringBuffer sb = new StringBuffer();

		// StringBuffer sb2 = sb.append("hello");
		// System.out.println("sb:" + sb);
		// System.out.println("sb2:" + sb2);
		// System.out.println(sb == sb2);  // true

		// 链式编程
		sb.append("hello").append(true).append(12).append(34.56);
		System.out.println("sb:" + sb);

		sb.insert(5, "world");
		System.out.println("sb:" + sb);
		
		//替换
		sb.replace(5, 10, "MY");
		System.out.println(sb);
		
		// 截取功能
		String s = sb.substring(5, 10);
		System.out.println("s:" + s);
		System.out.println("sb:" + sb);
		
		//删除所有的数据
		sb.delete(0, sb.length());
		System.out.println("sb:" + sb);
	}
}

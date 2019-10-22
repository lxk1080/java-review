package com.etc.col_lists;

import java.util.ArrayList;
import java.util.Iterator;

/*
 * 需求：ArrayList去除集合中字符串的重复值(字符串的内容相同)
 * 要求：不能创建新的集合，就在以前的集合上做。
 */
public class List_QuChong2 {
	public static void main(String[] args) {
		// 创建集合对象
		ArrayList array = new ArrayList();

		// 添加多个字符串元素(包含内容相同的)
		array.add("hello");
		array.add("world");
		array.add("java");
		array.add("world");
		array.add("java");
		array.add("world");
		array.add("world");
		array.add("world");
		array.add("world");
		array.add("java");
		array.add("world");

		// 由选择排序思想引入，我们就可以通过这种思想做这个题目
		// 拿0索引的依次和后面的比较，有就把后的干掉
		// 同理，拿1索引...
		for (int x = 0; x < array.size() - 1; x++) {
			for (int y = x + 1; y < array.size(); y++) {
				if (array.get(x).equals(array.get(y))) {
					array.remove(y);
					y--; //一般把某个索引的值删除后，就会判断下一个索引的值，但是由于存在连续重复的项，所以下一个索引的值将会顺势补位到当前索引，那么这个值就是漏网之鱼，所以再回来判断一次
				}
			}
		}
		
		// 遍历集合
		Iterator it = array.iterator();
		while (it.hasNext()) {
			String s = (String) it.next();
			System.out.println(s);
		}
	}
}

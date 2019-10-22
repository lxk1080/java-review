package com.etc.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import com.etc.entity.Book;

public class BookTest {
	public static void main(String[] args) {
		Map<Integer,Book> map = new HashMap<Integer,Book>();
		
		map.put(1,new Book("xs001","数据结构"));
		map.put(2,new Book("xs002","java基础"));
		map.put(3,new Book("xs003","操作系统"));
		
		if(!map.isEmpty()){
			for (Integer integer : map.keySet()) {
				if(map.get(integer).getName()=="数据结构"&&map.get(integer).getSid()=="xs001"){
					map.remove(integer);
					break;
				}
			}
		}
		
		for (Entry<Integer, Book> string : map.entrySet()) {
			System.out.println(string.getKey()+"-->"+string.getValue());
		}
	}
}

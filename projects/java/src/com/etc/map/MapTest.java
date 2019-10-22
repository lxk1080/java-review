package com.etc.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.etc.entity.Student;

public class MapTest {
	public static void main(String[] args) {
		Map<Integer,Student> m = new HashMap<Integer,Student>(); //Map接口，键值对，HashMap实现类
		
		m.put(1,new Student(1,"ez",2.00)); //put添加
		m.put(2,new Student(2,"js",1.50));
		m.put(3,new Student(3,"dm",1.75));
		
		if(!m.isEmpty()){   
			if(m.get(3).getName()=="dm"){
				m.remove(3);
			}
		}
		
		for (Integer integer : m.keySet()) {
			System.out.println(integer+"-->"+m.get(integer));
		}
		
		for(Entry<Integer,Student> string : m.entrySet()){
			System.out.println(string.getKey()+":"+string.getValue());
		}
	}
}

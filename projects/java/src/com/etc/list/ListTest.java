package com.etc.list;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class ListTest {
	public static void main(String[] args) {
		
		List<String> list=new ArrayList<String>(); //新建一个集合，类型为String，List是接口，ArrayList是实现类
		
		list.add("name"); //List是有序的，可以重复
		list.add("sky");
		list.add("rage");
		if(!list.isEmpty()){ //如果非空
			System.out.println(list.get(2));
			if(list.get(2)=="rage"){
				list.remove(2);
			}	
		}
	//for循环
	for(int i=0;i<list.size();i++){  //长度是size()
		System.out.println("for:"+list.get(i));
	}
	//foreach遍历
	for (String string : list) {
		System.out.println("foreach:"+string);
	}
	//iterator迭代
	Iterator<String> it=list.iterator();
	while(it.hasNext()){
		System.out.println("Iterator:"+it.next());
	}
	}
}

package com.etc.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTest {
	public static void main(String[] args) {
		
		Set<Integer> set = new HashSet<Integer>();//实现类HashSet
	
		set.add(1); //Set是无序的，不可重复
		set.add(2);
		set.add(3);
		set.add(4);
	if(!set.isEmpty()){  //由于是无序的，没有下标，不可用get()方法，不可用for循环遍历
			for (Integer integer : set) {  //foreach循环遍历
				if(integer==4){
					set.remove(integer);
					break;				//foreach循环时不可删除元素，用break结束当前循环
				}
			}
		}
	Iterator<Integer> it=set.iterator();  //迭代循环，用迭代变量接受迭代遍历的值
	while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	
}

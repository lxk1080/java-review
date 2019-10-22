package com.etc.col_lists;

import java.util.Iterator;
import java.util.LinkedList;

/*
 *请用LinkedList模拟栈数据结构（先进后出）的集合，并测试
 *题目的意思是：
 *		你自己的定义一个集合类，在这个集合类内部可以使用LinkedList模拟。
 */
public class List_myStack {
	public static void main(String[] args) {
		MyStack ms = new MyStack();
		
		ms.add("hello");
		ms.add("world");
		ms.add("java");
		
		while(!ms.isEmpty()){
			System.out.println(ms.get());
		}
	}
}


// 定义自己的一个集合类
class MyStack {
	private LinkedList link;

	public MyStack() {
		link = new LinkedList();
	}

	public void add(Object obj) {
		link.addFirst(obj);
	}

	public Object get() {
		// return link.getFirst();
		return link.removeFirst(); //删除并返回这个元素
	}

	public boolean isEmpty() {
		return link.isEmpty();
	}
}


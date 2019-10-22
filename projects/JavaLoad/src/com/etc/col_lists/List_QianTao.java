package com.etc.col_lists;

import java.util.ArrayList;
import java.util.List;

public class List_QianTao {
	public static void main(String[] args) {
		List<String> li1 = new ArrayList<String>();
		li1.add("hello");
		li1.add("word");
		li1.add("java");
		
		List<String> li2 = new ArrayList<String>();
		li2.add("qwer");
		li2.add("asdf");
		li2.add("zxcv");
		
		List<List<String>> li = new ArrayList<List<String>>();
		li.add(li1);
		li.add(li2);
		
		for (List<String> l : li) {
			for (String s : l) {
				System.out.println(s);
			}
		}
	}
}

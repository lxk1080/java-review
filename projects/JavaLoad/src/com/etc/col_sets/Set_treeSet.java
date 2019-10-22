package com.etc.col_sets;

import java.util.TreeSet;

/*
 * TreeSet：能够对元素按照某种规则进行排序。
 * 排序有两种方式
 * A:自然排序（无参构造，实体类必须要实现Comparable接口，重写compareTo方法）
 * B:比较器排序（带参构造，使用匿名内部类实现Comparator接口，重写compare方法，一般情况下用这种，因为自然排序要在实体类修改，当要按照多种不同的规则排序时，则需要多次修改）
 * 
 * TreeSet集合的特点：排序和唯一
 * 
 * 通过观察TreeSet的add()方法，我们知道最终要看TreeMap的put()方法。
 */
public class Set_treeSet {
	public static void main(String[] args) {
		// 创建集合对象
		// 自然顺序进行排序
		TreeSet<Integer> ts = new TreeSet<Integer>(); //Integer实现了Comparable接口的compareTo方法（存在自然排序）

		// 创建元素并添加
		// 20,18,23,22,17,24,19,18,24
		ts.add(20);
		ts.add(18);
		ts.add(23);
		ts.add(22);
		ts.add(17);
		ts.add(24);
		ts.add(19);
		ts.add(18);
		ts.add(24);

		// 遍历
		for (Integer i : ts) {
			System.out.println(i);
		}
	}
}

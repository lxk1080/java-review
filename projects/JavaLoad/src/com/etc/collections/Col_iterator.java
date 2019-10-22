package com.etc.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
 * Iterator iterator():迭代器，集合的专用遍历方式
 * 		Object next():获取元素,并移动到下一个位置。
 * 			NoSuchElementException：没有这样的元素，因为你已经找到最后了。
 * 		boolean hasNext():如果仍有元素可以迭代，则返回 true。
 */
/*
 * 问题1:能用while循环写这个程序，我能不能用for循环呢? 能
 * 问题2:不要多次使用it.next()方法，因为每次使用都是访问一个对象。
 */
public class Col_iterator {
	public static void main(String[] args) {
		// 创建集合对象
		Collection c = new ArrayList();

		// 创建学生对象
		Student s1 = new Student("林青霞", 27);
		Student s2 = new Student("风清扬", 30);
		Student s3 = new Student("令狐冲", 33);
		Student s4 = new Student("武鑫", 25);
		Student s5 = new Student("刘晓曲", 22);

		// 把学生添加到集合中
		c.add(s1);
		c.add(s2);
		c.add(s3);
		c.add(s4);
		c.add(s5);

		// Iterator iterator():迭代器，集合的专用遍历方式
		Iterator it = c.iterator(); // Iterator是一个接口，实际返回的肯定是子类对象，这里是多态

		while (it.hasNext()) {
			// System.out.println(it.next());
			Student s = (Student) it.next();
			System.out.println(s.getName() + "---" + s.getAge());
			
			// NoSuchElementException 不要多次使用it.next()方法
			// System.out.println(((Student) it.next()).getName() + "---"
			// + ((Student) it.next()).getAge());
		}
		
		// for循环改写（it使用完立即释放，提高效率和内存利用率，但是代码意图没有while清晰）
		/*for(Iterator it = c.iterator();it.hasNext();){
			Student s = (Student) it.next();
			System.out.println(s.getName() + "---" + s.getAge());
		}*/
	}
}

package com.etc.jdks;

public class Meiju_zishixian {
	public static void main(String[] args) {
		Direction d = Direction.FRONT;
		System.out.println(d);
		System.out.println(d.getName());
		d.show();

		d = Direction.LEFT;
		System.out.println(d);
		System.out.println(d.getName());
		d.show();
	}
}

/*
 * 自实现枚举类
 */
abstract class Direction {
	// 创建几个实例
	public static final Direction FRONT = new Direction("前") {
		@Override
		public void show() {
			System.out.println("前");
		}

	};
	public static final Direction BEHIND = new Direction("后") {
		@Override
		public void show() {
			System.out.println("后");
		}

	};
	public static final Direction LEFT = new Direction("左") {
		@Override
		public void show() {
			System.out.println("左");
		}

	};
	public static final Direction RIGHT = new Direction("右") {
		@Override
		public void show() {
			System.out.println("右");
		}

	};

	// 构造私有，别人就不能无限的创建了
	// private Direction2() {
	// }

	// 加入成员变量,并去掉无参构造
	private String name;

	private Direction(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	// 加入抽象方法
	public abstract void show();
}

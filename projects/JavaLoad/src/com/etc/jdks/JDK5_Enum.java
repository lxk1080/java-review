package com.etc.jdks;

/*
 * 通过JDK5提供的枚举来做枚举类
 */
public class JDK5_Enum {
	public static void main(String[] args) {
		Direction2 d2 = Direction2.FRONT;
		System.out.println(d2);
		System.out.println(d2.getName());
		d2.show();
		System.out.println("--------------");
		
		Direction2 dd = Direction2.FRONT;
		dd = Direction2.LEFT;

		switch (dd) {
		case FRONT:
			System.out.println("你选择了前");
			break;
		case BEHIND:
			System.out.println("你选择了后");
			break;
		case LEFT:
			System.out.println("你选择了左");
			break;
		case RIGHT:
			System.out.println("你选择了右");
			break;
		}

	}
}

/*
 * JDK5自带枚举
 */
enum Direction2  {
	FRONT("前") {
		@Override
		public void show() {
			System.out.println("前");
		}
	},
	BEHIND("后") {
		@Override
		public void show() {
			System.out.println("后");
		}
	},
	LEFT("左") {
		@Override
		public void show() {
			System.out.println("左");
		}
	},
	RIGHT("右") {
		@Override
		public void show() {
			System.out.println("右");
		}
	};

	private String name;

	private Direction2(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public abstract void show();
}


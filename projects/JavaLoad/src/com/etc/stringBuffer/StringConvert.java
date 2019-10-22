package com.etc.stringBuffer;

public class StringConvert {
	public static void main(String[] args) {
		// String -- StringBuffer
		String s = "hello";
		// 方式1:通过构造方法
		StringBuffer sb = new StringBuffer(s);
		// 方式2：通过append()方法
		StringBuffer sb2 = new StringBuffer();
		sb2.append(s);

		// StringBuffer -- String
		StringBuffer buffer = new StringBuffer("java");
		// 方式1:通过构造方法
		String str = new String(buffer);
		// 方式2：通过toString()方法
		String str2 = buffer.toString();

	}
}

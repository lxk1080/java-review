package com.etc.patterns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 获取功能：
 * 获取下面这个字符串中由三个字符组成的单词
 * da jia ting wo shuo,jin tian yao xia yu,bu shang wan zi xi,gao xing bu?
 */
public class PattAndMat {
	public static void main(String[] args) {
		// 定义字符串
		String s = "da jia ting wo shuo,jin tian yao xia yu,bu shang wan zi xi,gao xing bu?";
		// 规则
		String regex = "\\b\\w{3}\\b";

		// 把规则编译成模式对象
		Pattern p = Pattern.compile(regex);
		// 通过模式对象得到匹配器对象
		Matcher m = p.matcher(s);
		
		// m.find()返回为真，输出一条数据
		while (m.find()) {
			System.out.print(m.group()+" ");
		}
		
		// 注意：一定要先find()，然后才能group()
		// IllegalStateException: No match found
		// String ss = m.group();
		// System.out.println(ss);
	}
}

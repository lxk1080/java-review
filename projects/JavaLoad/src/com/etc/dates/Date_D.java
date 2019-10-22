package com.etc.dates;

import java.util.Date;

/*
 * Date:表示特定的瞬间，精确到毫秒。 
 * 
 * 构造方法：
 * 		Date():根据当前的默认毫秒值创建日期对象
 * 		Date(long date)：根据给定的毫秒值创建日期对象
 * 
 * 提供方法：
 * 		public long getTime():获取时间，以毫秒为单位
 * 		public void setTime(long time):设置时间
 * 
 * 		从Date得到一个毫秒值
 * 			getTime()
 * 		把一个毫秒值转换为Date
 * 			构造方法
 * 			setTime(long time)
 */
public class Date_D {
	public static void main(String[] args) {
		// 创建对象
		Date d = new Date();
		System.out.println("d:" + d);

		// 创建对象
		// long time = System.currentTimeMillis();
		long time = 1000 * 60 * 60; // 1小时
		Date d2 = new Date(time);
		System.out.println("d2:" + d2);
		

		// 获取时间
		long time2 = d.getTime();
		System.out.println(time2);
		// System.out.println(System.currentTimeMillis());

		// 设置时间
		d.setTime(1000);
		System.out.println("d:" + d);
		
	}
}
package com.etc.test;

import org.apache.log4j.Logger;

public class Log4j {
	public static Logger log = Logger.getLogger(Log4j.class);

	public static void main(String[] args) {
		String s = "hello";
		log.info("这是一条什么信息" + s);
		run();
	}

	public static void run() {
		String a = "java";
		log.info(a);
	}

}

package com.etc.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Map_bianli {
	public static void main(String[] args) {

		Map<String, String> map = new HashMap<String, String>();

		map.put("杨过", "小龙女");
		map.put("郭靖", "黄蓉");
		map.put("杨康", "穆念慈");
		map.put("陈玄风", "梅超风");
		
		// 遍历1（根据键找值）
		// 获取所有的键
		Set<String> set = map.keySet();
		// 遍历键的集合，获取得到每一个键
		for (String key : set) {
			// 根据键去找值
			String value = map.get(key);
			System.out.println(key + "---" + value);
		}
		
		// 遍历2（根据键值对对象找键和值）
		// 获取所有键值对对象的集合
		Set<Map.Entry<String, String>> set2 = map.entrySet();
		// 遍历键值对对象的集合，得到每一个键值对对象
		for (Map.Entry<String, String> me : set2) {
			// 根据键值对对象获取键和值
			String key = me.getKey();
			String value = me.getValue();
			System.out.println(key + "---" + value);
		}
	}
}

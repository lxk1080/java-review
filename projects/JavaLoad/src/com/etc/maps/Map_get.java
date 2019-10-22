package com.etc.maps;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * 获取功能：
 * V get(Object key):根据键获取值
 * Set<K> keySet():获取集合中所有键的集合
 * Collection<V> values():获取集合中所有值的集合
 */
public class Map_get {
	public static void main(String[] args) {
		
		Map<String,String> map = new HashMap<String,String>();
		
		map.put("邓超", "孙俪");
		map.put("黄晓明", "杨颖");
		map.put("周杰伦", "蔡依林");
		map.put("刘恺威", "杨幂");
		
		// V get(Object key):根据键获取值
		System.out.println(map.get(1));
		System.out.println("------------");
		
		// Set<K> keySet():获取集合中所有键的集合（键的集合是set集合）
		Set<String> set = map.keySet();
		for(String key : set){
			System.out.println(key);
		}
		System.out.println("------------");
		
		// Collection<V> values():获取集合中所有值的集合
		Collection<String> col = map.values();
		for(String value : col){
			System.out.println(value);
		}
	}
}

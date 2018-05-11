package com.example.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

public class MapTest {
	
	Map<Object, Object> treeMap = new TreeMap<>();
	Map<Object, Object> hashMap = new HashMap<>();
	Map<Object, Object> lHashMap = new LinkedHashMap<Object, Object>();
	
	List<String> list = new ArrayList<String>();

	
	
	public static void fillMap(Map<Object, Object> map){
		map.put("a", "A");
		map.put("b", "20");
		map.put(1, 2);
	}
	
	public static void main(String[] args) {
		MapTest test =  new MapTest();
		test.treeMap.put("a", "10");
		test.treeMap.put("c", "30");
		test.treeMap.put("e", "50");
		test.treeMap.put("d", "40");
		test.treeMap.put("b", "20");
		test.treeMap.put("c", "20");
		
		//test.list.forEach(action);
		
	}

}

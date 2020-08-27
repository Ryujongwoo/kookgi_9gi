package com.koreait.collectionTest;

import java.util.HashMap;

public class HashMapTest {

	public static void main(String[] args) {
		
//		HashMap은 사전식으로 저장한다. => key(K)에 value(V)를 할당하는 방식으로 저장한다.
//		key 일반적으로 String 타입으로 만들고 value는 저장할 데이터 타입으로 만든다.
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		
//		put(key, value) : key에 value를 저장(할당)한다.
		hmap.put("apple", 1000);
//		size() : HashMap에 저장된 데이터의 개수를 얻어온다.
		System.out.println(hmap.size() + " : " + hmap);
		hmap.put("banana", 2000);
		System.out.println(hmap.size() + " : " + hmap);
		hmap.put("orange", 3000);
		System.out.println(hmap.size() + " : " + hmap);
		hmap.put("melon", 10000);		// "melon" 이라는 key가 없으므로 데이터가 추가된다.
		System.out.println(hmap.size() + " : " + hmap);
		hmap.put("water melon", 5000);
		System.out.println(hmap.size() + " : " + hmap);
		
//		put() 메소드로 없는 key에 value를 할당하면 데이터가 추가되고 사용중인 key에 데이터를 할당하면 데이터가 수정된다.
		hmap.put("melon", 99999);		// "melon" 이라는 key가 있으므로 데이터가 수정된다.
		System.out.println(hmap.size() + " : " + hmap);
		
//		get(key) : HashMap에 저장된 데이터 중에서 key에 해당되는 value를 얻어온다.
		System.out.println(hmap.get("water melon"));
		
//		remove(key) : HashMap에 저장된 데이터 중에서 key에 해당되는 value를 제거한다.
		hmap.remove("orange");
		System.out.println(hmap.size() + " : " + hmap);
		
//		keySet() : HashMap에 저장된 데이터에서 key에 해당되는 부분만 List 타입으로 얻어온다.
		System.out.println(hmap.keySet());
//		keySet() 메소드를 이용해서 각각의 key와 value 얻어오기
		for (String key : hmap.keySet()) {
			System.out.println("key : " + key + ", value : " + hmap.get(key));
		}
		
//		clear() : HashMap에 저장된 모든 데이터를 제거한다.
		hmap.clear();
		System.out.println(hmap.size() + " : " + hmap);
		
	}
	
}















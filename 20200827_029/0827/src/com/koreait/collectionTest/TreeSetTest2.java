package com.koreait.collectionTest;

import java.util.TreeSet;
import java.util.Iterator;

public class TreeSetTest2 {

	public static void main(String[] args) {
		
		TreeSet<String> tset = new TreeSet<String>();
		
		tset.add("홍길동");
		System.out.println(tset.size() + " : " + tset);
		tset.add("임꺽정");
		System.out.println(tset.size() + " : " + tset);
		tset.add("장길산");
		System.out.println(tset.size() + " : " + tset);
		tset.add("일지매");
		System.out.println(tset.size() + " : " + tset);
		tset.add("홍길동");
		System.out.println(tset.size() + " : " + tset);
		
//		Iterator 인터페이스는 HastSet 이나 TreeSet과 같이 입력하는 순서와 저장되는 순서가 달라서 get(), set() 메소드를 사용할 수 없는
//		객체를 iterator() 메소드로 분리해서 저장한다.
		Iterator<String> iterator = tset.iterator();
//		hasNext() : Iterator 인터페이스 객체에 다음에 읽을 데이터가 있으면 true, 없으면 false를 리턴한다.
		while (iterator.hasNext()) {
//			next() : Iterator 인터페이스 객체에서 다음 데이터를 읽어온다.
			System.out.println(iterator.next());
		}
		System.out.println("================================");
		
//		향상된 for를 사용해서 HastSet 이나 TreeSet의 데이터를 한 개씩 얻어올 수 있다.
		for (String str : tset) {
			System.out.println(str);
		}
		
		tset.remove("장길산");
		System.out.println(tset.size() + " : " + tset);
		tset.clear();
		System.out.println(tset.size() + " : " + tset);
		
	}
	
}
















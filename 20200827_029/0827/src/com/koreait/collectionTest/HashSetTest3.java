package com.koreait.collectionTest;

import java.util.HashSet;

public class HashSetTest3 {

	public static void main(String[] args) {
		
//		Person person = new Person();
//		System.out.println(person);
//		Person person2 = new Person("홍길동", 20);
//		System.out.println(person2);
		
		HashSet<Person> hset = new HashSet<Person>();
		
//		hset.add(person2);
//		System.out.println(hset.size() + " : " + hset);
//		같은 객체를 2번 이상 넣으면 중복되는 데이터로 인식해서 저장하지 않는다.
//		hset.add(person2);
//		System.out.println(hset.size() + " : " + hset);
		
//		new를 사용해서 객체를 생성하면 기존에 생성되었던 객체와 내용이 같더라도 다른 hashCode가 부여된다.
//		HashSet, TreeSet은 중복되는 데이터 판단을 hashCode로 하기 때문에 내용이 같더라도 다른 hashCode를 가지면 내용이 같은 객체도
//		다른 객체로 취급해서 내용이 같은 객체가 저장된다.
//		내용이 같은 객체를 같은 객체로 취급하게 하려면 hashCode() 메소드를 Override 해서 내용이 같은 객체는 같은 hashCode를 가지게
//		하면 된다.
		hset.add(new Person("홍길동", 20));
		System.out.println(hset.size() + " : " + hset);
		hset.add(new Person("홍길동", 20));
		System.out.println(hset.size() + " : " + hset);
		hset.add(new Person("홍길동", 35));
		System.out.println(hset.size() + " : " + hset);
		hset.add(new Person("홍길동", 27));
		System.out.println(hset.size() + " : " + hset);
		hset.add(new Person("임꺽정", 35));
		System.out.println(hset.size() + " : " + hset);
		hset.add(new Person("장길산", 54));
		System.out.println(hset.size() + " : " + hset);
		hset.add(new Person("일지매", 12));
		System.out.println(hset.size() + " : " + hset);
		
	}
	
}
















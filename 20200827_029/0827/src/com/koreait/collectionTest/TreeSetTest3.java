package com.koreait.collectionTest;

import java.util.TreeSet;

public class TreeSetTest3 {

	public static void main(String[] args) {
		
//		Person person = new Person();
//		System.out.println(person);
//		Person person2 = new Person("홍길동", 20);
//		System.out.println(person2);
		
		TreeSet<Person> tset = new TreeSet<Person>();
		
//		tset.add(person2);
//		System.out.println(tset.size() + " : " + tset);
//		같은 객체를 2번 이상 넣으면 중복되는 데이터로 인식해서 저장하지 않는다.
//		tset.add(person2);
//		System.out.println(tset.size() + " : " + tset);
		
//		new를 사용해서 객체를 생성하면 기존에 생성되었던 객체와 내용이 같더라도 다른 hashCode가 부여된다.
//		HashSet, TreeSet은 중복되는 데이터 판단을 hashCode로 하기 때문에 내용이 같더라도 다른 hashCode를 가지면 내용이 같은 객체도
//		다른 객체로 취급해서 내용이 같은 객체가 저장된다.
//		내용이 같은 객체를 같은 객체로 취급하게 하려면 hashCode() 메소드를 Override 해서 내용이 같은 객체는 같은 hashCode를 가지게
//		하면 된다.
		
//		TreeSet은 HashSet과 달리 데이터를 정렬시켜야 한다.
//		TreeSet에 저장할 데이터가 단순 데이터일 경우 자바가 알아서 오름차순으로 정렬시켜 주지만 클래스로 생성한 복합 데이터일 경우
//		TreeSet에 저장할 클래스를 설계할 때 Comparable 인터페이스를 구현하고 compareTo() 메소드를 Override 해서 정렬 기준으로 사용할
//		멤버 변수에 저장된 데이터를 비교하는 코딩을 해줘야 한다.
		
		tset.add(new Person("홍길동", 20));
		System.out.println(tset.size() + " : " + tset);
		tset.add(new Person("홍길동", 20));
		System.out.println(tset.size() + " : " + tset);
		tset.add(new Person("홍길동", 35));
		System.out.println(tset.size() + " : " + tset);
		tset.add(new Person("홍길동", 27));
		System.out.println(tset.size() + " : " + tset);
		tset.add(new Person("임꺽정", 35));
		System.out.println(tset.size() + " : " + tset);
		tset.add(new Person("장길산", 54));
		System.out.println(tset.size() + " : " + tset);
		tset.add(new Person("일지매", 12));
		System.out.println(tset.size() + " : " + tset);
		
	}
	
}
















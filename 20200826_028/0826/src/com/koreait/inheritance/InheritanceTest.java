package com.koreait.inheritance;

public class InheritanceTest {

	public static void main(String[] args) {
		
		Parent parent = new Parent();
		System.out.println(parent);
		Parent parent2 = new Parent("홍길동", true);
		System.out.println(parent2);
		System.out.println("======================================");
		
		Child child = new Child();
		System.out.println(child);
		Child child2 = new Child("성춘향", false, 16, "이쁜이");
		System.out.println(child2);
		
	}
	
}












package com.koreait.bookshop;

import java.util.Date;

public class BookShop {

	public static void main(String[] args) {
		
		/*
//		VO 클래스 테스트
		BookVO book1 = new BookVO();
		System.out.println(book1.toString());
//		클래스로 생성한 객체를 출력할때 객체 이름뒤에 toString() 메소드를 붙이지 않아도 자바가 알아서 붙여준다. 
		System.out.println(book1);
		
		BookVO book2 = new BookVO("JAVA", "홍길동", "코리아출판사", new Date(2015, 5, 15), 35000);
		System.out.println(book2);
		BookVO book3 = new BookVO("JAVA", "홍길동", "코리아출판사", new Date(2015, 5, 15), 35000);
		System.out.println(book3);
		
//		"=="를 사용해서 같은가 비교할 수 있는 데이터는 기본 자료형 8가지와 null만 가능하다.
//		String은 equals() 메소드만 사용하면 같은가 다른가 비교가 가능하지만 String을 제외한 나머지 클래스로 만든 객체는 equals() 메소드만
//		사용하면 hashcode(객체를 식별하기 위해 자바가 붙이는 의미없는 32비트의 숫자)를 비교하기 때문에 저장된 데이터가 같더라도 다르게 인식한다.
//		객체에 저장된 데이터가 같으면 같은 객체로 인식하게 하려면 저장된 데이터가 같을 경우 hashcode를 같게 만들면 되고 비교할 때는 객체에
//		저장된 실제 데이터를 비교하면 된다.

		if (book2.equals(book3)) {
			System.out.println("같다");
		} else {
			System.out.println("다르다");
		}
		*/
		
//		도서 정보를 저장할 클래스(BookList)의 객체를 만든다.
		BookList bookList = new BookList(5);
		
//		BookList 클래스 객체의 배열에 저장할 도서 정보를 만든다.
		BookVO book1 = new BookVO("JAVA", "홍길동", "코리아출판사", new Date(2015, 5, 15), 35000);
		BookVO book2 = new BookVO("JAVA", "홍길자", "코리아출판사", new Date(2015, 5, 15), 35000);
		BookVO book3 = new BookVO("JAVA", "홍길숙", "코리아출판사", new Date(2015, 5, 15), 35000);
		BookVO book4 = new BookVO("JAVA", "홍길희", "코리아출판사", new Date(2015, 5, 15), 35000);
		BookVO book5 = new BookVO("JAVA", "홍길영", "코리아출판사", new Date(2015, 5, 15), 35000);
		BookVO book6 = new BookVO("JAVA", "홍길도", "코리아출판사", new Date(2015, 5, 15), 35000);
		
//		BookList 클래스 객체의 bookList 배열에 도서 정보를 저장하는 메소드(addBook)를 실행한다.
		bookList.addBook(book1);
		bookList.addBook(book2);
//		bookList.addBook(book3);
//		bookList.addBook(book4);
//		bookList.addBook(book5);
//		bookList.addBook(book6);
		
		System.out.println(bookList);
		
	}
	
}












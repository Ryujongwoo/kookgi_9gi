package com.koreait.bookshop;

import java.util.Date;

public class BookShop {

	public static void main(String[] args) {
		
		BookList bookList = new BookList();
		
		BookVO book1 = new BookVO("JAVA", "홍길동", "코리아출판사", new Date(2015, 5, 15), 35000);
		BookVO book2 = new BookVO("JAVA", "홍길자", "코리아출판사", new Date(2015, 5, 15), 35000);
		BookVO book3 = new BookVO("JAVA", "홍길숙", "코리아출판사", new Date(2015, 5, 15), 35000);
		BookVO book4 = new BookVO("JAVA", "홍길희", "코리아출판사", new Date(2015, 5, 15), 35000);
		BookVO book5 = new BookVO("JAVA", "홍길영", "코리아출판사", new Date(2015, 5, 15), 35000);
		BookVO book6 = new BookVO("JAVA", "홍길도", "코리아출판사", new Date(2015, 5, 15), 35000);
		
		bookList.addBook(book1);
		bookList.addBook(book2);
		bookList.addBook(book3);
		bookList.addBook(book4);
		bookList.addBook(book5);
		bookList.addBook(book6);
		
		System.out.println(bookList);
		
	}
	
}












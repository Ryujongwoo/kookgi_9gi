package com.koreait.bookshop;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class BookList {

//	여러권의 책 정보를 저장할 ArrayList를 만든다.
	private ArrayList<BookVO> bookList = new ArrayList<BookVO>(); 
	
	public ArrayList<BookVO> getBookList() {
		return bookList;
	}
	public void setBookList(ArrayList<BookVO> bookList) {
		this.bookList = bookList;
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,##0원");
		
		String str = "";
		str += "=========================================================================\n";
		str += " 도서명  저자명  출판사명  출판일  가격 \n";
		str += "=========================================================================\n";
		
		double total = 0.0;
//		for (int i = 0; i < bookList.size(); i++) {
//			str += bookList.get(i) + "\n";
//			total += bookList.get(i).getPrice();
//		}
		
		for (BookVO vo : bookList) {
			str += vo + "\n";
			total += vo.getPrice();
		}
		
		str += "=========================================================================\n";
		str += "                                           합계금액 : " + df.format(total) + "\n";
		str += "=========================================================================\n";
		
		return str;
	}
	
	public void addBook(BookVO book) {

		bookList.add(book);
		
	}
	
}

















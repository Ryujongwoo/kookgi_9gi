package com.koreait.bookshop;

import java.text.DecimalFormat;
import java.util.Arrays;

import javax.swing.JOptionPane;

//	여러건의 데이터(책 여러권의 정보)를 기억하는 클래스
public class BookList {

	private BookVO[] bookList;		// 여러권의 책 정보를 기억할 배열을 선언한다.
	private int size;				// 배열의 크기
	private int index;				// 배열의 첨자, 배열에 저장된 데이터의 개수
	
//	기본 생성자가 실행되면 10권의 책 정보를 기억하는 배열을 만들고 배열의 크기를 넘겨받는 생성자가 실행되면 넘겨받은 크기만큼 배열을 만드는
//	생성자
	public BookList() {
//		size = 10;
//		bookList = new BookVO[size];
		this(10);		// BookList(int size) 생성자를 실행한다.
	}
	public BookList(int size) {
		super();
		this.size = size;
		bookList = new BookVO[size];
	}
	
//	getters & setters
	public BookVO[] getBookList() {
		return bookList;
	}
	public void setBookList(BookVO[] bookList) {
		this.bookList = bookList;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	
	@Override
	public String toString() {
//		return "BookList [bookList=" + Arrays.toString(bookList) + "]";
		
		DecimalFormat df = new DecimalFormat("#,##0원");
		
		String str = "";
		str += "=========================================================================\n";
		str += " 도서명  저자명  출판사명  출판일  가격 \n";
		str += "=========================================================================\n";
		
		double total = 0.0;
		for (int i = 0; i < bookList.length; i++) {
			if (bookList[i] == null) {
				break;
			}
			str += bookList[i] + "\n";
			total += bookList[i].getPrice();
		}
		
//		for (BookVO vo : bookList) {
//			if (vo == null) {
//				break;
//			}
//			str += vo + "\n";
//			total += vo.getPrice();
//		}
		
		str += "=========================================================================\n";
		str += "                                           합계금액 : " + df.format(total) + "\n";
		str += "=========================================================================\n";
		
		return str;
	}
	
//	BookList의 bookList 배열에 인수로 넘겨받은 도서 정보를 저장하는 메소드
	public void addBook(BookVO book) {

		/*
//		if를 사용하는 전통적인 예외처리 => 배열의 인덱스는 배열의 크기보다 커지면 안된다.
		if (index < size) {
			bookList[index++] = book;
		} else {
			System.out.println("배열이 가득차서 " + book.getAuthor() + "의 책 정보를 저장할 수 없습니다.");
//			JOptionPane.showMessageDialog(null, "배열이 가득차서 " + book.getAuthor() + "의 책 정보를 저장할 수 없습니다.");
		}
		*/
		
//		자바의 예외(Exception) 처리 => try ~ catch ~ finally
//		예외가 발생될것으로 예상되는 문장을 try 블록에 적는다.
//		지정된 예외가 발생되면 실행할 문장을 catch 블록에 적는다.
//		try 블록의 문장을 실행하다 예외가 발생되면 더 이상 try 블록의 문장을 실행하지 않고 해당 예외의 catch 블록의 문장을 실행한다.
//		선택적으로 예외 발생 여부와 관계없이 무조건 실행해야 할 문장이 있다면 finally 블록에 적는다.
		
		try {
			bookList[index++] = book;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("배열이 가득차서 " + book.getAuthor() + "의 책 정보를 저장할 수 없습니다.");
		} catch (Exception e) {
//			예외를 처리하는 클래스는 모두 Exception 클래스를 상속받아 만들어졌기 때문에 catch 블록에 Exception 클래스를 사용하면 모든 예외를
//			처리할 수 있다. => Exception 클래스를 사용하려면 반드시 맨 마지막 catch 블록에 사용해야 한다.
//			e.getMessage() : 예외 메시지만 얻어온다.
			System.out.println(e.getMessage());
//			e.printStackTrace() : 예외가 발생된 문장을 역순으로 추적한다.
			e.printStackTrace();
		} finally {
//			System.out.println("까꿍~~~~~~~~~~~~~~");
		}
		
	}
	
}

















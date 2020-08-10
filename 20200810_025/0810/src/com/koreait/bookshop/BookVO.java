package com.koreait.bookshop;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

//	VO(Value Object) 클래스 => 1건의 데이터를 기억하는 클래스, DTO(Data Transfer Object), bean
//	bean => 처리할 데이터를 기억하는 멤버 변수(필드)와 멤버 변수의 데이터를 입출력할 수 있는 getters & setters 메소드로만 구성된 클래스
public class BookVO {

//	데이터를 기억할 멤버 변수를 만든다. => 멤버 변수는 클래스 내부의 모든 메소드에서 사용할 수 있다.
	
	private String title;		// 도서명
	private String author;		// 저자명
	private String publisher;	// 출판사명
	private Date date;			// 출판일
	private double price;		// 가격
	
//	생성자 메소드(이하 생성자)를 선언한다.
//	생성자 이름은 반드시 클래스 이름과 같아야 한다.
//	생성자는 리턴 타입을 사용하지 않고 생성자 내부에서 return도 사용하지 않는다.
//	생성자는 객체가 생성될 때 자동으로 실행되며 멤버 변수를 초기화 시킬 목적으로 주로 사용된다.
//	생성자를 정의하지 않으면 컴파일러가 자동을 아무런 일도 하지 않는 기본 생성자를 만들어주고 생성자를 정의하면 기본 생성자를 만들지 않는다.
	
	public BookVO() {
		/*
		title = "없음";
		author = "없음";
		publisher = "없음";
		date = new Date();
		price = 0.0;
		*/
//		BookVO(String title, String author, String publisher, Date date, double price) 생성자를 호출해서 초기화 한다.
		this("없음", "없음", "없음", new Date(), 0.0);
	}

	public BookVO(String title, String author, String publisher, Date date, double price) {
//		super();를 생략하면 자바 컴파일러가 자동으로 붙여준다.
//		super()			// 부모 클래스의 생성자를 의미한다. => 부모 클래스의 기본 생성자
//		this()			// 현재 클래스의 다른 생성자를 의미한다. => 현재 클래스의 기본 생성자
//		super()와 this()는 반드시 생성자의 첫 문장으로 사용해야 한다. => 동시에 사용할 수 없다.
//		super			// 부모 클래스를 의미한다.
//		this			// 현재 클래스를 의밓한다.
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		
//		인수로 넘어온 date 저장된 날짜 데이터에서 년은 1900을 월은 1을 빼준다.
		date.setYear(date.getYear() - 1900);
		date.setMonth(date.getMonth() - 1);
		
		this.date = date;
		this.price = price;
	}
	
//	getters & setters 메소드를 정의한다.
//	getters & setters 메소드는 private 권한이 설정된 멤버 변수에 클래스 외부에서 접근할 수 있도록 예외 규정을 만든다.
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

//	객체에 저장된 데이터를 출력하려면 toString() 메소드를 Override 한다.
	
	@Override
	public String toString() {
//		return "BookVO [title=" + title + ", author=" + author + ", publisher=" + publisher + ", date=" + date
//				+ ", price=" + price + "]";
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd(E)");
		
//		NumberFormat 클래스로 숫자 출력 서식 지정하기 => 미리 제작되서 제공되는 서식만 사용할 수 있다.
//		NumberFormat nf = NumberFormat.getNumberInstance();		// 천 단위 "," 출력
//		NumberFormat nf = NumberFormat.getCurrencyInstance();	// 통화 표시(￦)와 천 단위 "," 출력
//		NumberFormat nf = NumberFormat.getPercentInstance();	// 백분율 표시(%)와 천 단위 "," 출력 => 숫자에 100이 곱해져서 출력된다.
		
//		DecimalFormat 클래스로 숫자 출력 서식 지정하기 => 사용자가 직접 서식을 만들어 사용할 수 있다.
//		DecimalFormat df = new DecimalFormat("출력서식");
//		출력 서식은 "#,##0"을 입력하고 앞, 뒤로 서식 표현에 사용하고 싶은 문자를 직접 입력하면 된다.
//		DecimalFormat df = new DecimalFormat("#,##0");			// NumberFormat.getNumberInstance()
//		DecimalFormat df = new DecimalFormat("￦#,##0");		// NumberFormat.getCurrencyInstance()
//		DecimalFormat df = new DecimalFormat("#,##0%");			// NumberFormat.getPercentInstance()
//		소수점 아래 자리수는 보고싶은 만큼 "."을 입력하고 "0"을 적어넣으면 된다.
//		DecimalFormat df = new DecimalFormat("$#,##0.00");
		DecimalFormat df = new DecimalFormat("#,##0원");
		
		return String.format("%s %s %s %s %s", title, author, publisher, sdf.format(date), df.format(price));
	}
	
//	객체에 저장된 데이터를 비교해야 한다면 hashCode() 메소드와 equals() 메소드를 Override 한다.
//	hashCode() 메소드와 equals() 메소드는 따로따로 Override 시켜 사용하는 것이 아니고 한꺼번에 Override 시켜 사용해야 한다.
	
	@Override
//	저장된 내용이 같으면 같은 hashCode를 만들어 주는 메소드
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((publisher == null) ? 0 : publisher.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
//	객체에 저장된 실제 데이터를 비교하는 메소드
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookVO other = (BookVO) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (publisher == null) {
			if (other.publisher != null)
				return false;
		} else if (!publisher.equals(other.publisher))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
}













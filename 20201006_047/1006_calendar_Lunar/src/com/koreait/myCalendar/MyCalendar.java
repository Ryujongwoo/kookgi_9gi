package com.koreait.myCalendar;

//	달력 작업에 필요한 메소드를 모아놓은 클래스
public class MyCalendar {

//	년을 인수로 넘겨받아 윤년, 평년을 판단해 윤년은 true, 평년은 false를 리턴하는 메소드
	public static boolean isLeapYear(int year) {
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	}
	
//	년, 월을 인수로 넘겨받아 그 달의 마지막 날짜를 리턴하는 메소드
	public static int lastDay(int year, int month) {
		int[] m = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		m[1] = isLeapYear(year) ? 29 : 28;
		return m[month - 1];
	}
	
//	년, 월, 일을 인수로 넘겨받아 1년 1월 1일 부터 지나온 날짜의 합계를 리턴하는 메소드
	public static int totalDay(int year, int month, int day) {
		int total = (year - 1) * 365 + (year - 1) / 4 - (year - 1) / 100 + (year - 1) / 400;
		for (int i = 1; i < month; i++) {
			total += lastDay(year, i);
		}
		return total + day;
	}
	
//	년, 월, 일을 인수로 념겨받아 요일을 숫자로 리턴하는 메소드, 일요일(0), 월요일(1), ..., 금요일(5), 토요일(6)
	public static int weekDay(int year, int month, int day) {
		return totalDay(year, month, day) % 7;
	}
	
}

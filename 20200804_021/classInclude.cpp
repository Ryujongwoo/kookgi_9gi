#include "config.h"
#include "date_s.h"

//	기본 생성자로 객체를 생성하면 컴퓨터 시스템의 날짜로 초기화시키고 년, 월, 일을 넘겨받는 생성자로 객체를 생성하면 넘겨받은 인수로
//	초기화시키는 클래스
class Date {
private:
public:
	int year = 0, month = 0, day = 0;
	Date() {
		year = getYear();
		month = getMonth();
		day = getDate();
	}
	Date(int year, int month, int day) {
		this->year = year;
		this->month = month;
		this->day = day;
	}
	void toString() {
		cout << year << "년 " << month << "월 " << day << "일" << endl;
	}
};

//	기본 생성자로 객체를 생성하면 컴퓨터 시스템의 시간으로 초기화시키고 시, 분, 초를 넘겨받는 생성자로 객체를 생성하면 넘겨받은 인수로
//	초기화시키는 클래스
class Time {
private:
public:
	int hour = 0, minute = 0, second = 0;
	Time() {
		hour = getHour();
		minute = getMinute();
		second = getSecond();
	}
	Time(int hour, int minute, int second) {
		this->hour = hour;
		this->minute = minute;
		this->second = second;
	}
	void toString() {
		cout << hour << ":" << minute << ":" << second << endl;
	}
};

//	클래스 포함 기능을 이용해 now 클래스를 만든다.
//	클래스 포함이란 클래스의 멤버로 다른 클래스의 객체를 가질 수 있다는 의미이다.
class Now {
private:
	Date date;			// 클래스 포함
	Time time;			// 클래스 포함
public:
	Now() { }
	Now(Date date, Time time) {
		this->date = date;
		this->time = time;
	}
	Now(int year, int month, int day, int hour, int minute, int second) {
		Date date(year, month, day);
		this->date = date;
		Time time(hour, minute, second);
		this->time = time;
	}
	void toString() {
		cout << "지금은 " << date.year << "년 " << date.month << "월 " << date.day << "일 " << time.hour << "시 " << time.minute << "분 "
			<< time.second << "초 입니다." << endl;
	}
};

void main() {

	Date date1;
	date1.toString();
	Date date2(2020, 12, 10);
	date2.toString();

	Time time1;
	time1.toString();
	Time time2(17, 50, 1);
	time2.toString();

	Now now1;
	now1.toString();
	Now now2(date2, time2);
	now2.toString();
	Now now3(2020, 12, 10, 17, 50, 1);
	now3.toString();

}
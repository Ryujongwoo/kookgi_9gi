#include "config.h"
#include "date_s.h"

//	private 권한으로 설정된 멤버 변수에 클래스 외부에서 접근이 가능하도록 예외 규정을 주는 방법으로 getters & setters 함수를 만들어 사용하는
//	방법과 friend를 설정하는 방법이 있다.
//	getters & setters 함수는 특정 멤버를 선택해서 선택적으로 예외 규정을 주는 방법이고 friend는 클래스의 모든 멤버 변수에 대해서 일괄적으로
//	예외 규정을 주는 방법으로 자식 클래스로 상속되지 않는다.
//	friend를 설정하는 방법은 클래스 내부에 특별하게 정해진 위치는 없고 가독성 향상을 위해서 보통 클래스의 맨 앞이나 뒤에 설정한다.
//	friend를 설정하는 방법은 friend로 설정할 함수의 원형을 쓰고 앞에 friend만 붙여주면 된다.

class Time;			// Time 클래스의 전방 선언 => 컴파일러에게 Time이 클래스임을 알려준다.
class Date {

	friend void today(Date, Time);

private:
	int year = 0, month = 0, day = 0;
public:
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

class Time {

	friend void today(Date, Time);

private:
	int hour = 0, minute = 0, second = 0;
public:
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

//	외부 함수
void today(Date date, Time time) {
	cout << "지금은 " << date.year << "년 " << date.month << "월 " << date.day << "일 " << time.hour << "시 " << time.minute << "분 "
		<< time.second << "초 입니다." << endl;
}

void main() {

	Date date;
	Time time;
	today(date, time);

}
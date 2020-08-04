#include "config.h"
#include "date_s.h"

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

//	다중 상속이란 두 개 이상의 부모 클래스로 부터 상속받는 것을 말한다.
//	Date 클래스와 Time 클래스를 상속받아 Now 클래스를 만든다.
class Now : public Date, public Time {
private:
public:
//	Date 클래스와 Time 클래스로 부터 모두 상속받은 toString() 함수를 override 해서 사용한다.
	void toString() {
		cout << "지금은 " << year << "년 " << month << "월 " << day << "일 " << hour << "시 " << minute << "분 "
			<< second << "초 입니다." << endl;
	}
};

void main() {

	Now now;
//	Now 클래스는 Date 클래스와 Time 클래스로 부터 모두 toString() 함수를 상속받았다.
//	아래와 같이 toString() 함수를 실행하면 어떤 클래스로 부터 상속받은 함수를 실행해야 할 지 결정할 수 없는 상태가 되므로 함수가 모호하다며
//	에러를 발생시킨다.
//	이러한 문제점을 해결하는 방법은 다중 상속을 받은 자식 클래스에서 2개 이상의 클래스에서 상속받은 함수를 override 하면 해결된다.
	now.toString();
	
//	여러 클래스로 부터 같은 이름의 함수를 상속받은 경우 자식 클래스에서 어떤 클래스에서 상속받은 함수를 실행할 것인지 "소속클래스::"를
//	붙여서 어떤 부모 클래스의 함수인지를 명시해 주면 된다.
	now.Date::toString();		// Date 클래스에서 상속받은 toString() 함수를 실행한다.
	now.Time::toString();		// Time 클래스에서 상속받은 toString() 함수를 실행한다.

}
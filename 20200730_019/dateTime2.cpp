#include "config.h"
#include "date.h"

void main() {

	cout << "년 : " << getYear() << endl;
	cout << "월 : " << getMonth() << endl;
	cout << "일 : " << getDate() << endl;
	cout << "시 : " << getHour() << endl;
	cout << "분 : " << getMinute() << endl;
	cout << "초 : " << getSecond() << endl;
	cout << "요일(숫자) : " << getDay() << endl;
	cout << "요일(문자) : " << getWeekDay() << endl;

}
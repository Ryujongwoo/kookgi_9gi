#include <time.h>

tm getCurrentTime() {
	time_t timer = (unsigned)time(NULL);
//	tm* t = localtime(&timer);
	tm t;
	localtime_s(&t, &timer);
	return t;
}

int getYear() { // 년
	return getCurrentTime().tm_year + 1900;
}

int getMonth() { // 월
	return getCurrentTime().tm_mon + 1;
}

int getDate() { // 일
	return getCurrentTime().tm_mday;
}

int getHour() { // 시간
	return getCurrentTime().tm_hour;
}

int getMinute() { // 분
	return getCurrentTime().tm_min;
}

int getSecond() { // 초
	return getCurrentTime().tm_sec;
}

int getDay() {  // 요일 => 숫자
	return getCurrentTime().tm_wday;
}

//	요일을 문자열로 리턴하는 함수
const char* getWeekDay() {
	const char* week[] = { "일", "월", "화", "수", "목", "금", "토" };
	return week[getDay()];
}
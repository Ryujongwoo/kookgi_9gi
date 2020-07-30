#include "config.h"
#include <time.h>

void main() {

	/*
//	time.h 헤더 파일에 정의된 tm 구조체로 날짜 및 시간을 처리할 수 있도록 선언된 자료형 time_t의 변수를 선언한다.
	time_t timer;
//	tm 구조체의 포인터 변수를 선언한다.
	tm* t;
//	컴퓨터 시스템의 현재 날짜와 시간 정보를 구조체 time_t 변수에 넣어준다.
	timer = (unsigned)time(NULL);
//	c언어는 localtime() 함수를 사용해서 유닉스 타임을 년, 월, 일, 시, 분, 초 단위로 구분해서 tm 구조체의 각 멤버 변수에 넣어준다.
	t = localtime(&timer);
	*/


//	유닉스 타임은 1970년 1월 1일 자정부터 time(NULL) 함수가 실행되는 순간까지의 시간을 초 단위로 얻어온다.
//	printf("%d\n", (unsigned)time(NULL));
	time_t timer = (unsigned)time(NULL);
	tm* t = localtime(&timer);

//	c/c++에서 년도는 1900년을 기준으로 처리하기 때문에 년도를 얻어올 때는 1900을 더해서 얻어와야 한다.
	cout << "년 : " << t->tm_year + 1900 << endl;
//	우리는 1 ~ 12월 이지만 컴퓨터는 0 ~ 11월로 처리하기 때문에 월을 얻어올 때는 1을 더해서 얻어와야 한다.
	cout << "월 : " << t->tm_mon + 1 << endl;
	cout << "일 : " << t->tm_mday << endl;
	cout << "시 : " << t->tm_hour << endl;
	cout << "분 : " << t->tm_min << endl;
	cout << "초 : " << t->tm_sec << endl;
	cout << "요일 : " << t->tm_wday << endl;
	cout << "1월 1일 부터 지난 날짜 : " << t->tm_yday << endl;
	cout << "일광 시간 절약제 실시 여부 : " << t->tm_isdst << endl;

}
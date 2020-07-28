#include "config.h"
#include "calendar.h"

void main() {

//	cout << isLeapYear(2020) << endl;
//	cout << lastDay(2020, 2) << endl;
//	cout << totalDay(2020, 7, 27) << endl;
//	cout << weekDay(2020, 7, 27) << endl;

	int year, month;
	printf("달력을 출력할 년, 월을 입력하세요 : ");
	scanf_s("%d %d", &year, &month);

	printf("============================\n");
	printf("         %4d년%2d월\n", year, month);
	printf("============================\n");
	printf(" 일  월  화  수  목  금  토 \n");
	printf("============================\n");

//	출력하기 시작할 전달 날짜를 계산한다.
	int week = weekDay(year, month, 1);
	int start = 0;
	if (month == 1) {
		start = 31 - week; // 1월
	}
	else {
		start = lastDay(year, month - 1) - week; // 2 ~ 12월
	}

//	1일이 출력될 요일의 위치를 맞추기 위해 1일의 요일만큼 반복하며 빈 칸을 출력한다. => 전 달 날짜를 출력한다.
	for (int i = 0; i < week; i++) {
//		printf("    ");
		printf(" %2d ", ++start);
	}

//	1일 부터 달력을 출력할 달의 마지막 날짜까지 반복하며 날짜를 출력한다.
	for (int i = 1; i <= lastDay(year, month); i++) {
		printf(" %2d ", i);
		if (weekDay(year, month, i) == 6 && i != lastDay(year, month)) {
			printf("\n");
		}
	}

//	마지막 날짜를 출력하고 남는 칸에 다음달 1일의 요일부터 토요일까지 반복하며 다음달의 날짜를 출력한다.
	if (month == 12) {
		week = weekDay(year + 1, 1, 1); // 12월
	}
	else {
		week = weekDay(year, month + 1, 1); // 1 ~ 11월
	}
	
	if (weekDay(year, month, lastDay(year, month)) != 6) {
		start = 1;
		for (int i = week; i <= 6; i++) {
			printf(" %2d ", start++);
		}
	}

	printf("\n============================\n");

}
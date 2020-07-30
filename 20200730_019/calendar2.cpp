#include "config.h"
#include "calendar.h"
#include "date_s.h"

void main() {

	int n;
	printf("이번달 => 1, 특정달 => 2 : ");
	scanf_s("%d", &n);

	int year, month;
	if (n == 1) {
		year = getYear();
		month = getMonth();
	}
	else {
		printf("달력을 출력할 년, 월을 입력하세요 : ");
		scanf_s("%d %d", &year, &month);
	}

	printf("============================\n");
	printf("         %4d년%2d월\n", year, month);
	printf("============================\n");
	printf(" 일  월  화  수  목  금  토 \n");
	printf("============================\n");

	int week = weekDay(year, month, 1);
	int start = 0;
	if (month == 1) {
		start = 31 - week;
	}
	else {
		start = lastDay(year, month - 1) - week;
	}
	for (int i = 0; i < week; i++) {
		printf(" %2d ", ++start);
	}

	for (int i = 1; i <= lastDay(year, month); i++) {
		printf(" %2d ", i);
		if (weekDay(year, month, i) == 6 && i != lastDay(year, month)) {
			printf("\n");
		}
	}

	if (month == 12) {
		week = weekDay(year + 1, 1, 1);
	}
	else {
		week = weekDay(year, month + 1, 1);
	}
	if (weekDay(year, month, lastDay(year, month)) != 6) {
		start = 1;
		for (int i = week; i <= 6; i++) {
			printf(" %2d ", start++);
		}
	}
	printf("\n============================\n");

}
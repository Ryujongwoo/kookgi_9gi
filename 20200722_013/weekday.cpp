#include "config.h"

void main() {

	int year, month, day;

	//	printf("요일을 계산할 년, 월, 일을 입력하세요 : ");
	//	scanf_s("%d %d %d", &year, &month, &day);
	//	printf("%d %d %d", year, month, day);

	cout << "요일을 계산할 년, 월, 일을 입력하세요 : ";
	cin >> year >> month >> day;
	cout << year << " " << month << " " << day << endl;

	//	1년 1월 1일 부터 전년도 12월 31일 까지 지난 날짜를 계산한다.
	int sum = (year - 1) * 365 + (year - 1) / 4 - (year - 1) / 100 + (year - 1) / 400;

	//	전년도 12월 31일 까지 지난 날짜에 전달 까지의 마지막 날짜를 더한다.
	int m[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	m[1] = year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ? 29 : 28;
	for (int i = 1; i < month; i++) {
		sum += m[i - 1];
		/*
		switch (i) {
			case 2: // 2월
				sum += year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ? 29 : 28;
				break;
			case 4: case 6: case 9: case 11: // 짧은달
				sum += 30;
				break;
//			case 1: case 3: case 5: case 7: case 8: case 10: case 12: // 긴달 => 기타 등등 case
			default:
				sum += 31;
				break;
		}
		*/
	}

	//	전달 까지 날짜의 합계에 일을 더한다.
	sum += day;
	cout << sum % 7 << endl;

	//	요일을 출력한다.
		/*
		switch (sum % 7) {
			case 0: cout << "일요일" << endl; break;
			case 1: cout << "월요일" << endl; break;
			case 2: cout << "화요일" << endl; break;
			case 3: cout << "수요일" << endl; break;
			case 4: cout << "목요일" << endl; break;
			case 5: cout << "금요일" << endl; break;
			case 6: cout << "토요일" << endl; break;
		}
		*/

//	문자열을 기억하는 배열은 char(문자) 배열의 이름 앞에 "*"를 붙이면 된다.
//	2018년 가을 비쥬얼 스튜디오 2017이 업데이트 되면서 문자열 상수를 기억하는 배열 선언시 char 앞에 반드시
//	const를 붙여야 에러가 발생되지 않고 정상적으로 처리된다.
	const char* week[] = { "일", "월", "화", "수", "목", "금", "토" };
	printf("%s요일\n", week[sum % 7]);
	cout << week[sum % 7] << "요일" << endl;

}
#include "config.h"

void main() {

	/*
	if (조건식) {
		조건식이 참일 경우 실행할 문장;
		...;
	} else {
		조건식이 거짓일 경우 실행할 문장;
		...;
	}
	*/

	int age;

	/*
//	printf("나이를 입력하세요 : ");
//	scanf_s("%d", &age);
	cout << "나이를 입력하세요 : ";
	cin >> age;

	if (age >= 19) {
		printf("성인입니다. 어서오세요\n");
	}
	else {
		printf("미성년자입니다. 애들은 가라~~~~~\n");
	}
	*/
	/*
//	c언어는 프로그램에서 사용할 변수를 프로그램 상단에서 미리 선언을하고 사용해야 했지만 c++ 부터는 변수가 필요한
//	순간 만들어서 사용하면 된다.
	int cpp, java, jsp;

//	printf("3과목 점수를 입력하세요 : ");
//	scanf_s("%d %d %d", &cpp, &java, &jsp);
	cout << "3과목 점수를 입력하세요 : ";
	cin >> cpp >> java >> jsp;

	int total = cpp + java + jsp;
	double average = (double) total / 3;

//	printf("총점 : %d, 평균 : %.2f\n", total, average);
	cout << "총점 : " << total << ", 평균 : " << average << endl;
	*/
	/*
	if (average >= 90) {
		printf("평균 점수 %f는 %c 등급 입니다.\n", average, 'A');
	}
	if (average < 90 && average >= 80) {
		printf("평균 점수 %f는 %c 등급 입니다.\n", average, 'B');
	}
	if (average < 80 && average >= 70) {
		printf("평균 점수 %f는 %c 등급 입니다.\n", average, 'C');
	}
	if (average < 70 && average >= 60) {
		printf("평균 점수 %f는 %c 등급 입니다.\n", average, 'D');
	}
	if (average < 60) {
		printf("평균 점수 %f는 %c 등급 입니다.\n", average, 'F');
	}
	*/

	/*
	if (average >= 90) {
		printf("평균 점수 %f는 %c 등급 입니다.\n", average, 'A');
	} else if (average < 90 && average >= 80) {
		printf("평균 점수 %f는 %c 등급 입니다.\n", average, 'B');
	} else if (average < 80 && average >= 70) {
		printf("평균 점수 %f는 %c 등급 입니다.\n", average, 'C');
	} else if (average < 70 && average >= 60) {
		printf("평균 점수 %f는 %c 등급 입니다.\n", average, 'D');
	} else if (average < 60) {
		printf("평균 점수 %f는 %c 등급 입니다.\n", average, 'F');
	}
	*/
	/*
	if (average >= 90) {
		printf("평균 점수 %f는 %c 등급 입니다.\n", average, 'A');
	} else if (average >= 80) {
		printf("평균 점수 %f는 %c 등급 입니다.\n", average, 'B');
	} else if (average >= 70) {
		printf("평균 점수 %f는 %c 등급 입니다.\n", average, 'C');
	} else if (average >= 60) {
		printf("평균 점수 %f는 %c 등급 입니다.\n", average, 'D');
	} else {
		printf("평균 점수 %f는 %c 등급 입니다.\n", average, 'F');
	}
	*/

	int year;

//	printf("윤년, 평년을 판단할 년도를 입력하세요 : ");
//	scanf_s("%d", &year);
	cout << "윤년, 평년을 판단할 년도를 입력하세요 : ";
	cin >> year;

//	윤년, 평년 판별식
//	년도가 4로 나눠 떨어지고 100으로 나눠떨어지지 않거나 400으로 나눠 떨어지면 윤년, 그렇치 않으면 평년

//	프로그램에서 여러번 사용되는 값은 변수에 저장해서 사용하면 편리하다.
//	논리값을 기억하는 변수나 결과(리턴) 값이 논리값인 함수의 이름은 "is"로 시작하는 것이 관행이다.
//	int isLeapYear = year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	bool isLeapYear = year % 4 == 0 && year % 100 != 0 || year % 400 == 0;

	if (isLeapYear) {
		printf("%d 년은 윤년입니다.\n", year);
		cout << year << " 년은 윤년입니다." << endl;
	}
	else {
		printf("%d 년은 평년입니다.\n", year);
		cout << year << " 년은 평년입니다." << endl;
	}

//	삼항 연산자 => ?: => 간단한 if, 조건이 참이나 거짓일 때 실행할 문장이 딱 1개씩인 경우 사용하면 편리하다.
//	형식 => 조건식 ? 조건식이 참일 때 실행할 문장 : 조건식이 거짓일 때 실행할 문장
//	파이썬 형식 => 조건식이 참일 때 실행할 문장 if 조건식 else 조건식이 거짓일 때 실행할 문장

	printf("%d 년은 %s년입니다.\n", year, isLeapYear ? "윤" : "평");
	cout << year << " 년은 " << (isLeapYear ? "윤" : "평") << "년입니다." << endl;

}
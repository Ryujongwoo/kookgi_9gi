#include "config.h"

void main() {

	char data[11];
	printf("문자열을 입력하세요 : ");
	scanf_s("%s", data, sizeof(data));

//	무조건 소문자로 변경하기
	for (int i = 0; data[i] != '\0'; i++) {
		/*
		if (data[i] >= 'A' && data[i] <= 'Z') { // 대문자인가?
//			대문자를 소문자로 변경한다.
			data[i] += 32;
		}
		*/
//		tolower() 함수는 인수로 지정된 영문자를 소문자로 변환한다.
		data[i] = tolower(data[i]);
	}
	printf("무조건 소문자로 변환 : %s\n", data);

//	무조건 대문자로 변경하기
	for (int i = 0; data[i] != '\0'; i++) {
		/*
		if (data[i] >= 'a' && data[i] <= 'z') { // 소문자인가?
//			소문자를 대문자로 변경한다.
			data[i] -= 32;
		}
		*/
//		toupper() 함수는 인수로 지정된 영문자를 대문자로 변환한다.
		data[i] = toupper(data[i]);
	}
	printf("무조건 대문자로 변환 : %s\n", data);
	printf("===============================\n");

//	_strlwr_s() 함수는 인수로 지정된 문자열을 한꺼번에 소문자로 변환한다. => 별도로 저장시키지 않아도 변경 내용이 바로 적용된다.
	_strlwr_s(data);
	printf("무조건 소문자로 변환 : %s\n", data);
//	_strupr_s() 함수는 인수로 지정된 문자열을 한꺼번에 대문자로 변환한다. => 별도로 저장시키지 않아도 변경 내용이 바로 적용된다.
	_strupr_s(data);
	printf("무조건 대문자로 변환 : %s\n", data);
	printf("===============================\n");

//	문자열은 "=="로 비교하면 안된다.
	printf("%s\n", data == "QUIT" ? "같다" : "다르다");

//	strcmp(문자열1, 문자열2) : 인수로 지정된 2개의 문자열을 비교해서 문자열1이 크면 1을 문자열 2가 크면 -1을 같으면 0을 리턴한다.
//	printf("%d\n", strcmp(data, "B"));
	printf("%s\n", strcmp(data, "QUIT") == 0 ? "같다" : "다르다");
	printf("%s\n", !strcmp(data, "QUIT") ? "같다" : "다르다");

}
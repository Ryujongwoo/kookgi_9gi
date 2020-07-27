#include "config.h"

void main() {

	int s;				// 2진수를 입력받을 변수
	int dec = 0;

	printf("2진수를 입력하세요 : ");
	scanf_s("%d", &s);

	for (int p = 7; p >= 1; p--) {
		int k = pow(2, 7 - p);
		dec += k * (s % 10);
		s /= 10;
	}

	printf("부호 : %d\n", s);
	if (s != 0) {
		dec = 128 - dec;
		dec *= -1;
	}

	printf("10진수 : %d\n", dec);

}
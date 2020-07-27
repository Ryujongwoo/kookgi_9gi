#include "config.h"

void main() {

	char s[9];			// 2진수를 입력받을 문자 배열
	int dec = 0;

//	26 => 00011010, -26 => 11100110
	printf("2진수를 입력하세요 : ");
	scanf_s("%s", s, sizeof(s));
//	printf("%s\n", s);

	for (int p = 1; p < 8; p++) {
//		printf("%d\n", p);
		int k = pow(2, 7 - p);
		dec += k * (s[p] - 48);
	}

	if (s[0] != '0') {	// 부호 bit가 1일 경우 음수이므로 음수 처리를 한다.
		dec = 128 - dec;
		dec *= -1;
	}

	printf("10진수 : %d\n", dec);

}
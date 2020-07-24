#include "config.h"

//	10진수 => 2, 8, 16 진법
void main() {

	int dec, bin[8] = { 0 };
	int arraySize = sizeof(bin) / sizeof(int);
	int n;		// 변환하려는 진법을 입려받는 변수

	printf("10진수와 변환할 진법을 입력하세요 : ");
	scanf_s("%d %d", &dec, &n);

	int i = 0;
	while (true) {
		int mok = dec / n;
		bin[i++] = dec % n;
		if (mok == 0) {
			break;
		}
		dec = mok;
	}

//	16진수를 기억하는 배열을 이용해 출력한다.
	char hex[] = "0123456789ABCDEF";

	for (int i = arraySize - 1; i >= 0; i--) {
//		bin 배열은 hex의 인덱스로 사용된다.
//		printf("%c", hex[bin[i]]);
		cout << hex[bin[i]];
	}
	printf("\n");

//	bin 배열에 저장된 숫자가 10 미만이면 그대로 출력하고 10 이상이면 문자로 바꿔 출력한다.
	for (int i = arraySize - 1; i >= 0; i--) {
		if (bin[i] < 10) {
//			printf("%d", bin[i]);
			cout << bin[i];
		}
		else {
//			printf("%c", bin[i] + 55);
			cout << (char)(bin[i] + 55);
		}
	}

}
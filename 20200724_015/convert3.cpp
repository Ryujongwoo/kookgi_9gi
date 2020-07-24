#include "config.h"

void main() {

	int dec, n;
	printf("10진수와 변환할 진법을 입력하세요 : ");
	scanf_s("%d %d", &dec, &n);

//	10진수를 입력받아 n진법으로 변환할 때 필요한 배열의 크기를 계산하고 그 크기만큼 배열을 동적으로 선언한다.
	int x = 0;
	while (true) {
		if (dec < pow(n, x)) {
			break;
		}
		x++;
	}
//	printf("배열의 크기 : %d\n", x);

//	배열의 크기만큼 배열을 동적으로 선언한다.
//	int* bin = (int*)malloc(sizeof(int) * x);
	int* bin = new int[x];
	memset(bin, 0, _msize(bin));

	/*
	int i = 0;
	while (true) {
		int mok = dec / n;
		bin[i++] = dec % n;
		if (mok == 0) {
			break;
		}
		dec = mok;
	}
	*/

	for (int i = 0; i < x; i++) {
		int mok = dec / n;
		bin[i] = dec % n;
		dec = mok;
	}

	for (int i = x - 1; i >= 0; i--) {
		if (bin[i] < 10) {
			cout << bin[i];
		}
		else {
			cout << (char)(bin[i] + 55);
		}
	}

}
#include "config.h"

//	10진수 => 2진수
void main() {

	int dec;				// 10진수를 입력받을 변수
	int bin[16] = { 0 };	// 변환된 진법의 수를 기억할 배열

//	배열의 크기를 계산한다. => 몇 개의 데이터를 저장할 수 있는가 계산한다.
	int arraySize = sizeof(bin) / sizeof(int);
	printf("배열의 크기 : %d\n", arraySize);

	printf("10진수 : ");
	scanf_s("%d", &dec);

//	10진수를 변환하려는 진법의 수로 나눈 몫이 0이 될 때 까지 반복한다.
	int i = 0;				// dec 배열의 인덱스로 사용할 변수를 선언하고 초기화한다.
	while (true) {

		int mok = dec / 2;	// 몫

//		int nmg = dec % 2;	// 나머지
//		bin[i] = nmg;		// 나머지를 배열에 저장한다.
//		i++;				// 인덱스를 증가시킨다.
//		위의 주석으로 처리한 3줄을 아래와 같이 1줄로 줄여서 사용할 수 있다.
		bin[i++] = dec % 2;

//		dec를 변환하려는 진법의 수로 나눈 몫이 0이 되면 더 이상 반복할 필요가 없으므로 무한 루프를 탈출한다.
		if (mok == 0) {
			break;
		}

//		몫이 0이 아닐 경우 다음 연산을 위해서 몫을 dec에 넣어준다.
		dec = mok;

	}
	printf("무한 루푸가 종료된 후 i에 저장된 값 : %d\n", i);
	int start = i;

//	26 => 00011010
	for (int i = arraySize - 1; i >= 0; i--) {
		printf("%d", bin[i]);
	}
	printf("\n");

//	26 => 0001 1010
	for (int i = arraySize - 1; i >= 0; i--) {
		printf("%d", bin[i]);
		if (i % 4 == 0) {
			printf(" ");
		}
	}
	printf("\n");

//	26 => 11010 #1
	for (int i = start - 1; i >= 0; i--) {
		printf("%d", bin[i]);
	}
	printf("\n");

//	26 => 11010 #2
	bool flag = false;
	for (int i = arraySize - 1; i >= 0; i--) {
		if (flag || bin[i]) {
			printf("%d", bin[i]);
			flag = true;
		}
	}
	printf("\n");

}
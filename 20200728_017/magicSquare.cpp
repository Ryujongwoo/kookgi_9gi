#include "config.h"

void main() {

//	마방진의 차수를 입력받는다.
	int n;
	while (true) {
		printf("마방진을 출력할 배열의 크기를 3이상인 홀수로 입력하세요 : ");

//		키보드로 정수를 입력받아 n이라는 변수가 메모리에 생성된 주소에 넣어라.
		scanf_s("%d", &n);

		if (n >= 3 && n % 2 == 1) {
			break;
		}
		printf("3이상인 홀수를 입력하라니까는~~~~~ 콱~~~~~\n");
	}

//	최초의 1이 나올위치를 정하고 배열의 차수만큼 메모리를 동적으로 할당한다.
	int i = 0, j = n / 2;
	int** data = new int* [n];
	for (int k = 0; k < n; k++) {
		data[k] = new int[n];
	}

	for (int k = 1; k <= n * n; k++) {
		data[i][j] = k;
		if (k % n == 0) {
			i++;
		}
		else {
//			i--;
//			if (i < 0) {
//				i = n - 1;
//			}
			i = --i < 0 ? n - 1 : i;
//			j++;
//			if (j == n) {
//				j = 0;
//			}
			j = ++j == n ? 0 : j;
		}
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			printf("%3d ", data[i][j]);
		}
		printf("\n");
	}

}
#include "config.h"
#include <iomanip>		// setw() 함수를 사용할 수 있게 해주는 헤더 파일

void main() {

//	자료형 배열이름[행][열];			// 2차원 배열을 선언만 한다. => 모두 쓰레기가 채워진다.
//	자료형 배열이름[행][열] = { 0 };	// 2차원 배열을 선언하고 모든 요소를 0으로 초기화 시킨다.

	int data[4][5] = { 
		{1, 2, 3, 4, 5}, 
		{6, 7}, 
		{8, 9, 10, 11},
		{12}
	};

	/*
//	짝수행과 홀수행의 반복문을 다르게 만들기
	int count = 0;
	for (int i = 0; i < 4; i++) {
		if (i % 2 == 0) {
//			짝수행은 왼쪽에서 오른쪽으로 숫자를 채운다.(열 0 => 4)
			for (int j = 0; j < 5; j++) {
				data[i][j] = ++count;
			}
		}
		else {
//			홀수행은 오른쪽에서 왼쪽으로 숫자를 채운다.(열 4 => 0)
			for (int j = 4; j >= 0 ; j--) {
				data[i][j] = ++count;
			}
		}
	}
	*/

	int count = 0;
	int start = 0, end = 4, sw = 1;

	for (int i = 0; i < 4; i++) {

		for (int j = start; j != end + sw; j += sw) {
			data[i][j] = ++count;
		}

		swap(start, end);
		sw *= -1;
	}

	for (int i = 0; i < 4; i++) {		// 행
		for (int j = 0; j < 5; j++) {	// 열
//			printf("%2d ", data[i][j]);
//			setw() : cout으로 출력할 자리수를 지정한다.
			cout << setw(2) << data[i][j] << " ";
		}
		printf("\n");
	}

}
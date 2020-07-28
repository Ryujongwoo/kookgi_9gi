#include "config.h"

void main() {

	int n, m;
	printf("배열의 크기 : ");
	scanf_s("%d %d", &n, &m);

//	2차원 배열을 동적으로 할당하려면 행을 먼저 할당하고 행의 개수만큼 반복하며 행에 열을 할당한다.

	/*
//	c언어에서 2차원 배열 동적으로 할당하기
	int** data = (int**)malloc(sizeof(int) * n);	// 행
	for (int i = 0; i < n; i++) {
		data[i] = (int*)malloc(sizeof(int) * m);	// 열
//		동적 할당 방식으로 2차원 배열을 만드는 경우 배열 요소는 열을 만드는 과정에서 초기화 시킨다.
		memset(data[i], 0, _msize(data[i]));
	}
	*/

//	c++에서 2차원 배열 동적으로 할당하기
	int** data = new int*[n];
	for (int i = 0; i < n; i++) {
		data[i] = new int[m];
		memset(data[i], 0, _msize(data[i]));
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			printf("%d ", data[i][j]);
		}
		printf("\n");
	}
	printf("==================================\n");

//	정적 할당된 메모리는 변수 또는 배열이 선언된 {} 블록을 벗어나거나 프로그램이 종료되면 메모리에서 자동으로 소멸된다.
//	malloc() 함수 또는 new를 사용해서 동적으로 할당된 메모리는 프로그램이 종료되더라도 메모리에서 자동으로 소멸되지 않기 때문에 프로그래머가
//	직접 메모리에서 소멸시켜야 한다. => 자바는 가비지 컬렉터가 있어서 프로그래머가 하지 않더라도 자동으로 소멸시킨다.
//	동적으로 할당된 메모리가 소멸되지 않아 다른 프로그램이 사용하지 못하는 현상을 메모리 누수 현상이라 부르고 메모리 누수 현상을 방지하려면
//	프로그램이 종료되기 전에 동적으로 할당된 메모리를 소멸시켜야 한다.
//	c언어는 free() 함수를 사용해서 소멸시키고 c++은 delete 명령을 사용해서 소멸시킨다.
//	2차원 이상 동적으로 할당한 경우 할당한 순서의 역순으로 소멸시켜야 한다. => 2차원일 경우 열을 먼저 소멸시킨 후 행을 소멸시킨다.

	/*
	for (int i = 0; i < n; i++) {
		free(data[i]);
	}
	free(data);
	*/

	for (int i = 0; i < n; i++) {
		delete[] data[i];			// 배열(뒤에 []가 있는)을 소멸시킬 때 delete 뒤에 []를 붙인다.
	}
	delete data;					// 변수(뒤에 []가 없는)를 소멸시킬 때 delete 뒤에 []를 붙이지 않는다.
	
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			printf("%d ", data[i][j]);
		}
		printf("\n");
	}

}
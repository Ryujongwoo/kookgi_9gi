#include "config.h"

void main() {

	int n;
	printf("배열의 크기 : ");
	scanf_s("%d", &n);

//	c언어의 메모리 동적 할당 => 동적 배열 만들기
//	malloc() : 인수로 지정된 크기 만큼 메모리를 할당한다.
//	주기억장치에 정수(int)를 n개 저장할 수 있는 메모리를 할당하고 할당된 메모리의 시작 위치(주소)를 포인터 변수
//	data에 넣어준다.
//	int* data = (int*)malloc(sizeof(int) * n);
//	문자열을 저장하기 위해서 char 타입으로 동적 할당을 할 경우 문자열의 끝을 의미하는 '\0'이 저장될 공간이
//	필요하기 때문에 1크게 할당해야 한다.
//	char* data = (char*)malloc(sizeof(char) * n + 1);

//	c++의 메모리 동적 할당
//	new => 새로 만든다. => 새로 만들어서 메모리를 할당한다.
	int* data = new int[n];
//	char* data = new char[n + 1];

//	동적으로 할당된 메모리 일괄 초기화 => 바이트 단위로 초기화 된다. => 숫자는 모두 0만 가능하고 문자는 지정해서
//	초기화 할 수 있다.
//	memset(동적 할당된 배열 이름, 초기치, 동적 할당된 배열의 크기)
//	sizeof() 함수는 정적 할당된 메모리의 크기를 얻어오고 동적 할당된 메모리의 크기는 _msize() 함수로 얻어온다.
	memset(data, 0, _msize(data));

	for (int i = 0; i < n; i++) {
		printf("data[%d] = %d\n", i, data[i]);
	}


}
#include "config.h"

void main() {

	/*
	char name[11];		// 정적 할당
	printf("이름 : ");
//	scanf_s() 함수는 숫자를 입력받을 경우 scanf() 함수와 사용방법이 동일하지만 문자열을 입력받아야 할 경우 scanf() 함수는 문자열을 기억할
//	배열의 크기보다 큰 문자열이 입력되더라도 입력을 받는 문제점이 있어서 scanf_s() 함수를 사용해야 하고 3번째 인수로 입력받을 문자열의 최대
//	크기를 지정해야 한다.
//	입력받을 문자열의 최대 크기는 정적 할당일 경우 sizeof() 함수를 사용해서 지정하면 된다.
	scanf_s("%s", name, sizeof(name));
	printf("%s님 안녕하세요\n", name);
	*/

//	문자열을 포인터 변수를 이용해 입력받으려 할 경우 포인터 변수는 데이터를 기억하는 변수가 아니라 데이터가 저장된 주소를 기억하기 때문에
//	반드시 문자열이 기억될 메모리를 동적으로 할당하고 할당된 메모리의 시작 주소를 넣어줘야 한다.

//	char* name = (char*)malloc(sizeof(char) * 10 + 1);		// 동적 할당
	char* name = new char[sizeof(char) * 10 + 1];

	printf("sizeof(name) = %d\n", sizeof(name));
	printf("_msize(name) = %d\n", _msize(name));

	printf("이름 : ");
//	입력받을 문자열의 최대 크기는 정적 할당일 경우 _msize() 함수를 사용해서 지정하면 된다.
	scanf_s("%s", name, _msize(name));
	printf("%s님 안녕하세요\n", name);

//	strlen() 함수는 인수로 지정된 기억장소에 저장된 문자열이 차지하는 크기를 NULL 문자를 제외하고 얻어온다.
	printf("strlen(name) = %d\n", strlen(name));

//	char irum[11];
//	포인터 변수 name에 할당된 메모리에 저장된 문자열의 크기만큼 메모리를 동적으로 할당한다.
	char* irum = new char[strlen(name) + 1];

//	strcpy_s(사본, 원본) 함수는 원본을 사본으로 복사한다. => "="를 사용해서 문자열 배열에 값을 할당할 수 있는 경우는 배열 선언시만 가능하다.
//	strcpy_s(irum, name);		// 사본이 정적 할당된 메모리일 경우 사용이 가능하지만 동적 할당된 메모리일 경우 에러가 발행된다.
//	strcpy_s() 함수를 사용해서 동적으로 할당된 메모리로 문자열을 복사하려면 2번째 인수로 복사할 최대 크기를 지정해야 한다.
//	strcpy_s(irum, _msize(irum), name);
	strcpy_s(irum, strlen(irum) + 1, name);
	printf("%s님 또 오셨군요\n", irum);

}
#include "config.h"

//	함수가 처리할 데이터 a, b와 데이터를 처리할 함수의 주소를 기억하는 포인터(*pFunc)를 인수로 가지는 함수
int func(int a, int b, int (*pFunc)(int, int)) {
	return (*pFunc)(a, b);
}

int Add(int a, int b) { return a + b; }
int Sub(int a, int b) { return a - b; }
int Mul(int a, int b) { return a * b; }
int Div(int a, int b) { return a / b; }

void main() {

//	Add 함수의 주소를 함수 포인터 변수에 저장한다.
	int (*f)(int, int) = Add;
	cout << func(5, 3, f) << endl;

}
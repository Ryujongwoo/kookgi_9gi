#include "config.h"

//	() 안에 "*"을 적고 변수 이름을 쓰면 함수 포인터 타입이 된다. => 함수가 메모리에 생성된 주소를 기억한다.
//	Func는 리턴 타입이 int이고 int형 인수를 2개 넘겨받는 함수의 주소를 기억하는 함수 포인터 타입이다.
typedef int (*Func)(int, int);

int Add(int a, int b) { return a + b; }
int Sub(int a, int b) { return a - b; }
int Mul(int a, int b) { return a * b; }
int Div(int a, int b) { return a / b; }

void main() {

//	typedef으로 정의한 Func 타입의 함수 포인터 변수에 함수가 메모리에 생성된 주소를 넣어준다.
	Func func = Add;
	cout << func << endl;
	cout << Add(5, 3) << endl;
	cout << func(5, 3) << endl;
	cout << "=============================" << endl;

	Func f[] = { Add, Sub, Mul, Div };
	for (int i = 0; i < 4; i++) {
//		cout << f[i] << endl;
		cout << f[i](5, 3) << endl;
	}

}
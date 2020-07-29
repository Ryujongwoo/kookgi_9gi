#include "config.h"

//	call by value => 값에 의한 호출 => 데이터를 던지면 일반 변수로 받는다.
//	호출되는 함수의 가인수로 실인수의 값을 복사해서 넘겨준다. => 실인수와 가인수는 독립된 메모리 공간을 사용한다. => 가인수에 저장된 데이터가
//	변경되더라도 실인수에 저장된 데이터는 변경되지 않는다. => 부작용(side effect) 현상이 발생되지 않는다.
//	함수를 호출할 때 여러개의 데이터를 넘겨줄 수 있지만 결과는 return에 의해서 1개만 받을 수 있다.

//	call by reference(pointer, address) => 주소(참조)에 의한 호출 => 데이터가 저장된 주소를 던지면 포인터 변수로 받는다.
//	호출되는 함수의 가인수로 실인수가 메모리에 생성된 주소를 넘겨준다. => 실인수와 가인수는 같은 주소를 참조한다. => 같은 메모리 공간을
//	공유해서 사용한다.
//	실인수와 가인수가 같은 메모리 공간을 사용하므로 가인수에 저장된 데이터가 변경되는 순간 실인수에 저장된 데이터가 동시에 변경된다.
//	=> 부작용(side effect) 현상이 발생될 수 있기 때문에 주의해서 사용해야 한다.
//	가인수에 저장된 데이터가 변경될 때 실인수에 저장된 데이터도 같이 변경되므로 여러개의 결과를 받는 효과를 낸다.

//	pointer를 이용한 call by reference
void change(int* a, int* b) {
	int temp = *a;
	*a = *b;
	*b = temp;
}

void change(double* a, double* b) {
	double temp = *a;
	*a = *b;
	*b = temp;
}

void change(char* a, char* b) {
	char temp = *a;
	*a = *b;
	*b = temp;
}

void change(bool* a, bool* b) {
	bool temp = *a;
	*a = *b;
	*b = temp;
}

//	reference 변수를 이용한 call by reference
/*
void change(int& a, int& b) {
	int temp = a;
	a = b;
	b = temp;
}

void change(double& a, double& b) {
	double temp = a;
	a = b;
	b = temp;
}

void change(char& a, char& b) {
	char temp = a;
	a = b;
	b = temp;
}

void change(bool& a, bool& b) {
	bool temp = a;
	a = b;
	b = temp;
}
*/

//	template은 함수가 호출될 때 실인수의 데이터 타입을 넘겨받는다. => 자바에서는 제네릭이라 부른다.
//	함수에 선언된 템플릿이 1개이고 함수를 호출할 때 인수가 2개 이상일 경우 첫 번째 인수의 데이터 타입이 템플릿으로 전달된다.
template <class T>
void change(T& a, T& b) {
	T temp = a;
	a = b;
	b = temp;
}

void main() {

	int a = 3, b = 4;
	printf("a = %d, b = %d\n", a, b);			// a = 3, b = 4
	swap(a, b);
	printf("a = %d, b = %d\n", a, b);			// a = 4, b = 3
	change(&a, &b);
	printf("a = %d, b = %d\n", a, b);			// a = 3, b = 4
	change(a, b);
	printf("a = %d, b = %d\n", a, b);			// a = 4, b = 3
	printf("===========================\n");

	double c = 9.1, d = 3.4;
	printf("c = %.1f, b = %.1f\n", c, d);		// c = 9.1, b = 3.4
	change(&c, &d);
	printf("c = %.1f, b = %.1f\n", c, d);		// c = 3.4, b = 9.1
	change(c, d);
	printf("c = %.1f, b = %.1f\n", c, d);		// c = 9.1, b = 3.4
	printf("===========================\n");

	char ch1 = 'A', ch2 = 'a';
	printf("ch1 = %c, ch2 = %c\n", ch1, ch2);	// ch1 = A, ch2 = a
	change(&ch1, &ch2);
	printf("ch1 = %c, ch2 = %c\n", ch1, ch2);	// ch1 = a, ch2 = A
	change(ch1, ch2);
	printf("ch1 = %c, ch2 = %c\n", ch1, ch2);	// ch1 = A, ch2 = a
	printf("===========================\n");

	bool e = true, f = false;
	printf("e = %d, f = %d\n", e, f);			// e = 1, f = 0
	change(&e, &f);
	printf("e = %d, f = %d\n", e, f);			// e = 0, f = 1
	change(e, f);
	printf("e = %d, f = %d\n", e, f);			// e = 1, f = 0

}
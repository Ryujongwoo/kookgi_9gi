#include "config.h"

//	main() 함수에서 사용할 함수를 main() 함수 앞에서 선언하면 잘 실행되지만 main() 함수 뒤에서 선언하면 에러가 발생된다.
//	에러가 발생되지 않게 하려면 컴파일러에게 함수임을 알려주는 함수의 원형을 main() 함수 앞에서 전방 선언을 해야한다.

//	함수의 원형은 함수의 머리 부분을 적으면 되고 자료형은 반드시 적어야 하지만 인수 이름은 적지 않아도 상관없다.
int total();			// int total() 함수의 원형
int total(int);			// int total(int n) 함수의 원형
int total(int, int);	// int total(int x, int y) 함수의 원형

void main() {

	printf("1 ~ 100의 합계 : %d\n", total());
	printf("1 ~ 100의 합계 : %d\n", total());

	int n;
	cout << "n : ";
	cin >> n;
	cout << "1 ~ " << n << "의 합계 : " << total(n) << endl;
	printf("실인수 n : %d\n", n);

	int x, y;
	cout << "x, y : ";
	cin >> x >> y;
	cout << x << " ~ " << y << "의 합계 : " << total(x, y) << endl;

}

int total() {
	int sum = 0;
	for (int i = 1; i <= 100; i++) {
		sum += i;
	}
	return sum;
}

int total(int n) {
	int sum = 0;
	for (int i = 1; i <= n; i++) {
		sum += i;
	}
	return sum;
}

int total(int x, int y) {
	int sum = 0;
	for (int i = x; i <= y; i++) {
		sum += i;
	}
	return sum;
}

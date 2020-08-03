#include "config.h"

//	상수란 프로그램에서 변하지 않는 숫자나 문자를 의미한다. => 데이터
//	프로그램에서 특정한 상수가 여러번 사용된다면 변수에 저장시켜 사용하면 편리하다.
//	이 때, 상수를 저장해둔 변수의 내용이 수정된다면 프로그램이 정상적으로 처리되지 않을 가능성이 매우 높아지기 때문에 상수를 저장해둔 변수의
//	내용을 수정할 수 없도록 만들어 사용한다. => 수정하면 에러가 발생된다.
//	다른 일반 변수와 상수로 사용하는 변수를 구별하기 위해 일반적으로 모두 대문자로 만들어 사용한다.

//	c언어에서 상수를 정의하는 방법
//	#define 상수이름 값			// "#"으로 시작하는 문장 => 전처리기 => 문장 뒤에 ";"를 찍지 않는다.
//	#define PI 3.141592

//	c++에서 상수를 정의하는 방법
//	const 자료형 상수이름 = 값;
//	const double PI = 3.141592;

class Circle {
private:
	double radius = 0.0;
public:
//	상수는 반드시 선언과 동시에 초기화시켜야 한다.
//	1. 비쥬얼 스튜디오 2017 부터 멤버 변수를 초기화 할 때 "="를 사용한 초기화가 가능하므로 상수 선언시 "="를 사용해 초기화 시킨다.
	const int LIMIT = 100;
//	const double PI = 3.141592;
//	2. 상수 선언 후 생성자의 초기화 리스트를 사용해서 초기화 시킨다.
	const double PI;		// 상수를 선언한다.

//	생성자에서 초기화 리스트를 사용하려면 생성자의 ")" 뒤에 ":"를 찍고 상수이름(초기치) 형태로 적어준다.
//	초기화 리스트에서 초기화 시켜야 할 멤버 변수가 2개 이상이라면 ","로 구분해서 초기화 시키면 된다.
	Circle() : PI(3.141592) {
		
	}
	Circle(double radius) : PI(3.141592) {
		this->radius = radius;
	}

	void toString() {
		cout << "반지름 : " << radius << endl;
	}

//	원의 너비과 원의 둘레를 계산해서 출력하는 함수를 만든다.
	void circumference() {
		cout << "반지름이 " << radius << "인 원의 둘레는 " << 2 * PI * radius << endl;
	}
	void area() {
		cout << "반지름이 " << radius << "인 원의 너비는 " << PI * pow(radius, 2) << endl;
	}
};

void main() {

//	printf("PI = %f\n", PI);
//	cout << "PI = " << PI << endl;
//	PI = 1.2345;			// 상수로 사용하는 변수에 저장된 값을 변경하려 했으므로 에러가 발생된다.

	Circle circle1;
	cout << "circle1.PI = " << circle1.PI << endl;
	circle1.toString();

	Circle circle2(10);
	circle2.toString();
	circle2.circumference();
	circle2.area();

}
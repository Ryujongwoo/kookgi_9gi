#include "config.h"

class A {
public:
	A() {
		cout << "A 클래스 객체 생성시 멤버 변수 초기화 및 동적 메모리 할당" << endl;
	}
	virtual ~A() {		// 가상 소멸자
		cout << "A 클래스 객체 소멸시 동적 메모리 해제" << endl;
	}
};

class B : public A {
public:
	B() : A() {
		cout << "B 클래스 객체 생성시 멤버 변수 초기화 및 동적 메모리 할당" << endl;
	}
	~B() {
		cout << "B 클래스 객체 소멸시 동적 메모리 해제" << endl;
	}
};

void main() {

//	A a;
//	B b;

//	A* a = new A();
//	delete a;

//	B* b = new B();
//	delete b;

//	부모 클래스 타입의 포인터 변수에 자식 클래스 타입의 객체를 생성해 대입하먄 delete 명령을 이용해 포인터 변수에 할당된 메모리를 해제하려
//	할 때 자식 클래스 타입의 소멸자가 실행되지 않는다.
//	이런 현상을 해결하려면 부모 클래스의 소멸자를 가상 소멸자로 만들어주면 된다.
	A* a = new B();
	delete a;

}
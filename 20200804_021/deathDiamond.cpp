#include "config.h"

class A {
private:
	int a = 0;
public:
	void func1() {
		cout << "A" << endl;
	}
};

//	A 클래스를 상속받아 B 클래스를 만든다.
class B : virtual public A {
private:
	int b = 0;
public:
	void func2() {
		cout << "B" << endl;
	}
};

//	A 클래스를 상속받아 C 클래스를 만든다.
class C : virtual public A {
private:
	int c = 0;
public:
	void func2() {
		cout << "C" << endl;
	}
};

//	B, C 클래스를 상속받아 D 클래스를 만든다.
class D : public B, public C {
private:
	int d = 0;
public:
	void func3() {
		cout << "D" << endl;
	}
};

void main() {

	D d;
	d.func3();
//	D 클래스는 B 클래스와 C 클래스에서 func2() 함수를 상속받았다.
//	D 클래스에는 func2() 함수가 2개 있으므로 아래와 같이 실행하면 어떤 클래스에서 상속받은 함수를 실행할 지 결정할 수 없으므로 함수가
//	모호하다는 에러가 발생된다.
//	D 클래스에서 func2() 함수를 override 시켜 사용하면 에러 없이 사용할 수 있다.
//	d.func2();
//	"소속클래스::"를 func2() 함수 앞에 붙여서 어떤 클래스로 부터 상속받은 함수인지 명시해 주면 사용할 수 있다.
	d.B::func2();
	d.C::func2();

//	A 클래스는 B 클래스로 상속된 후 D 클래스로 상속되고 또 A 클래스는 C 클래스로 상속된 후 D 클래스로 상속된다.
//	D 클래스는 A 클래스를 2번 상속받았다. => func1() 함수도 2번 상속받았다.
//	d.func1();			// func1() 함수를 2번 상속받았으므로 함수가 모호하다는 에러가 발생된다.
//	이런 현상을 해결하기 위해 func1() 함수 앞에 "A::" 붙여주면 A 클래스를 2번 상속받았으므로 프로그램을 실행하면 A 액세스가 모호하다는
//	에러가 발생된다. => 이런 현상을 deathdiamond라 부르며 같은 클래스가 여러번 상속되는 경우 발생된다.
//	deathdiamond 현상을 해결하는 방법은 여러번 상속될것으로 예상되는 클래스를 상속받을 때 ":" 뒤에 "virtual" 예약어를 사용해서 가상 상속을
//	시켜주면 된다.

//	그런데.... 현재.... 비쥬얼 스튜디오(2020.08.04. 현재)에서는 가상 상속을 시키지 않아도 에러가 발생되지 않는다....
	d.A::func1();

}
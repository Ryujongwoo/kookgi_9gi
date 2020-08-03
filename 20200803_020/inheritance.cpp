#include "config.h"

//	부모(상위, 슈퍼, 기반) 클래스
class Parent {
private:
	char name[11] = "무명씨";
	bool gender = false;
public:
	Parent() {
		cout << "부모 클래스의 기본 생성자가 실행됩니다." << endl;
	}
	Parent(const char name[11], bool gender) {
		strcpy_s(this->name, name);
		this->gender = gender;
	}

	void toString() {
		cout << name << "(" << (gender ? "남" : "여") << ")" << endl;
	}

	char* getName() {
		return name;
	}
	bool isGender() {
		return gender;
	}
};

//	상속이란 부모 클래스에서 정의한 모든 멤버 변수와 함수를 자식 클래스에서 별도로 정의하지 않아도 정의한 것 처럼 사용할 수 있는 것을 말한다.
//	class 자식클래스이름 : 상속권한지정자 부모클래스이름

//	상속 권한 지정자
//	private   => 부모 클래스에서 지정된 접근 권한에 관계 없이 무조건 자식 클래스에 private 권한으로 상속된다.
//	protected => 부모 클래스에 지정된 접근 권한이 private 권한이면 private으로 나머지 권한은 protected 권한으로 상속된다.
//	public    => 부모 클래스에서 지정된 접근 권한이 그대로 상속된다.

//	상속 권한 지정자		부모 클래스의 접근 권한			자식 클래스로 상속되는 접근 권한
//	=========================================================================================
//							private							private
//	private					protected						private
//							public							private
//	=========================================================================================
//							private							private
//	protected				protected						protected
//							public							protected
//	=========================================================================================
//							private							private
//	public					protected						protected
//							public							public
//	=========================================================================================

//	자식(하위, 서브, 파생) 클래스
//	Parent 클래스를 상속받아 Child 클래스를 만든다.
//	Child 클래스는 Parent 클래스의 멤버 변수 name, gender와 멤버 함수 toString()을 별도로 선언하지 않아도 사용할 수 있다.

class Child : public Parent {
private:
	int age = 0;
	char nickname[11] = "없음";
public:
//	자식 클래스의 생성자가 실행되기 전에 별도의 설정이 없으면 부모 클래스의 생성자가 자동으로 먼저 실행된다.
//	자식 클래스의 ")" 뒤에 ":"을 찍고 부모 클래스의 생성자를 실행할 수 있다. => 생략시 컴파일러가 부모 클래스 기본 생성자를 자동으로 넣어준다.
	Child() /*: Parent()*/ {
		cout << "자식 클래스의 기본 생성자가 실행됩니다." << endl;
	}

//	자식 클래스의 생성자는 부모 클래스로 부터 상속받은 멤버 변수와 자기 자신이 정의한 멤버 변수를 초기화 시켜야 한다.
//	부모 클래스로 부터 상속받은 private 권한을 가지는 멤버 변수는 부모 클래스의 생성자를 호출해서 초기화 시킨다.
	Child(const char name[11], bool gender, int age, const char nickname[11]) : Parent(name, gender) {
//		부모 클래스로 부터 상속받은 멤버 변수의 접근 권한이 private일 경우 이를 상속받은 자식 클래스에서도 접근이 불가능하기 때문에 this를
//		사용해서 초기화가 불가능하다.
//		strcpy_s(this->name, name);		// 상속받은 멤버 변수 name은 private 권한으로 상속되서 에러가 발생된다.
//		this->gender = gender;			// 상속받은 멤버 변수 gender는 private 권한으로 상속되서 에러가 발생된다.
		this->age = age;
		strcpy_s(this->nickname, nickname);
	}

//	부모 클래스에서 상속받은 toString() 함수는 이름과 성별만 출력되므로 자식 클래스의 나이와 별명까지 출력하려면 부모 클래스로 부터 상속받은
//	toString() 함수를 다시 만들어 사용하면 된다. => 함수의 재정의(override)라 한다.
//	함수를 재정의하면 부모 클래스로 부터 상속받은 함수는 무시되고 자식 클래스에서 작성한 함수가 실행된다.
	void toString() {
//		cout << getName() << "(" << (isGender() ? "남" : "여") << ") - " << age << ", " << nickname << endl;
//		부모 클래스로 부터 상속받은 함수를 실행하려면 부모 클래스 이름 뒤에 "::"를 찍고 함수를 실행하면 된다.
//		Parent::toString() => 부모(Parent) 클래스의 toString() 함수를 실행한다.
		Parent::toString();
		cout << " - " << age << ", " << nickname << endl;
	}
};

void main() {

	Parent parent1;
	parent1.toString();
	Parent parent2("홍길동", true);
	parent2.toString();
	cout << "===================================================" << endl;

	Child child1;
	child1.toString();
	cout << "===================================================" << endl;

	Child child2("성춘향", false, 16, "이쁜이");
	child2.toString();

}
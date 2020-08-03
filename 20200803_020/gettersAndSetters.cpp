#include "config.h"

class Person {
private:
	char name[11] = "무명씨";
	bool gender = false;
public:
	Person() { }
	Person(const char name[11], bool gender) {
		strcpy_s(this->name, name);
		this->gender = gender;
	}

	void toString() {
		cout << name << "(" << (gender ? "남" : "여") << ")" << endl;
	}

//	private 권한으로 설정된 멤버 변수는 클래스 외부에서 접근할 수 없는데 이 규칙에 대힌 예외 규정을 정의할 목적으로 필요할 경우 만들어 
//	사용하는 함수가 있는데 이를 getter, setter라 부른다.

//	getter 함수
//	이름이 get으로 시작하고 멤버 변수 이름을 붙여서 만든다. => bool 형태의 멤버 변수 getter는 get이 아니라 "is"로 시작하는게 관행이다.
//	리턴 타입은 멤버 변수의 자료형을 쓰고 가인수는 없다. => 멤버 변수를 리턴한다.

	char* getName() {	// name의 getter
		return name;
	}

	bool isGender() {	// gender의 getter
		return gender;
	}

//	setter 함수
//	이름이 set으로 시작하고 멤버 변수 이름을 붙여서 만든다.
//	리턴 타입은 void를 사용하고 가인수로 private 권한의 멤버 변수에 전달할 데이터를 넘겨받는다. => 넘겨받은 데이터를 멤버 변수에 저장한다.

	void setName(const char name[11]) {
		strcpy_s(this->name, name);
	}

	void setGender(bool gender) {
		this->gender = gender;
	}

};

void main() {

	Person person1;
	person1.toString();
	Person* person2 = new Person();
	person2->toString();

	Person person3("홍길동", true);
	person3.toString();
	Person* person4 = new Person("성춘향", false);
	person4->toString();

//	cout << person3.name << endl;			// name은 private 권한이므로 클래스 외부에서 접근할 수 없다.
	cout << person3.getName() << endl;		// getName() 함수(getter)를 사용해 private 멤버인 name에 저장된 데이터를 얻어온다.
	cout << person3.isGender() << endl;

	person3.setName("변학도");
	person3.toString();
	person4->setGender(true);
	person4->toString();

	delete person2;
	delete person4;

}
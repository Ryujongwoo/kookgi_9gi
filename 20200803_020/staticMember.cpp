#include "config.h"

//	멤버 변수는 크게 정적(static) 멤버 변수와 인스턴스 멤버 변수로 구분할 수 있다.
//	정적 멤버 변수는 현재 클래스의 객체가 최초로 생성될 때 딱 1번만 메모리에 생성되고 초기화되며 현재 클래스로 생성된 모든 객체가 공유해서
//	사용한다.
//	인스턴스 멤버 변수는 현재 클래스로 생성되는 모든 객체에서 독립된 메모리 공간을 가진다.

class Person {
private:
	int idx = 0;				// Person 클래스의 객체가 생성될 때 마다 자동으로 1씩 증가되는 값을 기억할 변수
	char name[11] = "무명씨";
	bool gender;
public:
//	정적(static) 멤버 변수는 비쥬얼 스튜디오 2017 이후 버전에서도 변수 선언시 "="를 사용해서 초기화 시킬 수 없다.
//	상수처럼 생성자의 초기화 리스트를 사용해서도 초기화 시킬 수 없다.
//	정적 멤버 변수는 클래스 내부에서는 선언만 하고 초기화는 클래스 외부에서 시켜야 한다.
	static int count;

	Person() { }
	Person(const char name[11], bool gender) {
		idx = ++count;
		strcpy_s(this->name, name);
		this->gender = gender;
	}

	void toString() {
		cout << idx << ". " << name << "(" << (gender ? "남" : "여") << ")" << endl;
	}

	char* getName() {
		return name;
	}
	void setName(const char name[11]) {
		strcpy_s(this->name, name);
	}

	bool isGender() {
		return gender;
	}
	void setGender(bool gender) {
		this->gender = gender;
	}
};

//	정적 멤버 변수의 초기화는 클래스 외부에서 해야한다.
//	자료형 클래스이름::정적멤버변수이름 = 초기치;
//	"::"는 스코프 연산자라 부르며 어떤 클래스에 속한 멤버인가를 지정한다.
int Person::count = 0;

void main() {

	Person person1("홍길동", true);		// Person 클래스 객체가 처음 생성될 때 정적 멤버 변수 count가 생성되고 초기화된다.
	person1.toString();
	Person person2("임꺽정", false);	// 이미 정적 멤버 변수 count가 메모리에 존재하기 때문에 다시 만들지 않고 기존의 count를 사용한다.
	person2.toString();
	Person person3("장길산", true);
	person3.toString();

	person1.count = 100;
	cout << "person1.count = " << person1.count << endl;
//	정적 멤버 변수는 같은 클래스로 만든 모든 객체가 공유해서 사용하므로 특정 객체의 정적 멤버 변수 값을 변경하면 모든 객체의 정적 멤버 변수
//	값이 변경된다.
	cout << "person2.count = " << person2.count << endl;
	cout << "person3.count = " << person3.count << endl;

	Person person4("일지매", true);
	person4.toString();

}
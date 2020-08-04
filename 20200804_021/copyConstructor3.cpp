#include "config.h"

class Member {
private:
	char *name = NULL;
	char *phone = NULL;
	int age = 0;
public:
	Member() { }
	Member(const char* name, const char* phone, int age) {
		this->name = new char[strlen(name) + 1];
		this->phone = new char[strlen(phone) + 1];
		strcpy_s(this->name, strlen(name) + 1, name);
		strcpy_s(this->phone, _msize(this->phone), phone);
		this->age = age;
	}

	~Member() {
		delete[] name;
		delete[] phone;
		cout << "꽤~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ㄱ" << endl;
	}
	
	void toString() {
		cout << name << "님 - 전화번호 : " << phone << ", 나이 : " << age << endl;
	}

	void setName(const char name[11]) {
		strcpy_s(this->name, strlen(name) + 1, name);
	}

//	기본 복사 생성자를 사용해 동적 할당된 객체를 복사하면 2가지 문제점이 발생된다.
//	1. 컴파일러가 자동으로 만들어주는 복사 생성자는 동적 할당된 메모리를 얕은(주소) 복사를 하기 때문에 원본 또는 사본 하나가 수정되면 같은
//	   메모리를 참조하기 때문에 모든 원본 또는 사본이 수정된다.
//	2. 프로그램이 종료될 때 소멸자에서 생성자가 동적 할당한 메모리를 제거할 때 원본 객체가 소멸되면서 원본 객체와 사본 객체가 같이 참조하던
//	   메모리를 제거해버리기 때문에 사본 객체가 제거될 때 이미 제거되버린 메모리를 또 제거하려는 시도를 하기 때문에 에러가 발생된다.

	/*
//	컴파일러가 자동으로 생성하는 기본 복사 생성자
//	컴파일러가 자동으로 만들어주는 기본 복사 생성자는 주소를 복사하는 앝은 복사를 실행하므로 원본과 사본의 주소가 공유된다.
	Member(Member& member) {
		cout << "기본 복사 생성자가 실행됩니다." << endl;
		name = member.name;
		phone = member.phone;
		age = member.age;
	}
	*/

//	기본 복사 생성자는 위의 2가지 문제점을 발생시킨다. => 복사 생성자를 깊은(내용) 복사를 하도록 override 한다.
	Member(Member& member) {
//		복사 생성자의 참조 변수로 넘어오는 데이터의 크기 만큼 메모리를 동적으로 할당하고 strcpy_s() 함수를 사용해서 주소가 아닌 데이터를
//		복사하는 깊은 복사가 실행되도록 한다.

		name = new char[strlen(member.name) + 1];
		phone = new char[strlen(member.phone) + 1];
		strcpy_s(name, strlen(member.name) + 1, member.name);
		strcpy_s(phone, _msize(phone), member.phone);
		age = member.age;

	}
};

void main() {

	Member member1("홍길동만세", "111-1111", 20);
	cout << "member1 : "; member1.toString();
	Member member2 = member1;
	cout << "member2 : "; member2.toString();
	Member member3(member1);
	cout << "member3 : "; member3.toString();
	Member* member4 = new Member(member1);
	cout << "member4 : "; member4->toString();
	cout << "====================================================" << endl;

	member1.setName("장길산바보");
	cout << "member1 : "; member1.toString();
	cout << "member2 : "; member2.toString();
	cout << "member3 : "; member3.toString();
	cout << "member4 : "; member4->toString();
	cout << "====================================================" << endl;

	delete member4;

}
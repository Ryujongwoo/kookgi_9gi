#include "config.h"

class Member {
private:
//	문자열을 정적 할당(배열)된 메모리에 저장하면 메모리가 남거나 모자라는 현상이 빈번하게 발생된다.
//	제한된 메모리를 효과적으로 사용하려면 인수로 넘어오는 문자열의 크기 만큼 메모리를 동적으로 할당하고 문자열을 저장하면 된다.
	char *name = NULL;
	char *phone = NULL;
	int age = 0;
public:
	Member() { }
//	클래스 객체가 생성될 때 생성자에서 문자열을 기억할 포인터 변수에 생성자로 넘어온 문자열의 크기 만큼 메모리를 동적으로 할당한다.
	Member(const char* name, const char* phone, int age) {
//		this->name = name;
//		this->phone = phone;
//		위와 같이 실행하면 클래스의 멤버 변수 name과 phone은 실제 데이터가 아닌 데이터가 저장된 주소를 넘겨받게 되므로 부작용 현상이
//		발생될 수 있기 때문에 생성자의 인수로 넘어온 주소에 저장된 문자열의 크기 만큼 메모리를 동적으로 할당하고 할당된 메모리에 데이터를
//		넣어줘야 한다.

//		인수로 넘어온 문자열의 크기 만큼 메모리를 동적으로 할당한다.
//		cout << strlen(name) << endl;
//		strlen() 함수로 넘어온 문자열의 크기를 얻어온 후 +1 만큼 메모리를 동적으로 할당해야 한다.
		this->name = new char[strlen(name) + 1];
//		cout << _msize(this->name) << endl;
		this->phone = new char[strlen(phone) + 1];

//		동적 할당된 메모리에 인수로 넘어온 문자열을 strcpy_s() 함수로 복사해서 넣어준다.
//		동적 할당된 메모리의 내용을 복사해야 할 경으 strcpy_s() 함수의 2번째 인수로 복사할 문자열의 최대 크기를 지정해야 한다.
//		strcpy_s(this->name, strlen(name) + 1, name);
		strcpy_s(this->name, _msize(this->name), name);
//		strcpy_s(this->phone, strlen(phone) + 1, phone);
		strcpy_s(this->phone, _msize(this->phone), phone);
		this->age = age;
	}

//	생성자에서 동적으로 할당한 메모리는 클래스의 객체가 소멸될 때 메모리 누수 현상이 발생되지 않도록 소멸자에서 반드시 해제시켜야 한다.
	~Member() {
		cout << "꽤~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ㄱ" << endl;
		delete[] name;
		delete[] phone;
	}
	
	void toString() {
		cout << name << "님 - 전화번호 : " << phone << ", 나이 : " << age << endl;
	}
};

void main() {

	/*
//	메모리 어딘가에 "홍길동"이라는 문자열을 만들고 문자열의 시작 주소를 포인터 변수 name에 저장한다.
	const char* name = "홍길동";
//	포인터 변수 name에 저장된 주소가 참조(주소에 저장된)하는 문자열을 '\0'나올 때 까지 출력한다.
	printf("%s\n", name);
	cout << name << endl;
	cout << "sizeof(name) : " << sizeof(name) << endl;	// 인수로 지정된 정적 할당된 기억장소가 메모리에서 차지하는 크기
//	cout << "_msize(name) : " << _msize(name) << endl;	// 인수로 지정된 동적 할당된 기억장소가 메모리에서 차지하는 크기, malloc, new
	cout << "strlen(name) : " << strlen(name) << endl;	// 인수로 지정된 문자열이 메모리에서 차지하는 '\0'을 제외한 크기
	*/

	Member member1("홍길동만세", "111-1111", 20);
	cout << "member1 : "; member1.toString();


}
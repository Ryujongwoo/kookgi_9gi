#include "config.h"

class Member {
private:
	char name[11] = "무명씨";
	char phone[14] = "없음";
	int age = 0;
public:
	Member() { }
	Member(const char name[11], const char phone[14], int age) {
		strcpy_s(this->name, name);
		strcpy_s(this->phone, phone);
		this->age = age;
	}
	void toString() {
		cout << name << "님 - 전화번호 : " << phone << ", 나이 : " << age << endl;
	}

	void setName(const char name[11]) {
		strcpy_s(this->name, name);
	}

//	복사 생성자는 현재 클래스 타입의 객체가 생성된 주소를 저장할 참조 변수 1개를 인수로 가지는 생성자를 말한다.
	Member(Member &member) {	// 복사 생성자 override
		cout << "복사 생성자가 실행됩니다." << endl;
		strcpy_s(name, member.name);
		strcpy_s(phone, member.phone);
		age = member.age;
	}
};

void main() {

	Member member1;
	cout << "member1 : "; member1.toString();
	Member* member2 = new Member();
	cout << "member2 : "; member2->toString();
	cout << "====================================================" << endl;

	Member member3("홍길동", "111-1111", 20);
	cout << "member3 : "; member3.toString();
	Member* member4 = new Member("임꺽정", "222-2222", 35);
	cout << "member4 : "; member4->toString();
	cout << "====================================================" << endl;

//	기본 복사 생성자를 이용해서 member3을 복사해서 Member 클래스 객체를 만든다.
	Member member5 = member3;
	cout << "member5 : "; member5.toString();
	Member member6(member3);
	cout << "member6 : "; member6.toString();
	Member* member7 = new Member(member3);
	cout << "member7 : "; member7->toString();
	cout << "====================================================" << endl;

//	복사 생성자를 이용해 사본(member4, member5, member6) 객체를 생성한 원본(member3) 객체의 내용을 변경하더라도 사본은 변화가 없다.
	member3.setName("장길산");
	cout << "member3 : "; member3.toString();
	cout << "member5 : "; member5.toString();
	cout << "member6 : "; member6.toString();
	cout << "member7 : "; member7->toString();
	cout << "====================================================" << endl;

//	기본 복사 생성자를 이용해서 member4을 복사해서 Member 클래스 객체를 만든다.
//	member4는 포인터 변수이므로 포인터 변수에 저장된 주소가 참조하는 데이터를 복사 생성자의 인수로 넘겨줘야 한다.
	Member member8 = *member4;
	cout << "member8 : "; member8.toString();
	Member member9(*member4);
	cout << "member9 : "; member9.toString();
	Member* member10 = new Member(*member4);
	cout << "member10 : "; member10->toString();
	cout << "====================================================" << endl;

//	복사 생성자를 이용해 사본(member8, member9, member10) 객체를 생성한 원본(member4) 객체의 내용을 변경하더라도 사본은 변화가 없다.
	member4->setName("일지매");
	cout << "member4 : "; member4->toString();
	cout << "member8 : "; member8.toString();
	cout << "member9 : "; member9.toString();
	cout << "member10 : "; member10->toString();
	cout << "====================================================" << endl;

	delete member2;
	delete member4;
	delete member7;
	delete member10;

}
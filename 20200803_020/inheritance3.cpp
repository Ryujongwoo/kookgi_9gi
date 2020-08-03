#include "config.h"

class Parent {
//	protected 접근 권한은 현재 클래스와 현재 클래스를 상속받은 자식 클래스에서만 접근할 수 있다.
protected:
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

	void setName(const char name[11]) {
		strcpy_s(this->name, name);
	}
	void setGender(bool gender) {
		this->gender = gender;
	}
};

class Child : public Parent {
private:
	int age = 0;
	char nickname[11] = "없음";
public:
	Child() {
		cout << "자식 클래스의 기본 생성자가 실행됩니다." << endl;
	}
//	부모 클래스로 부터 상속받은 멤버 변수의 접근 권한이 protected일 경우 자식 클래스에서 자유롭게 접근할 수 있으므로 this를 사용한 초기화가
//	가능해진다.
	Child(const char name[11], bool gender, int age, const char nickname[11]) {
		strcpy_s(this->name, name);
		this->gender = gender;
		this->age = age;
		strcpy_s(this->nickname, nickname);
	}

	void toString() {
		cout << name << "(" << (gender ? "남" : "여") << ") - " << age << ", " << nickname << endl;
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
#include "config.h"

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
//	자식 클래스에서 상속받은 private 권한의 멤버 변수에 저장된 데이터를 수정할 수 있게 하기 위해서 부모 클래스에서 setter를 만들고 자식
//	클래스는 상속받은 setter를 실행해서 부모 클래스로 부터 상속받은 private 권한의 멤버 변수를 초기화 할 수 있다.
	Child(const char name[11], bool gender, int age, const char nickname[11]) {
		setName(name);
		setGender(gender);
		this->age = age;
		strcpy_s(this->nickname, nickname);
	}

	void toString() {
		cout << getName() << "(" << (isGender() ? "남" : "여") << ") - " << age << ", " << nickname << endl;
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
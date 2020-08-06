#include "config.h"

class Parent {
private:
	char name[11] = "������";
	bool gender = false;
public:
	Parent() {
		cout << "�θ� Ŭ������ �⺻ �����ڰ� ����˴ϴ�." << endl;
	}
	Parent(const char name[11], bool gender) {
		strcpy_s(this->name, name);
		this->gender = gender;
	}

	void toString() {
		cout << name << "(" << (gender ? "��" : "��") << ")" << endl;
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
	char nickname[11] = "����";
public:
	Child() {
		cout << "�ڽ� Ŭ������ �⺻ �����ڰ� ����˴ϴ�." << endl;
	}
//	�ڽ� Ŭ�������� ��ӹ��� private ������ ��� ������ ����� �����͸� ������ �� �ְ� �ϱ� ���ؼ� �θ� Ŭ�������� setter�� ����� �ڽ�
//	Ŭ������ ��ӹ��� setter�� �����ؼ� �θ� Ŭ������ ���� ��ӹ��� private ������ ��� ������ �ʱ�ȭ �� �� �ִ�.
	Child(const char name[11], bool gender, int age, const char nickname[11]) {
		setName(name);
		setGender(gender);
		this->age = age;
		strcpy_s(this->nickname, nickname);
	}

	void toString() {
		cout << getName() << "(" << (isGender() ? "��" : "��") << ") - " << age << ", " << nickname << endl;
	}
};

void main() {

	Parent parent1;
	parent1.toString();
	Parent parent2("ȫ�浿", true);
	parent2.toString();
	cout << "===================================================" << endl;

	Child child1;
	child1.toString();
	cout << "===================================================" << endl;

	Child child2("������", false, 16, "�̻���");
	child2.toString();

}
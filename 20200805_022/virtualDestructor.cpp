#include "config.h"

class A {
public:
	A() {
		cout << "A Ŭ���� ��ü ������ ��� ���� �ʱ�ȭ �� ���� �޸� �Ҵ�" << endl;
	}
	virtual ~A() {		// ���� �Ҹ���
		cout << "A Ŭ���� ��ü �Ҹ�� ���� �޸� ����" << endl;
	}
};

class B : public A {
public:
	B() : A() {
		cout << "B Ŭ���� ��ü ������ ��� ���� �ʱ�ȭ �� ���� �޸� �Ҵ�" << endl;
	}
	~B() {
		cout << "B Ŭ���� ��ü �Ҹ�� ���� �޸� ����" << endl;
	}
};

void main() {

//	A a;
//	B b;

//	A* a = new A();
//	delete a;

//	B* b = new B();
//	delete b;

//	�θ� Ŭ���� Ÿ���� ������ ������ �ڽ� Ŭ���� Ÿ���� ��ü�� ������ �����ϐ� delete ������ �̿��� ������ ������ �Ҵ�� �޸𸮸� �����Ϸ�
//	�� �� �ڽ� Ŭ���� Ÿ���� �Ҹ��ڰ� ������� �ʴ´�.
//	�̷� ������ �ذ��Ϸ��� �θ� Ŭ������ �Ҹ��ڸ� ���� �Ҹ��ڷ� ������ָ� �ȴ�.
	A* a = new B();
	delete a;

}
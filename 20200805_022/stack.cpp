#include "config.h"

class Stack {
private:
	int* stack = NULL;		// 스택 => 스택의 크기 만큼 메모리를 동적을 할당한다.
	int stackSize = 0;		// 스택의 크기
	int top = -1;			// 스택 포인터(SP) => 스택에 저장된 데이터의 개수
public:
//	스택의 크기를 인수로 넘겨받아 넘겨받은 크기 만큼 스택을 만들고 스택의 크기를 넘겨받지 않으면 10개의 데이터를 저장할 수 있는 스택을 
//	생성자에서 생성한다.
	/*
	Stack() {
		stackSize = 10;
		stack = new int[stackSize];
	}
	Stack(int stackSize) {
		this->stackSize = stackSize;
		stack = new int[stackSize];
	}
	*/
	Stack(int stackSize = 10) {
		this->stackSize = stackSize;
		stack = new int[stackSize];
	}

//	소멸자에서 생성자에서 할당된 동적 메모리를 해제한다.
	~Stack() {
		delete[] stack;
	}
};

void main() {

//	스택의 크기를 입력받아 입력받은 크기 만큼 스택을 생성하는 클래스의 객체를 만든다.
	int stackSize;
	cout << "스택의 크기를 입력하세요 : " << endl;
	cin >> stackSize;
	Stack stack(stackSize);

	int menu = 0;
	while (menu != 4) {
		do {
			cout << "===============================" << endl;
			cout << " 1.PUSH  2.POP  3.LIST  4.QUIT " << endl;
			cout << "===============================" << endl;
			cout << "메뉴를 입력하세요 : ";
			cin >> menu;
		} while (menu < 1 || menu > 4);

		switch (menu) {
			case 1:
				stack.push();
				break;
			case 2:
				cout << "POP" << endl;
				break;
			case 3:
				cout << "LIST" << endl;
				break;
		}
	}
	cout << "프로그램을 종료합니다. 바이바이~~~~~" << endl;

}
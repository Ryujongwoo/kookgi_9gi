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

//	스택에 데이터를 입력(push)하는 함수
	void push() {
//		스택에 저장할 데이터를 입력받는다.
		int data;
		cout << "스택에 저장할 데이터를 입력하세요 : ";
		cin >> data;
//		스택이 가득찼나 확인 후 저장할 공간이 있으면 데이터를 저장한다.
		if (++top >= stackSize) {	// 오버플로우 검사
//			스택이 가득찬 상태이므로 오버플로우 처리를 한다.
			cout << "스택이 가득차서 " << data << "를 저장할 수 없습니다." << endl;
//			오버플로우가 발생되었으므로 증가된 top을 증가하기 이전 값으로 되돌려준다.
//			top--;
			top = stackSize - 1;
		}
		else {
//			스택에 데이터를 저장할 공간이 남은 상태이므로 스택의 top 위치에 데이터를 저장한다.
			stack[top] = data;		// push
		}
//		스택에 저장된 데이터 목록을 보여주는 함수를 실행한다.
		list();
	}

//	스택에 저장된 데이터 목록을 출력하는 함수
	void list() {
		if (top <= -1) {
			cout << "스택에 저장된 데이터가 없습니다.";
		}
		else {
			cout << "스택에 저장된 데이터 : ";
			for (int i = 0; i <= top; i++) {
				if (i > 0) {
					cout << ", ";
				}
				cout << stack[i];
			}
		}
		cout << endl;
	}

//	스택에 저장된 데이터를 출력(pop)하는 함수
	void pop() {
//		스택이 비어있나(언더플로우 인가) 검사해서 언더플로우가 아니면 데이터를 pop 한다.
		if (top > -1) {		// 언더플로우가 아닌가 검사
//			언더플로우가 아니면 top 위치에 저장된 데이터를 출력하고 top을 1감소 시킨다.
			cout << "POP DATA : " << stack[top--] << endl;
		}
		list();
	}
};

void main() {

//	스택의 크기를 입력받아 입력받은 크기 만큼 스택을 생성하는 클래스의 객체를 만든다.
	int stackSize;
	cout << "스택의 크기를 입력하세요 : ";
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
				stack.pop();
				break;
			case 3:
				stack.list();
				break;
		}
	}
	cout << "프로그램을 종료합니다. 바이바이~~~~~" << endl;

}
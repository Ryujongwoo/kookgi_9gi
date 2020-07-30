#include "config.h"

class Score {
private:
//	멤버 변수를 선언한다. => 멤버 변수는 클래스 내부의 모든 함수에서 사용할 수 있다.
//	클래스의 멤버 변수를 선언한 후 초기화는 정수형 정적 상수를 제외한 나며지는 "="을 사용해서 초기화 시킬 수 없었었으나 지금은 가능하다.
	int no = 0;
	char name[11] = "무명씨";
	int cpp = 0, java = 0, jsp = 0, total = 0;
	double average = 0.0;
public:
//	생성자 함수(이하 생성자)의 이름은 반드시 클래스 이름과 같아야 한다.
//	생성자는 다른 함수와 달리 return을 사용하지 않는다. => return이 없는 함수는 void를 쓰지만 생성자는 return 타입 자체를 사용하지 않는다.
//	생성자는 클래스의 객체(클래스로 만든 변수)가 생성되는 순간 자동으로 실행된다. => 객체가 소멸될 때 자동으로 실행되는 함수를 소멸자라 부른다.
//	개발자가 생성자를 정의하지 않으면 컴파일러가 아무런 일도 하지 않는 기본 생성자를 자동으로 만들어 주지만 개발자가 생성자를 정의하면 기본
//	생성자를 자동으로 만들어 주지 않는다. => 기본 생성자는 무조건 만든다. => 상속시 문제가 발생된다.
//	클래스 객체가 생성될 때 private 권한으로 설정된 멤버 변수에 초기치를 할당하거나 메모리를 동적으로 할당할 경우 사용한다.

//	Score 클래스의 기본 생성자 => 아무 작업도 실행하지 않는 생성자로 객체를 만들기 위해 사용한다.
	Score() {
		cout << "Score 클래스의 기본 생성자가 실행됩니다." << endl;
	}

//	no, name, cpp, java, jsp를 넘겨받아 멤버 변수를 초기화 시키고 총점과 평균을 계산하는 생성자
//	문자열 상수를 넘겨받는 인수는 반드시 앞에 const를 붙여서 선언해야 한다.
	Score(int no, const char name[11], int cpp, int java, int jsp) {
		cout << "Score 클래스의 5개의 인수를 전달받아 멤버 변수를 초기화 시키는 생성자가 실행됩니다." << endl;
//		같은 이름의 멤버 변수와 지역 변수가 같은 {} 블록에 있을 경우 지역 변수에 우선권이 부여된다.
//		멤버 변수임을 알려주기 위해서 this라는 현재 클래스를 의미하는 포인터를 사용한다.
		this->no = no;
		strcpy_s(this->name, name);
		this->cpp = cpp;
		this->java = java;
		this->jsp = jsp;
		total = cpp + java + jsp;
		average =(double)total / 3;
	}

//	소멸자 함수
	~Score() {
		cout << "Score 클래스의 객체가 소멸됩니다." << endl;
	}

//	클래스 객체의 멤버 변수에 저장된 데이터를 출력하는 함수를 만든다.
	void toString() {
		cout << name << "님의 평균 점수는 " << average << "점 입니다." << endl;
	}
};

void main() {

//	Score 클래스의 객체를 기본 생성자를 이용해서 만든다.
	Score score1;
	score1.toString();
	Score* score2 = new Score();
	score2->toString();

//	Score 클래스 객체를 Score(int no, char name[11], int cpp, int java, int jsp) 생성자를 이용해서 만든다.
	Score score3(1, "홍길동", 100, 100, 99);
	score3.toString();
	Score* score4 = new Score(2, "임꺽정", 54, 71, 68);
	score4->toString();

//	포인터 변수에 클래스 객체를 생성하 주소를 할당한 경우 "}"를 만나도 메모리에서 자동으로 소멸되지 않기 때문에 delete 명령을 실행해서
//	소멸시켜야 한다.
	delete score2;
	delete score4;

}
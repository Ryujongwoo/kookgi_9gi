#include "config.h"

//	다형성이란 같은 함수가 서로 다른 클래스에서 다양하게 실행되는 것을 말한다.
//	다형성을 구현할 함수가 포함된 클래스는 모두 같은 부모 클래스를 가져야 하고 부모 클래스와 자식 클래스에 같은 이름의 함수가 존재해야 
//	있어야(상속) 하며 이를 반드시 자식 클래스에서 override 시켜서 사용해야 한다.

//	추상 클래스는 1개 이상의 순수 가상 함수를 포함하는 불완전한 클래스로 객체를 만들어 사용할 수 없으며 상속을 시킬 목적으로 만들어 사용하는 
//	클래스이다.
//	추상 클래스를 상속받은 클래스는 순수 가상 함수를 반드시 재정의 시켜서 사용해야 하고 순수 가상 함수를 재정의 하지 않으면 추상 클래스를
//	상속받은 클래스 또한 추상 클래스가 되기 때문에 객체를 만들어 사용할 수 없다.
class Shape {
private:
	int x = 0, y = 0;
public:
	Shape() { }
	Shape(int x, int y) {
		this->x = x;
		this->y = y;
	}

//	순수 가상 함수 => 자바에서는 추상 메소드라 부른다.
//	순수 가상 함수는 아무런 이도 하지 않는 함수의 몸체({} 블록)가 없는 함수를 말한다. => 불완전한 함수
//	현재 클래스를 상속받는 자식 클래스에서 무조건 override 시켜 사용해야 하는 함수는 순수 가상 함수로 만들어 사용한다.
//	자식 클래스에서 무조건 override 시켜서 사용한다면 부모 클래스에서 팔아프게 코딩해봐야 어차피 자식 클래스에서 무시되기 때문에 {} 블록을
//	가지지 않는 함수로 만든다.
	void virtual draw() = 0;

};

//	Shape 클래스를 상속받아 Point 클래스를 만든다.
class Point : public Shape {
public:
//	부모(Shape) 클래스에서 상속받은 draw() 순수 가상 함수를 override 하면 일반 클래스가 되므로 객체를 만들어 사용할 수 있다.
	void draw() {
		cout << "점을 찍는다." << endl;
	}
};

//	Shape 클래스를 상속받아 Line 클래스를 만든다.
class Line : public Shape {
public:
	void draw() {
		cout << "선을 그린다." << endl;
	}
};

//	Shape 클래스를 상속받아 Circle 클래스를 만든다.
class Circle : public Shape {
public:
	void draw() {
		cout << "원을 그린다." << endl;
	}
};

//	Shape 클래스를 상속받아 Rectangle 클래스를 만든다.
class Rectangle : public Shape {
public:
	void draw() {
		cout << "사각형을 그린다." << endl;
	}
};

//	Shape 클래스를 상속받아 Triangle 클래스를 만든다.
class Triangle : public Shape {
public:
	void draw() {
		cout << "삼각형을 그린다." << endl;
	}
};

void main() {

//	Shape shape;					// 추상 클래스는 객체를 만들어 사용할 수 없기 때문에 에러가 발생된다.
//	Shape* shape = new Shape();		// 이것도 에러

//	추상 클래스 Shape를 상속받은 Point 클래스도 draw() 순수 가상 함수를 override 하지 않으면 에러가 발생된다.
//	Point point;

//	부모 클래스 타입의 포인터 변수에 자식 클래스 타입의 객체를 대입해서 객체를 생성한 후 다형성을 구현한 함수를 실행한다.
//	Shape* shape = new Point(); 
//	shape->draw();

	Shape* shape[] = { new Point(), new Line(), new Circle(), new Rectangle(), new Triangle() };
	int menu;
	cout << "원하는 작업을 선택하세요 : ";
	cin >> menu;
	shape[menu - 1]->draw();

}
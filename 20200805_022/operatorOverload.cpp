#include "config.h"

class Point {
private:
	int x = 0, y = 0;
public:
	Point() { }
	Point(int x, int y) {
		this->x = x;
		this->y = y;
	}
	void toString() {
		cout << "x = " << x << ", y = " << y << endl;
	}

	/*
	void add(int value) {
		x += value;
		y += value;
	}
	*/

//	연산자 오버로딩(연산자 중복 함수)를 클래스 멤버 함수로 할 경우 제1오퍼랜드는 연산자를 오버로딩하는 클래스 자신이 되고 제2오퍼랜드는
//	인수로 넘겨받는다.

	/*
	Point operator +(int value) {
		Point point;		// 연산 결과를 저장해 리턴시킬 객체를 선언한다.
		point.x = x + value;
		point.y = y + value;
		return point;		// 연산 결과를 리턴한다.
	}
	*/
	/*
	Point operator +(Point p) {
		Point point;
		point.x = x + p.x;
		point.y = y + p.y;
		return point;
	}
	*/

	friend Point operator +(Point, int);
	friend Point operator +(Point, Point);
};

//	연산자 오버로딩을 외부 함수로 할 경우 제1오퍼랜드와 제2오퍼랜드를 모두 인수로 넘겨받아야 한다.
//	외부 함수에서 클래스의 private 멤버 변수에 접근해야 하기 때문에 Point 클래스의 friend로 선언해야 한다.

Point operator +(Point p, int value) {
	Point point;
	point.x = p.x + value;
	point.y = p.y + value;
	return point;
}

Point operator +(Point p1, Point p2) {
	Point point;
	point.x = p1.x + p2.x;
	point.y = p1.y + p2.y;
	return point;
}

void main() {

	Point point1(10, 20);
	point1.toString();				// x = 10, y = 20
//	point1.add(10);
	point1 = point1 + 10;
	point1.toString();				// x = 20, y = 30

	Point point2(20, 10), point3;
	point2.toString();				// x = 20, y = 10
	point3 = point1 + point2;
	point3.toString();				// x = 40, y = 40

}
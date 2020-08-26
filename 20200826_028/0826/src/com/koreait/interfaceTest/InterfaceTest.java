package com.koreait.interfaceTest;

class Point {
	int x, y;
	void move() { }
}

class Shape {
	
//	final을 멤버 변수 선언시 앞에 붙여주면 그 변수는 프로그램에서 값을 변경할 수 없다. => 상수 => 일반적으로 대문자로 만들어 사용한다.
//	final을 메소드 선언시 앞에 붙여주면 그 메소드는 Override 시켜서 사용할 수 없다.
//	final을 클래스 선언시 앞에 붙여주면 그 클래스는 상속시킬 수 없다.
	public static final double PI = 3.141592653589793;		// 정적 멤버 변수, 상수
	public void draw() { }
	public void erase() { }
}

//	자바는 다중 상속을 지원하지 않기 때문에 아래와 같이 상속시키려 하면 에러가 발생된다.
//	class Line extends Point, Shape { }

//	interface란 class의 특별한 형태로 무조건 정적(public static final) 멤버 변수(상수)와 추상 메소드로만 구성된다.
interface Draw {
	
	public static final double PI = 3.141592653589793;		// 정적 멤버 변수, 상수
//	인터페이스는 변수 선언시 앞의 내용을 생략하고 선언해도 컴파일러가 자동으로 public static final을 붙여준다.
	int LIMIT = 1000;
	public abstract void movemove();	// 추상 메소드
//	인터페이스는 메소드 선언시 앞의 내용을 생략하고 선언해도 컴파일러가 자동으로 public abstract을 붙여준다.
	void erase();
//	아래와 같이 인터페이스에 {} 블록을 가지는 일반 메소드를 선언하면 에러가 발생된다.
//	void rotate() { }					// 일반 메소드
	
}

interface Graphic {
	void rotate();
	void resize();
}

//	클래스는 인터페이스를 상속받을 수 없기 때문에 에러가 발생된다.
//	class Line extends Graphic { }

//	인터페이스는 클래스를 상속받을 수 없기 때문에 에러가 발생된다.
//	interface Graphics extends Point { }

//	클래스는 클래스끼리 인터페이스는 인터페이스끼리 상속을 시켜야 한다.
//	클래스는 다중 상속을 허용하지 않지만 인터페이스는 다중 상속을 허용한다.
interface Graphics extends Draw, Graphic {
//	아무런 내용을 가지지 않은 인터페이스를 표시(Marker) 인터페이스라 부른다.
}

//	Line 클래스는 Point 클래스를 상속(extends)받고 Draw, Graphic 인터페이스를 구현(implements)받아 만든다.
class Line extends Point implements Draw, Graphic {

	@Override
	public void rotate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void movemove() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void erase() {
		// TODO Auto-generated method stub
		
	}
	
}

public class InterfaceTest {

	public static void main(String[] args) {
		
//		static으로 선언된 변수나 메소드는 클래스의 객체를 선언하지 않고 클래스 이름에 "."을 찍어서 바로 접근할 수 있다.
		System.out.println("Math.PI = " + Math.PI);
//		final 변수(상수)의 값을 프로그램에서 변경하려 했으므로 에러가 발생된다.
//		Math.PI = 1.23456;			// 에러 발생
		
		System.out.println("Shape.PI = " + Shape.PI);
//		Shape.PI = 1.23456;			// 에러 발생
		Shape shape = new Shape();
		System.out.println("shape.PI = " + shape.PI);
		
		System.out.println("Draw.PI = " + Draw.PI);
		System.out.println("Draw.LIMIT = " + Draw.LIMIT);
		
	}
	
}
















package com.koreait.interfaceTest;

//	표시(Marker) 인터페이스
interface Repairble {
	
}

//	모든 유닛의 최고 조상 클래스 Unit 클래스를 만든다.
class Unit {
//	상수는 반드시 선언과 동시에 초기화를 시켜야 한다.
//	상수를 초기화 시키는 방법은 2가지가 있는데 첫 번째 방법은 상수 선언시 "="을 사용해서 초기화 시키는 방법이고 두 번째 방법은 객체가 
//	생성될 때 생성자에서 초기화 시키는 방법이 있다.	
	final int MAX_HP;	// 최대 HP, 상수
	int currentHp;		// 현재 HP
	
//	모든 유닛은 종류에 따라서 서로 다른 최대 HP를 가져야 하므로 기본 생성자를 사용해서 최대 HP를 초기화 시킬 수 없고 생성자의 인수로
//	최대 HP를 초기화 시킬 값을 넘겨받아서 초기화 시켜야 한다.
//	기본 생성자를 정의하지 않았고 Unit(int hp) 생성자를 만들어 사용했기 때문에 자바 컴파일러가 기본 생성자를 자동으로 만들지 않는다.
	public Unit(int hp) {
//		④ Unit 클래스의 생성자에서 인수로 넘어온 150으로 최대 HP를 초기화 시킨다.
		MAX_HP = hp;
	}
//	⑤ Unit 클래스의 생성자가 종료되면 Unit 클래스의 생성자를 호출한 곳으로 돌아간다.
}

//	Unit 클래스를 상속받아 육상 유닛의 조상 클래스 GroundUnit 클래스를 만든다.
class GroundUnit extends Unit {
	public GroundUnit(int hp) {
//		③ GroundUnit 클래스의 생성자에서 인수로 넘어온 150을 hp 변수에 받아서 부모 클래스(Unit)의 생성자 Unit(int hp)를 호출한다.
		super(hp);
	}
//	⑥ GroundUnit 클래스의 생성자가 종료되면 GroundUnit 클래스의 생성자를 호출한 곳으로 돌아간다.
}

//	Unit 클래스를 상속받아 육상 유닛의 조상 클래스 AirUnit 클래스를 만든다.
class AirUnit extends Unit {
	public AirUnit(int hp) {
		super(hp);
	}
}

//	GroundUnit 클래스를 상속받아 Tank, Marine, SCV 클래스를 만든다.
class Tank extends GroundUnit implements Repairble {
	public Tank() {
//		② Tank 클래스의 기본 생성자가 실행되면 150을 인수로 부모 클래스(GroundUnit)의 생성자 GroundUnit(int hp)를 호출한다.
		super(150);
//		⑦ Tank의 최대 HP가 초기화 되었으므로 현재 HP(currentHp)를 최대 HP(MAX_HP)로 초기화 시킨다.
		currentHp = MAX_HP;		// 최대 HP로 현재 HP를 설정한다.
		System.out.println("Tank의 현재 hp는 " + currentHp + " 입니다.");
	}

	@Override
	public String toString() {
		return "Tank";
	}
	
}

class Marine extends GroundUnit {
	public Marine() {
		super(70);
		currentHp = MAX_HP;
		System.out.println("Marine의 현재 hp는 " + currentHp + " 입니다.");
	}

	@Override
	public String toString() {
		return "Marine";
	}
	
}

class SCV extends GroundUnit implements Repairble {
	public SCV() {
		super(100);
		currentHp = MAX_HP;
		System.out.println("SCV의 현재 hp는 " + currentHp + " 입니다.");
	}
	
//	수리하는 메소드를 만든다.
//	수리하는 메소드는 유닛별로 각각 만들지 않고 실제 수리 기능을 담당하는 유닛인 이곳에 만든다.
	
	
//	오퍼랜드 오버로딩
//	메소드의 인수로 클래스 또는 인터페이스의 객체를 지정하면 인수로 지정된 클래스를 상속받거나 인터페이스를 구현받은 모든 클래스 또는
//	인터페이스 객체만 인수로 받을 수 있다.
	public void repair(Repairble repairble) {
		
//		표시 인터페이스 타입으로 수리할 객체를 받았지만 표시 인터페이스에는 아무 내용이 코딩되어있지 않기 때문에 인수로 넘겨받은 객체를
//		실제로 구현한 내용이 들어있는 클래스로 형변환 시킨 후 처리해야 한다.
		Unit unit = (Unit) repairble;
		
		while (unit.currentHp <= unit.MAX_HP) {
			unit.currentHp++;
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(unit + " 수리 완료!!!");
		
	}

	@Override
	public String toString() {
		return "SCV";
	}
	
}

//	AirUnit 클래스를 상속받아 DropShip 클래스를 만든다.
class DropShip extends AirUnit implements Repairble {
	public DropShip() {
		super(120);
		currentHp = MAX_HP;
		System.out.println("DropShip의 현재 hp는 " + currentHp + " 입니다.");
	}

	@Override
	public String toString() {
		return "DropShip";
	}
	
}

public class MarkerInterfaceTest {

	public static void main(String[] args) {
		
//		① Tank 클래스의 기본 생성자를 실행해 Tank 클래스의 객체를 생성한다.
		Tank tank = new Tank();
		Marine marine = new Marine();
		SCV scv = new SCV();
		DropShip dropShip = new DropShip();
		
		scv.repair(dropShip);
		
	}
	
}











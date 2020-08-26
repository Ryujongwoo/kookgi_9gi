package com.koreait.inheritance;

//	자식(하위, 서브, 파생) 클래스
//	Child 클래스는 Parent 클래스를 상속받아 만든다.
//	상속의 형식 class 자식클래스이름 extends 부모클래스이름
public class Child extends Parent {

	private int age;			// 0으로 기본 초기화
	private String nickname;	// null로 기본 초기화
	
//	자식 클래스의 생성자가 실행되기 전에 부모 클래스의 생성자가 먼저 실행된다.
	public Child() {
//		자식 클래스의 생성자에 별도의 설정을 하지 않으면 무조건 첫 줄에 부모 클래스의 기본 생성자를 실행하는 super()를
//		자바 컴파일러가 자동으로 입력한다. => 부모 클래스에 기본 생성자가 존재하지 않으면 에러가 발생되니 주의하자
		super();
		System.out.println("자식 클래스의 기본 생성자가 실행됩니다.");
	}
	
//	생성자 자동 완성 기능을 사용할 때 현재 클래스에서 물리적으로 정의하지 않은 멤버(상속받은 멤버) 변수는 대화상자에 표시되지
//	않는다. => 부모 클래스에서 상속받은 멤버 변수를 초기화 하기위한 데이터를 받는 인수는 직접 입력해야 한다.
	
	/*
//	부모 클래스에서 상속받은 멤버 변수의 접근 권한이 private일 경우 자식 클래스에서 접근할 수 없으므로 부모 클래스의 생성자를
//	실행해서 초기화 시킨다. => 1번째 방법
	public Child(String name, boolean gender, int age, String nickname) {
//		부모 클래스의 생성자 Parent(String name, boolean gender)를 실행한다.
		super(name, gender);
		this.age = age;
		this.nickname = nickname;
	}
	*/
	/*
//	부모 클래스에서 상속받은 멤버 변수의 접근 권한이 private일 경우 부모 클래스에서 상속받은 setter 메소드가 있다면 상속받은
//	setter 메소드를 실행해서 초기화 시킬 수 있다. => 2번째 방법
	public Child(String name, boolean gender, int age, String nickname) {
		setName(name);
		setGender(gender);
		this.age = age;
		this.nickname = nickname;
	}
	*/
	
//	부모 클래스에서 상속받은 멤버 변수의 접근 권한이 protected일 경우 자식 클래스에서 상속받은 멤버 변수에 접근할 수 있기 때문에
//	this를 사용하는 초기화가 가능해진다. => 3번째 방법
	public Child(String name, boolean gender, int age, String nickname) {
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.nickname = nickname;
	}
	
//	성춘향(여) - 16, 이쁜이
	@Override
	public String toString() {
//		부모 클래스에서 상속받은 private 멤버는 자식 클래스에서도 접근할 수 없으므로 부모 클래스에서 상속받은 private 멤버
//		변수에 저장된 데이터는 상속받은 getter 메소드를 사용해서 데이터를 얻어와야 한다.
//		return getName() + "(" + (isGender() ? "남" : "여") + ") - " + age + ", " + nickname;
		
//		부모 클래스에서 상속받은 메소드에 기능을 추가할 때는 부모 클래스를 의미하는 super 뒤에 "."을 찍고 실행할 메소드 이름을
//		쓰면 된다. => 자식 클래스에서 추가할 기능을 코딩하면 된다. => 부모 클래스의 메소드를 부분적으로 실행할 수 없다.
//		=> 부분적으로 실행하려면 부모 클래스에서 상속받은 메소드를 Override 해서 사용해야 한다.
//		return super.toString() + " - " + age + ", " + nickname;
		
//		부모 클래스에서 상속받은 멤버 변수의 접근 권한이 protected일 경우 자식 클래스에서 접근할 수 있으므로 getter 메소드를
//		사용하지 않고 멤버 변수의 내용을 얻어올 수 있다.
		return name + "(" + (gender ? "남" : "여") + ") - " + age + ", " + nickname;
	}
	
}


















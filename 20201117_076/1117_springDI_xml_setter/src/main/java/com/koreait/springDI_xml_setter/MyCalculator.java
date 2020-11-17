package com.koreait.springDI_xml_setter;

//	사칙연산에 사용할 멤버 변수를 선언하고 Calculator 클래스의 사칙연산 메소드를 호출하는 메소드
public class MyCalculator {

	private int firstNum;
	private int secondNum;
	private Calculator calculator;
	
	public int getFirstNum() {
		return firstNum;
	}
	public void setFirstNum(int firstNum) {
		this.firstNum = firstNum;
	}
	public int getSecondNum() {
		return secondNum;
	}
	public void setSecondNum(int secondNum) {
		this.secondNum = secondNum;
	}
	public Calculator getCalculator() {
		return calculator;
	}
	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}
	
	//	Calculator 클래스 add(), sub(), mul(), div() 메소드를 실행하는 메소드
	public void add() {
		calculator.add(firstNum, secondNum);
	}
	public void sub() {
		calculator.sub(firstNum, secondNum);
	}
	public void mul() {
		calculator.mul(firstNum, secondNum);
	}
	public void div() {
		calculator.div(firstNum, secondNum);
	}
	
	@Override
	public String toString() {
		return "MyCalculator [firstNum=" + firstNum + ", secondNum=" + secondNum + ", calculator=" + calculator + "]";
	}
	
}










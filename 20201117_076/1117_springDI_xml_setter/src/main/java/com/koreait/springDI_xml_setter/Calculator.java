package com.koreait.springDI_xml_setter;

//	MyCalculator 클래스에서 호출되는 firstNum, secondNum을 인수로 넘겨받아 사칙연산을 실행하는 메소드를 모아놓은 메소드
public class Calculator {

	public void add(int firstNum, int secondNum) {
		System.out.print("add() : ");
		int result = firstNum + secondNum;
		System.out.println(firstNum + " + " + secondNum + " = " + result);
	}
	
	public void sub(int firstNum, int secondNum) {
		System.out.print("sub() : ");
		int result = firstNum - secondNum;
		System.out.println(firstNum + " - " + secondNum + " = " + result);
	}
	
	public void mul(int firstNum, int secondNum) {
		System.out.print("mul() : ");
		int result = firstNum * secondNum;
		System.out.println(firstNum + " * " + secondNum + " = " + result);
	}
	
	public void div(int firstNum, int secondNum) {
		System.out.print("div() : ");
		int result = firstNum / secondNum;
		System.out.println(firstNum + " / " + secondNum + " = " + result);
	}
	
}

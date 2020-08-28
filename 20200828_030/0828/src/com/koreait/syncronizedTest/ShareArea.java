package com.koreait.syncronizedTest;

//	공유 영역으로 사용할 클래스
public class ShareArea {

	double result;		// 0.0으로 자동 초기화, 연산 결과를 기억한다.
	boolean ready;		// false로 자동 초기화, CalculatorThread의 계산 완료 여부를 기억한다.
	
}

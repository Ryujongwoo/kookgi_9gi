package com.koreait.syncronizedBlockTest;

//	입출금을 실행하는 스레드 클래스와 잔액을 출력하는 스레드 클래스가 공유해서 사용할 영역
public class ShareArea {

	Account lee = new Account("111-11-11111", "이몽룡", 10000000);
	Account hong = new Account("222-22-22222", "홍길동", 10000000);
	
}

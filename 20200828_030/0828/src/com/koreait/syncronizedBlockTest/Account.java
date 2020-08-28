package com.koreait.syncronizedBlockTest;

//	고객별 계좌 정보를 기억하는 클래스
public class Account {

	String accountNo;		// 계좌번호
	String name;			// 고객이름
	int money;				// 잔고
	
	public Account() { }
	public Account(String accountNo, String name, int money) {
		this.accountNo = accountNo;
		this.name = name;
		this.money = money;
	}
	
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
//	입금 메소드
	public void deposit(int amount) {
		money += amount;
	}
	
//	출금 메소드
	public int withDraw(int amount) {
//		잔액과 비교해서 출금 가능한 경우 출금한다.
		if (amount > money) {
			System.out.println(accountNo + "(" + name + ") 계좌의 잔액이 부족합니다.");
			return 0;
		}
		money -= amount;
		return amount;
	}
	
}
















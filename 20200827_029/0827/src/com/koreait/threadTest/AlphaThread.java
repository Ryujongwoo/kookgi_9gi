package com.koreait.threadTest;

//	Thread 클래스를 상속받고 run() 메소드를 Override 해서 멀티 스레드를 구현한다.
public class AlphaThread extends Thread {

	@Override
	public void run() {
		
//		'a' ~ 'z'를 0.2초 간격으로 출력한다.
		for (char ch = 'a'; ch <= 'z'; ch++) {
			System.out.print(ch);
			try { Thread.sleep(200); } catch (InterruptedException e) { e.printStackTrace(); }
		}
		
	}

}

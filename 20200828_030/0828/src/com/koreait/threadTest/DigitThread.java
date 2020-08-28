package com.koreait.threadTest;

//	Runnable 인터페이스를 구현받고 run() 메소드를 Override 해서 스레드를 구현한다.
public class DigitThread implements Runnable {

	@Override
	public void run() {
		
//		1 ~ 26을 0.2초 간격으로 출력한다.
		for (int i = 1; i <= 26; i++) {
			System.out.print(i);
			try { Thread.sleep(200); } catch (InterruptedException e) { e.printStackTrace(); }
		}

		
	}

}

package com.koreait.syncronizedTest;

//	연산 결과를 출력하는 스레드 클래스, 실행 시간이 짧은 스레드
public class PrintThread extends Thread {

//	공유 영역으로 사용할 클래스 객체를 멤버로 선언한다.
	ShareArea shareArea;
	
	public PrintThread() { }
	public PrintThread(ShareArea shareArea) {
		this.shareArea = shareArea;
	}
	
	public ShareArea getShareArea() {
		return shareArea;
	}
	public void setShareArea(ShareArea shareArea) {
		this.shareArea = shareArea;
	}
	
	@Override
	public void run() {
		
//		CalculatorThread의 실행이 끝날 때 까지 대기한다.
		System.out.print("헉...헉...헉... 겁나게 열심히 계산중...");
		/*
		while (!shareArea.ready) {
			System.out.print(".");
//			스레드는 너무 빠르게 실행되면 정상적으로 처리되지 않기 때문에 sleep() 메소드로 실행을 지연시켜야 한다.
			try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }
		}
		*/
//		위의 주석으로 처리한 부분은 스레드 사이에 불필요한 작업 전환이 이루어진다.
		
//		동기화 블록
//		동기화 블록의 인수는 여러 스레드가 같이 사용하는 공유 영역의 이름을 써줘야 한다.
		synchronized (shareArea) {
			try {
//				wait() : 현재 스레드를 다른 스레드에서 깨울때(notify)까지 멈춘다.
//				wait() 메소드와 notify() 메소드는 반드시 동기화 블록 내부에 코딩해야 하고 공유 영역 객체에서 실행한다.
				shareArea.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("원주율 : " + shareArea.result);
		
	}
	
}










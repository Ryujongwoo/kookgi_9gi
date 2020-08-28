package com.koreait.syncronizedBlockTest;

//	입출금 스레드 클래스
public class TransferThread extends Thread {

	ShareArea shareArea;
	
	public TransferThread() { }
	public TransferThread(ShareArea shareArea) {
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
		
//		동기화란 작업의 순서를 정한다는 의미로 공유 영역을 사용하는 스레드가 실행중일 때 같은 공유 영역을 사용하는
//		다른 스레드가 실행되지 못하도록 하는 것을 말한다. => 스레드 동기화
//		동기화 블록에는 실행중 절대로 작업 전환이 이루어지면 안되는 내용을 코딩한다.
		
		synchronized (shareArea) {
			for (int i = 0; i < 20; i++) {
				shareArea.lee.deposit(1000000);
				System.out.println("이몽룡 계좌 100만원 입금");
				if (shareArea.hong.withDraw(1000000) != 0) {
					System.out.println("홍길동 계좌 100만원 출금");
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}

























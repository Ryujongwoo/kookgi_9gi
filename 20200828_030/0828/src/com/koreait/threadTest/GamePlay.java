package com.koreait.threadTest;

public class GamePlay {

	public static void main(String[] args) {
		
		BGMPlay bgmPlay = new BGMPlay();
//		daemon 스레드는 다른 스레드가 모두 종료되면 같이 종료되는 스레드를 말한다.
		bgmPlay.setDaemon(true);		// 데몬 스레드로 만든다.
		bgmPlay.start();
		
		for (int i = 0; i < 10; i++) {
			System.out.println("신나게 게임을 하는 중.....");
			if (i == 7) {
				System.out.println("앗..... 엄마다.....");
				System.out.println("엄마가 오셔서 게임을 종료합니다.");
				break;
			}
			try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
		}
		
	}
	
}

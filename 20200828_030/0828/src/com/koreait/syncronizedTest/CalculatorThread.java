package com.koreait.syncronizedTest;

import java.text.SimpleDateFormat;

//	연산을 하는 스레드 클래스, 실행 시간이 긴 스레드
public class CalculatorThread extends Thread {

//	공유 영역으로 사용할 클래스 객체를 멤버로 선언한다.
	ShareArea shareArea;
	
	public CalculatorThread() { }
	public CalculatorThread(ShareArea shareArea) {
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
		
//		무한 급수를 이용한 원주율 계산 => 실행 시간이 겁나게 오래 걸린다.
		long startTime = System.currentTimeMillis();		// 계산 시작 시간
		double total = 0.0;
		for (int i = 1; i < 1000000000; i += 2) {
			if (i / 2 % 2 == 0) {
				total += 1.0 / i;
			} else {
				total += -1.0 / i;
			}
		}
		long endTime = System.currentTimeMillis();			// 계산 종료 시간
		
//		System.out.println("계산 시간 : " + (endTime - startTime) / 1000. + "초");
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
//		currentTimeMillis() 메소드를 사용해 얻어온 시간을 연산하면 연산 결과 offset이 포함된다.
//		단순 연산시에는 별 문제가 되지 않지만 SimpleDateFormat 클래스 객체를 사용해 서식을 지정할 경우 9시간이
//		더 나오는 문제가 발생된다.
//		offset은 세계 시간의 기준이 되는 그리니치(영국) 시간을 기준으로 currentTimeMillis() 메소드를 실행한 지역과
//		시간 차이를 1/1000초 단위로 표현한다. => 9 * 60 * 60 * 1000 = 32400000
		System.out.println("\n계산 시간 : " + sdf.format(endTime - startTime - 32400000));

//		System.out.println("원주율 : " + total * 4);
//		연산 결과를 공유 영역의 연산 결과를 기억하는 멤버 변수 result에 넣어준다.
		shareArea.result = total * 4;
//		계산이 완료됨을 알려준다.
		shareArea.ready = true;
		
		synchronized (shareArea) {
//			notify() : wait() 메소드로 일시적으로 중지한 스레드를 다시 실행시킨다.
			shareArea.notify();
		}
		
	}
	
}

















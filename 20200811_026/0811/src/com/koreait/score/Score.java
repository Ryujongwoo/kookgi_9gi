package com.koreait.score;

public class Score {

	public static void main(String[] args) {
		
		/*
		ScoreVO score1 = new ScoreVO();
		System.out.println(score1);
		ScoreVO score2 = new ScoreVO();
		System.out.println(score2);
		
		ScoreVO score3 = new ScoreVO("홍길동", 100, 100, 99);
		System.out.println(score3);
		
		System.out.println("score2.count => " + score2.count);
		score2.count = 100;
		System.out.println("score2.count => " + score2.count);
		System.out.println("score1.count => " + score1.count);
		System.out.println("score3.count => " + score3.count);
		
		ScoreVO score4 = new ScoreVO("임꺽정", 45, 67, 55);
		System.out.println(score4);
		*/
		
		ScoreList scoreList = new ScoreList();
		
		scoreList.addScore(new ScoreVO("홍길동", 100, 100, 99));
		scoreList.addScore(new ScoreVO("임꺽정", 45, 67, 55));
		scoreList.addScore(new ScoreVO("장길산", 87, 79, 85));
		scoreList.addScore(new ScoreVO("일지매", 92, 81, 88));
		scoreList.addScore(new ScoreVO("손오공", 90, 77, 84));
		
		System.out.println(scoreList);
		
	}
	
}













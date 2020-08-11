package com.koreait.score;

import java.util.ArrayList;

public class ScoreList {

	private ArrayList<ScoreVO> scoreList = new ArrayList<ScoreVO>();

	public ArrayList<ScoreVO> getScoreList() {
		return scoreList;
	}
	public void setScoreList(ArrayList<ScoreVO> scoreList) {
		this.scoreList = scoreList;
	}
	
	@Override
	public String toString() {
		
		String str = "";
		str += "=========================================================================\n";
		str += " 번호  이름  java  jsp  spring  총점  평균  석차 \n";
		str += "=========================================================================\n";

//		석차를 계산한다.
		for (int i = 0; i < scoreList.size() - 1; i++) {
			for (int j = i + 1; j < scoreList.size(); j++) {
//				i번째 총점이 크면 j번째 석차를 증가시키고 j번째 총점이 크면 i번째 석차를 증가시킨다.
				if (scoreList.get(i).getTotal() > scoreList.get(j).getTotal()) {
					scoreList.get(j).setRank(scoreList.get(j).getRank() + 1);
				} else if (scoreList.get(i).getTotal() < scoreList.get(j).getTotal()) {
					scoreList.get(i).setRank(scoreList.get(i).getRank() + 1);
				}
			}
		}
		
		for (ScoreVO vo : scoreList) {
			str += vo + "\n";
		}
		
		str += "=========================================================================\n";
		
		return str;
	}
	
	public void addScore(ScoreVO score) {
		scoreList.add(score);
	}
	
}
























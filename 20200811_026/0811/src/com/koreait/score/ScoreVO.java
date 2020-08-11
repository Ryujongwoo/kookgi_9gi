package com.koreait.score;

//	학생 한 명의 성적을 기억하는 클래스
public class ScoreVO {

//	static으로 선언한 변수는 현재 클래스의 객체가 최초로 생성될 때 메모리에 만들어지고 초기화되며 현재 클래스의 객체가 또 생성되더라도 다시
//	생성하지 안는다. => 현재 클래스로 생성한 모든 객체에서 공유해 사용한다. => 클래스 객체를 생성하지 않고 "."을 찍어서 바로 접근할 수 있다.
	public static int count;	// ScoreVO 클래스 객체가 생성될 때 마다 자동으로 1씩 증가하는 변수 => 정적 멤버 변수
//	정적 멤버 변수를 제외한 나머지 멤버 변수를 인스턴스 멤버 변수라 부르고 현재 클래스로 생성하는 모든 객체에서 독립된 기억공간을 가진다.	
	private int idx;			// 번호 => 객체가 생성될 때 마다 1씩 자동으로 증가 시킨다.
	private String name;		// 이름
	private int java;			// java 점수
	private int jsp;			// jsp 점수
	private int spring;			// spring 점수
	private int total;			// 총점
	private double average;		// 평균
	private int rank = 1;		// 석차 => 석차를 기억할 기억장소의 초기치는 무조건 1로 한다.
	
	public ScoreVO() {
//		현재 클래스의 다른 생성자 ScoreVO(String name, int java, int jsp, int spring)를 호출한다.
		this("무명씨", 0, 0, 0);
	}
	public ScoreVO(String name, int java, int jsp, int spring) {
		super();
		idx = ++count;			// 객체가 생성될 때 마다 번호를 1씩 자동으로 증가시킨다.
		this.name = name;
		this.java = java;
		this.jsp = jsp;
		this.spring = spring;
		total = java + jsp + spring;
		average = (double) total / 3;
	}
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getJava() {
		return java;
	}
	public void setJava(int java) {
		this.java = java;
	}
	public int getJsp() {
		return jsp;
	}
	public void setJsp(int jsp) {
		this.jsp = jsp;
	}
	public int getSpring() {
		return spring;
	}
	public void setSpring(int spring) {
		this.spring = spring;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public double getAverage() {
		return average;
	}
	public void setAverage(double average) {
		this.average = average;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	@Override
	public String toString() {
		return String.format("%d %s %3d %3d %3d %3d %6.2f %d", idx, name, java, jsp, spring, total, average, rank);
	}
	
}













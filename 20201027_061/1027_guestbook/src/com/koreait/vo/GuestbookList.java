package com.koreait.vo;

import java.util.ArrayList;

//	1페이지 분량의 글 목록과 페이지 작업에 사용할 8개의 변수를 초기화 시키는 클래스
public class GuestbookList {

//	1페이지 분량의 글(GuestbookVO) 목록을 기억하는 ArrayList
	private ArrayList<GuestbookVO> list = new ArrayList<GuestbookVO>();
//	페이지 작업에 사용할 8개의 변수를 선언한다.
	private int pageSize = 10;
	private int totalCount = 0;
	private int totalPage = 0;
	private int currentPage = 1;
	private int startNo = 0;
	private int endNo = 0;
	private int startPage = 0;
	private int endPage = 0;

	public GuestbookList() { }
//	pageSize, totalCount, currentPage를 인수로 넘겨받아 초기화 시키고 나머지 변수는 계산을 해서 초기화 시키는 생성자
	public GuestbookList(int pageSize, int totalCount, int currentPage) {
		super();
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.currentPage = currentPage;
		calculator();
	}
	
//	pageSize, totalCount, currentPage를 제오이한 나머지 변수의 값을 계산하는 메소드
	private void calculator() {
		totalPage = (totalCount - 1) / pageSize + 1;
		currentPage = currentPage > totalPage ? totalPage : currentPage;
//		oracle은 select sql 명령 실행결과 인덱스 값이 1부터 시작되므로 mysql의 계산식에 1을 더해야 한다.
		startNo = (currentPage - 1) * pageSize + 1;
		endNo = startNo + pageSize - 1;
		endNo = endNo > totalCount ? totalCount : endNo;
		startPage = (currentPage - 1) / 10 * 10 + 1;
		endPage = startPage + 9;
		endPage = endPage > totalPage ? totalPage : endPage;
	}
	
	public ArrayList<GuestbookVO> getList() {
		return list;
	}
	public void setList(ArrayList<GuestbookVO> list) {
		this.list = list;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getStartNo() {
		return startNo;
	}
	public void setStartNo(int startNo) {
		this.startNo = startNo;
	}
	public int getEndNo() {
		return endNo;
	}
	public void setEndNo(int endNo) {
		this.endNo = endNo;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	
	@Override
	public String toString() {
		return "GuestbookList [list=" + list + ", pageSize=" + pageSize + ", totalCount=" + totalCount + ", totalPage="
				+ totalPage + ", currentPage=" + currentPage + ", startNo=" + startNo + ", endNo=" + endNo
				+ ", startPage=" + startPage + ", endPage=" + endPage + "]";
	}
	
}







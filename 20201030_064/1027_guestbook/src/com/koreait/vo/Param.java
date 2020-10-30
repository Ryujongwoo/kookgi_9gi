package com.koreait.vo;

public class Param {

	private int startNo;
	private int endNo;
	private String item;
	private String category;
	
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
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
		return "Param [startNo=" + startNo + ", endNo=" + endNo + ", item=" + item + ", category=" + category + "]";
	}
	
}
